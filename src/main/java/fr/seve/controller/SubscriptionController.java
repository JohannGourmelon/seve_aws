package fr.seve.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.seve.entities.Subscription;
import fr.seve.service.SubscriptionService;

@Controller
@RequestMapping("/saasUser")
public class SubscriptionController {
	
	@Autowired
	private SubscriptionService subscriptionService;
	
	@GetMapping("/showSubscriptions")
	public String listSubscriptions (Model model) {
		List<Subscription> subscriptions = subscriptionService.findAll();
//		if (subscriptions.isEmpty()) {
//			subscriptionService.initialize(subscriptions);	
//		}
		model.addAttribute("subscriptions", subscriptions);
		return "saasuser-subscription-list" ; 
		
		
	}
	
	
	

}
