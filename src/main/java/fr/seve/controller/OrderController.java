package fr.seve.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
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
import fr.seve.entities.Activity;
import fr.seve.entities.AmapSpace;
import fr.seve.entities.AmapUser;
import fr.seve.entities.Box;
import fr.seve.entities.Cart;
import fr.seve.entities.CartItem;
import fr.seve.entities.Order;
import fr.seve.entities.OrderItem;
import fr.seve.entities.Product;
import fr.seve.entities.enums.AmapUserType;
import fr.seve.service.AmapService;
import fr.seve.service.AmapSpaceService;
import fr.seve.service.AmapUserService;
import fr.seve.service.OrderItemService;
import fr.seve.service.OrderService;
import fr.seve.utils.AmapUtils;

@Controller
@RequestMapping("/{slug}/order")
public class OrderController {
	
	@Autowired
	private AmapService amapService;
	
	@Autowired
	private AmapSpaceService amapSpaceService;

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrderItemService orderItemService;
	
	
	@GetMapping("/success")
	public ModelAndView SuccessPage(Model model) {
		ModelAndView mv = new ModelAndView("amap-payment-success");
		
		return mv;
	}

	@PostMapping("add")
	public ModelAndView validateOrder(@PathVariable String slug, HttpSession session, Model model,
			@ModelAttribute("amapUser") AmapUser amapUser) {
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
				orderItem.setName(cartItem.getProduct().getName());
				break;
			case "BOX":
				orderItem.setItemId(cartItem.getBox().getId());
				orderItem.setName(cartItem.getBox().getName());

				break;
			case "ACTIVITY":
				orderItem.setItemId(cartItem.getActivity().getId());
				orderItem.setName(cartItem.getActivity().getName());
				break;
			}

			totalAmount += cartItem.getPrice() * cartItem.getQuantity();
			order.getOrderItems().add(orderItem);
		}
		
		order.setTotalAmount(totalAmount);
		order.setAmapSpace(amapSpace);
		order.setAmapUser(amapUser);
		orderService.save(order);
		
		session.removeAttribute("cart");

		ModelAndView mv = new ModelAndView("amap-payment");
		mv.addObject("order", order);
		mv.addObject("orderItems", order.getOrderItems());
		mv.addObject("css", "/resources/css/amap/payment.css");
		return mv;

	}
	
	@Secured({"ROLE_AMAP_USER","ROLE_AMAP_MEMBER","ROLE_AMAP_ADMIN","ROLE_AMAP_SUPERVISOR"})
    @GetMapping("/list")
    public String showOrders(HttpServletRequest request, Model model, @ModelAttribute("amapUser") AmapUser amapUser) {
		
    	model.addAttribute("slug", AmapUtils.getAmapFromRequest(request).getSlug());
        if (amapUser == null) {
        	return "redirect:/{slug}/login";
        }

        List<Order> orders = orderService.findByUserId(amapUser.getId());
        model.addAttribute("orders", orders);

    	return "amap-order-list";
    }
	
	@Secured({"ROLE_AMAP_USER","ROLE_AMAP_MEMBER","ROLE_AMAP_ADMIN","ROLE_AMAP_SUPERVISOR"})
    @GetMapping("/{id}")
    public String showDetailsOrder(HttpServletRequest request, Model model,@PathVariable Long id, @ModelAttribute("amapUser") AmapUser amapUser) {
		
    	model.addAttribute("slug", AmapUtils.getAmapFromRequest(request).getSlug());
        if (amapUser == null) {
        	return "redirect:/{slug}/login";
        }
        
        Order order = orderService.findById(id);
        List<OrderItem> orderItems = orderItemService.findByOrderId(order.getId());
        model.addAttribute("order", order);
        model.addAttribute("orderItems", orderItems);

    	return "amap-order-details";
    }

}
