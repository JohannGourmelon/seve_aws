package fr.seve.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/")
public class HomeController {

	
	@GetMapping
	public String redirectMainPage() {
		return "redirect:/home";
	}


	@GetMapping("/home")
	public String home(Model model) {
		return "home";
	}

}
