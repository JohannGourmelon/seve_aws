package fr.seve.controller;


import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.seve.entities.SaasUser;
import fr.seve.entities.SaasUserLevel;
import fr.seve.service.SaasUserService;

@Controller
@RequestMapping("/saasuser")
public class SaasUserController {
	
	@Autowired
	private SaasUserService service;
	
	@ModelAttribute("saasUser")
	public SaasUser setSaasUser() {
		return new SaasUser();
	}
	
	@GetMapping("/showSignUpForm")
	public String showForm() {
		return "saasuser-signup-form";
		
	}
	
	@PostMapping("/saveSignUpForm")
	public String saveUserSaas (@ModelAttribute("saasUser") SaasUser saasUser, Model model) {
		System.out.println("Firstname : " + saasUser.getFirstname());
        System.out.println("Name : " + saasUser.getName());
        System.out.println("Phone : " + saasUser.getPhone());
        System.out.println("Email : " + saasUser.getEmail());
        System.out.println("Password : " + saasUser.getPassword());
        saasUser.setSaasUserLevel(SaasUserLevel.CUSTOM);
        System.out.println("UserLevel : " + saasUser.getSaasUserLevel());
        saasUser.setCreateDate(LocalDateTime.now().toString());
        System.out.println("DateCreated : " + saasUser.getCreateDate());
        saasUser.setLastModifyDate(LocalDateTime.now().toString());
        System.out.println("DateLastModifyDate : " + saasUser.getLastModifyDate());
        service.save(saasUser);

        model.addAttribute("message", "Inscription Validée !");
        model.addAttribute("saasUser", saasUser);

        return "saasuser-signup-success";
		
	}
	
	@GetMapping
	public String showSuccesForm() {
		return "saasuser-signup-success";
		
	}

}
