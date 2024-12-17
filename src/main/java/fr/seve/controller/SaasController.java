package fr.seve.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/saas")
public class SaasController {

	@GetMapping
	public String listAmaps() {
		
		return "saas/home";
	}
	
}
