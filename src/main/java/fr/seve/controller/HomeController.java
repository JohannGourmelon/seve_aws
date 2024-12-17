package fr.seve.controller;

import java.time.LocalDate;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.seve.entities.SaasUser;
import fr.seve.service.SaasUserService;

@Controller
@RequestMapping("/") // http://localhost/mvc/
public class HomeController {

	@Autowired
	private SaasUserService service;

	@GetMapping
	public String redirectMainPage() {
		return "redirect:/home";
	}

	@GetMapping("/home")
	public String home(Model model) {

		// code de connexion pour la BDD
		SaasUser saasUser = new SaasUser();
		saasUser.setName("Doe");
		saasUser.setEmail("doe@gmail.com");
		saasUser.setPhone("0635847410");
		
		service.save(saasUser);

		// Récupérer tous les adhérents
		model.addAttribute("saasUsers", service.findAll());

		model.addAttribute("message", "HADOKEN !!!");
		return "home";
	}

	@PostMapping
	public String home2() {
		return "home";
	}

}
