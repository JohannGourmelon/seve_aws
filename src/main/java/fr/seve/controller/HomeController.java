package fr.seve.controller;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import fr.seve.entities.SaasUser;
import fr.seve.entities.SaasUserLevel;
import fr.seve.entities.Subscription;
import fr.seve.service.SaasUserService;
import fr.seve.service.SubscriptionService;

@Controller
@RequestMapping("/") // http://localhost/mvc/
public class HomeController {

	@Autowired
	private SubscriptionService subscriptionService;

	@GetMapping
	public String redirectMainPage() {
		return "redirect:/home";
	}

	@GetMapping("/home")
	public String home(Model model) {

		List<Subscription> subscriptions = subscriptionService.findAll();
		if (subscriptions.isEmpty()) {
			subscriptionService.initialize(subscriptions);	
		}
		model.addAttribute("subscriptions", subscriptions);
		
//		// code de connexion pour la BDD
//		SaasUser saasUser = new SaasUser();
//		saasUser.setName("Doe");
//		saasUser.setFirstname("Jonh");
//		saasUser.setEmail("doe@gmail.com");
//		saasUser.setPassword("password");
//		saasUser.setPhone("0635847410");
//		saasUser.setCreateDate(LocalDateTime.now().toString());
//		saasUser.setLastModifyDate(LocalDateTime.now().toString());
//		saasUser.setSaasUserLevel(SaasUserLevel.ADMIN);
//		service.save(saasUser);
//
//		// Récupérer tous les adhérents
//		model.addAttribute("saasUsers", service.findAll());
//
//		model.addAttribute("message", "HADOKEN !!!");
		return "home";
	}

	@GetMapping("/home2")
	public ModelAndView home2() {
		ModelAndView mv = new ModelAndView("home2");
        mv.addObject("css", "/resources/css/saas/test.css");
        return mv;
		}

}
