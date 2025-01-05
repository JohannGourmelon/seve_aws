package fr.seve.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import fr.seve.entities.AMAP;
import fr.seve.entities.Box;
import fr.seve.entities.Product;
import fr.seve.service.AmapService;
import fr.seve.service.ProductService;

@Controller
@RequestMapping("/{slug}/product")
public class ProductController {

	@Autowired
	private ProductService productService; 
	
	@Autowired
	private AmapService amapService;
	
	@GetMapping
	public ModelAndView listProducts(@PathVariable String slug, Model model) {
		AMAP amap = amapService.findBySlug(slug);
        if (amap == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "AMAP not found");
        }
        
		List<Product> products = productService.findAll();
		model.addAttribute("products", products);
		ModelAndView mv = new ModelAndView("product-list");
		mv.addObject("css", "/resources/css/amap/boxList.css");
	    return mv;
	}

	
	
	@GetMapping("/admin")
	public ModelAndView adminListProducts(@PathVariable String slug, Model model) {
		AMAP amap = amapService.findBySlug(slug);
        if (amap == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "AMAP not found");
        }
        
		List<Product> products = productService.findAll();
		model.addAttribute("products", products);
		ModelAndView mv = new ModelAndView("admin-product-list");
		mv.addObject("css", "/resources/css/amap/boForms.css");
	    return mv;
	}	

	
	
	@GetMapping("{id}")
	public String getProduct(@PathVariable String slug, @PathVariable Long id, Model model) {
		AMAP amap = amapService.findBySlug(slug);
        if (amap == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "AMAP not found");
        }

		Product product = productService.findById(id);
		model.addAttribute("product", product);
		return "product-details";
	}
	
	@GetMapping("/add")
	public String showAddForm(@PathVariable String slug, Model model) {
		AMAP amap = amapService.findBySlug(slug);
        if (amap == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "AMAP not found");
        }
        
		model.addAttribute("categories", Product.Category.values());
		model.addAttribute("product", new Product());
		return "product-form";
	}
	
	@PostMapping("add")
	public String saveProduct(@PathVariable String slug, @ModelAttribute Product product) {
		AMAP amap = amapService.findBySlug(slug);
        if (amap == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "AMAP not found");
        }
        
		product.setCreationDate(LocalDate.now());
		productService.save(product);
		return "redirect:/{slug}/product/admin";
	}

	@GetMapping("/delete/{id}")
	public String deleteProduct(@PathVariable String slug, @PathVariable Long id) {
		AMAP amap = amapService.findBySlug(slug);
        if (amap == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "AMAP not found");
        }
        
		productService.deleteById(id);
		return "redirect:/{slug}/product/admin";
	}

	@GetMapping("/edit/{id}")
	public String showEditForm(@PathVariable String slug, @PathVariable Long id, Model model) {
		AMAP amap = amapService.findBySlug(slug);
        if (amap == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "AMAP not found");
        }
        
		Product product = productService.findById(id);
		model.addAttribute("categories", Product.Category.values());
		model.addAttribute("product", product);
		return "product-form";
	}
	
	@PostMapping("/edit/{id}")
	public String updateProduct(@PathVariable String slug, @PathVariable Long id, @ModelAttribute Product product) {
		AMAP amap = amapService.findBySlug(slug);
        if (amap == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "AMAP not found");
        }
        
		Product oldProduct = productService.findById(id);
		product.setCreationDate(oldProduct.getCreationDate());
		product.setLastModifiedDate(LocalDate.now());
		productService.save(product);
		return "redirect:/{slug}/product/admin";
	}
	
}
