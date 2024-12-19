package fr.seve.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import fr.seve.entities.Subscription;

import fr.seve.service.SubscriptionService;

@Controller
@RequestMapping("/") // http://localhost/mvc/
public class HomeController {

	
	@GetMapping
	public String redirectMainPage() {
		return "redirect:/home";
	}

	@GetMapping("/home")
	public String home(Model model) {

		

		return "home";
	}

	@GetMapping("/home2")
	public ModelAndView home2() {
		ModelAndView mv = new ModelAndView("home2");
        mv.addObject("css", "/resources/css/saas/test.css");
        return mv;
		}

}
