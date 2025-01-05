package fr.seve.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import fr.seve.entities.AMAP;
import fr.seve.entities.Box;
import fr.seve.entities.Cart;
import fr.seve.service.AmapService;
import fr.seve.service.BoxService;

@Controller
@RequestMapping("/{slug}/cart")
public class CartController {

	@Autowired
	private BoxService boxService;
	
	@Autowired
	private AmapService amapService;

	@GetMapping
	public String viewCart(@PathVariable String slug, HttpSession session, Model model) {
		AMAP amap = amapService.findBySlug(slug);
        if (amap == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "AMAP not found");
        }
        
		Cart cart = (Cart) session.getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}

		model.addAttribute("cart", cart);
		return "cart";
	}

	@PostMapping("add")
	public String addToCart(@PathVariable String slug, @RequestParam("boxId") Long boxId, HttpSession session) {
		AMAP amap = amapService.findBySlug(slug);
        if (amap == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "AMAP not found");
        }
        
		Cart cart = (Cart) session.getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}

		Box box = boxService.findById(boxId);
		cart.addItem(box);

		return "redirect:/{slug}/cart";
	}
	
	@PostMapping("clear")
	public String clearCart(@PathVariable String slug, HttpSession session) {
		AMAP amap = amapService.findBySlug(slug);
        if (amap == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "AMAP not found");
        }
        
	    session.removeAttribute("cart");
	    return "redirect:/{slug}/cart";
	}
	
	@PostMapping("update")
	public String updateQuantity(@PathVariable String slug, @RequestParam("boxId") Long boxId, 
	                             @RequestParam("quantity") int quantity, 
	                             HttpSession session) {
		AMAP amap = amapService.findBySlug(slug);
        if (amap == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "AMAP not found");
        }
        
	    Cart cart = (Cart) session.getAttribute("cart");
	    if (cart != null) {
	        cart.updateQuantity(boxId, quantity);
	    }
	    return "redirect:/{slug}/cart";
	}

	@PostMapping("remove")
	public String removeItem(@PathVariable String slug, @RequestParam("boxId") Long boxId, HttpSession session) {
		AMAP amap = amapService.findBySlug(slug);
        if (amap == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "AMAP not found");
        }
        
	    Cart cart = (Cart) session.getAttribute("cart");
	    if (cart != null) {
	        cart.removeItem(boxId);
	    }
	    return "redirect:/{slug}/cart";
	}

}
