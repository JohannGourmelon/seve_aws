package fr.seve.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.seve.entities.Box;
import fr.seve.entities.Cart;
import fr.seve.service.BoxService;

@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private BoxService boxService;

	@GetMapping
	public String viewCart(HttpSession session, Model model) {
		Cart cart = (Cart) session.getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}

		model.addAttribute("cart", cart);
		return "cart";
	}

	@PostMapping("add")
	public String addToCart(@RequestParam("boxId") Long boxId, HttpSession session) {
		Cart cart = (Cart) session.getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}

		Box box = boxService.findById(boxId);
		cart.addItem(box);

		return "redirect:/cart";
	}
	
	@PostMapping("clear")
	public String clearCart(HttpSession session) {
	    session.removeAttribute("cart");
	    return "redirect:/cart";
	}

}
