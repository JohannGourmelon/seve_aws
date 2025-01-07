package fr.seve.controller;

import java.time.LocalDateTime;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.seve.entities.Cart;
import fr.seve.entities.CartItem;
import fr.seve.entities.Order;
import fr.seve.entities.OrderItem;
import fr.seve.service.AmapService;
import fr.seve.service.OrderItemService;
import fr.seve.service.OrderService;

@Controller
@RequestMapping("/{slug}/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrderItemService orderItemService;
	
	@PostMapping("add")
	public String validateOrder(@PathVariable String slug, HttpSession session, Model model) {
	    Cart cart = (Cart) session.getAttribute("cart");

	    if (cart == null || cart.getItems().isEmpty()) {
	        model.addAttribute("error", "Votre panier est vide !");
	        return "redirect:/" + slug + "/cart";
	    }

	    Order order = new Order();
        order.setOrderDate(LocalDateTime.now());
        order.setAmapUser(user);

        double totalAmount = 0;

        for (CartItem cartItem : cart.getItems()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setProductId(cartItem.getProductId());
            orderItem.setGenre(cartItem.getGenre());
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setPrice(cartItem.getPrice());
            orderItem.setOrder(order);

            totalAmount += cartItem.getPrice() * cartItem.getQuantity();

            orderItemService.save(orderItem);
	}
        
        orderService.save(order);
	}

}
