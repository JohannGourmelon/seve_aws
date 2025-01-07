package fr.seve.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

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
	
	
	@GetMapping("/success")
	public ModelAndView SuccessPage(Model model) {
		ModelAndView mv = new ModelAndView("amap-payment-success");
		return mv;
	}

	@PostMapping("add")
	public ModelAndView validateOrder(@PathVariable String slug, HttpSession session, Model model) {
		AMAP amap = amapService.findBySlug(slug);
        if (amap == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "AMAP not found");
        }
		AmapSpace amapSpace = amapSpaceService.findById(amap.getId());

		
		Cart cart = (Cart) session.getAttribute("cart");

		if (cart == null || cart.getItems().isEmpty()) {
			model.addAttribute("error", "Votre panier est vide !");
			ModelAndView mv = new ModelAndView("redirect:/" + slug + "/cart");
			return mv;
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
				orderItem.setItemId(cartItem.getProduct().getId());
				break;
			case "BOX":
				orderItem.setItemId(cartItem.getBox().getId());
				break;
			case "ACTIVITY":
				orderItem.setItemId(cartItem.getActivity().getId());
				break;
			}

			totalAmount += cartItem.getPrice() * cartItem.getQuantity();
			order.getOrderItems().add(orderItem);
		}
		
		order.setTotalAmount(totalAmount);
		order.setAmapSpace(amapSpace);
		orderService.save(order);
		
		session.removeAttribute("cart");

		ModelAndView mv = new ModelAndView("amap-payment");
		mv.addObject("order", order);
		mv.addObject("orderItems", order.getOrderItems());
		System.out.println(order.getOrderItems());
		mv.addObject("css", "/resources/css/amap/payment.css");
		return mv;

	}

}
