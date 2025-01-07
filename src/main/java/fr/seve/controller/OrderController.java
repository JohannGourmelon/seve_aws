package fr.seve.controller;

import java.time.LocalDateTime;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import fr.seve.entities.AMAP;
import fr.seve.entities.AmapSpace;
import fr.seve.entities.AmapUser;
import fr.seve.entities.Cart;
import fr.seve.entities.CartItem;
import fr.seve.entities.Order;
import fr.seve.entities.OrderItem;
import fr.seve.service.AmapService;
import fr.seve.service.AmapSpaceService;
import fr.seve.service.AmapUserService;
import fr.seve.service.OrderItemService;
import fr.seve.service.OrderService;

@Controller
@RequestMapping("/{slug}/order")
public class OrderController {
	
	@Autowired
	private AmapService amapService;
	
	@Autowired
	private AmapSpaceService amapSpaceService;

	@Autowired
	private OrderService orderService;

	@PostMapping("add")
	public String validateOrder(@PathVariable String slug, HttpSession session, Model model) {
		AMAP amap = amapService.findBySlug(slug);
        if (amap == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "AMAP not found");
        }
		AmapSpace amapSpace = amapSpaceService.findById(amap.getId());

		
		Cart cart = (Cart) session.getAttribute("cart");

		if (cart == null || cart.getItems().isEmpty()) {
			model.addAttribute("error", "Votre panier est vide !");
			return "redirect:/" + slug + "/cart";
		}

		Order order = new Order();
		order.setOrderDate(LocalDateTime.now());

		double totalAmount = 0;

		for (CartItem cartItem : cart.getItems()) {
			OrderItem orderItem = new OrderItem();
			orderItem.setGenre(cartItem.getGenre());
			orderItem.setQuantity(cartItem.getQuantity());
			orderItem.setPrice(cartItem.getPrice());
			orderItem.setOrder(order);

			switch (cartItem.getGenre()) {
			case "PRODUCT":
				orderItem.setProductId(cartItem.getId());
				break;
			case "BOX":
				orderItem.setProductId(cartItem.getId());
				break;
			case "ACTIVITY":
				orderItem.setProductId(cartItem.getId());
				break;
			}

			totalAmount += cartItem.getPrice() * cartItem.getQuantity();
			order.getOrderItems().add(orderItem);
		}
		
		order.setTotalAmount(totalAmount);
		order.setAmapSpace(amapSpace);
		orderService.save(order);

		return "redirect:/" + slug + "/cart";

	}

}
