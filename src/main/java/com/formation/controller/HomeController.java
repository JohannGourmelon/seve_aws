package com.formation.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/") // http://localhost/mvc/
public class HomeController {
	
//	@Autowired
//	private AdherentService service;
	
	@GetMapping
	public String redirectMainPage() {
		return "redirect:/home";
	}
	
	
	@GetMapping("/home")
	public String home(Model model) {
		
//		// code de connexion pour la BDD
//		Adherent adherent = new Adherent();
//		adherent.setNom("Doe");
//		adherent.setEmail("doe@gmail.com");
//		adherent.setType("Particulier");
//		
//		service.save(adherent);
//		
//		
//		// Récupérer tous les adhérents
//		model.addAttribute("adherents", service.findAll());
//		
//		model.addAttribute("message","HADOKEN !!!");
		return "home";
	}
	
	@PostMapping
	public String home2() {
		return "home";
	}

}
