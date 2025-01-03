package fr.seve.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import fr.seve.entities.Box;
import fr.seve.entities.Product;
import fr.seve.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService; 
	
	@GetMapping
	public ModelAndView listProducts(Model model) {
		List<Product> products = productService.findAll();
		model.addAttribute("products", products);
		ModelAndView mv = new ModelAndView("product-list");
		mv.addObject("css", "/resources/css/amap/boxList.css");
	    return mv;
	}

	
	
	@GetMapping("/admin")
	public ModelAndView adminListProducts(Model model) {
		List<Product> products = productService.findAll();
		model.addAttribute("products", products);
		ModelAndView mv = new ModelAndView("admin-product-list");
		mv.addObject("css", "/resources/css/amap/boForms.css");
	    return mv;
	}	

	
	
	@GetMapping("{id}")
	public String getProduct(@PathVariable Long id, Model model) {

		Product product = productService.findById(id);
		model.addAttribute("product", product);
		return "product-details";

	}
	
	@GetMapping("/add")
	public String showAddForm(Model model) {
		model.addAttribute("categories", Product.Category.values());
		model.addAttribute("product", new Product());
		return "product-form";
	}
	
	@PostMapping("add")
	public String saveProduct(@ModelAttribute Product product) {
		product.setCreationDate(LocalDate.now());
		productService.save(product);
		return "redirect:/product/admin";
	}

	@GetMapping("/delete/{id}")
	public String deleteProduct(@PathVariable Long id) {
		productService.deleteById(id);
		return "redirect:/product/admin";

	}

	@GetMapping("/edit/{id}")
	public String showEditForm(@PathVariable Long id, Model model) {
		Product product = productService.findById(id);
		model.addAttribute("categories", Product.Category.values());
		model.addAttribute("product", product);
		return "product-form";
	}
	
	@PostMapping("/edit/{id}")
	public String updateProduct(@PathVariable Long id, @ModelAttribute Product product) {
		Product oldProduct = productService.findById(id);
		product.setCreationDate(oldProduct.getCreationDate());
		product.setLastModifiedDate(LocalDate.now());
		productService.save(product);
		return "redirect:/product/admin";
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
