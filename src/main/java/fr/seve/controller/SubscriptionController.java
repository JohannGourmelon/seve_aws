package fr.seve.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.seve.entities.Subscription;
import fr.seve.service.SubscriptionService;

@Controller
@RequestMapping("/saasuser")
public class SubscriptionController {
	
	@Autowired
	private SubscriptionService service;
	
	
	
	
	
	

}
