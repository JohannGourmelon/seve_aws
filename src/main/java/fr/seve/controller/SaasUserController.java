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
import fr.seve.entities.Subscription;
import fr.seve.service.SaasUserService;
import fr.seve.service.SubscriptionService;

@Controller
@RequestMapping("/saasuser")
public class SaasUserController {
	
	@Autowired
	private SaasUserService service;
	
	@Autowired
	private SubscriptionService subscriptionService;
	
	@ModelAttribute("saasUser")
	public SaasUser setSaasUser() {
		return new SaasUser();
	}
	
	@GetMapping("/showSignUpForm")
	public String showForm() {
		return "saasuser-signup-form";
		
	}
	
	@PostMapping("/saveSignUpEssential")
	public String saveUserSaasEssential (@ModelAttribute("saasUser") SaasUser saasUser, Model model) {
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
        
        Subscription essential = subscriptionService.findById(1l);
        saasUser.setSubscription(essential);
        
        service.save(saasUser);
   

        return "saasuser-subscription-list";
		
	}
	
	@PostMapping("/saveSignUpStandard")
	public String saveUserSaasStandard (@ModelAttribute("saasUser") SaasUser saasUser, Model model) {
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
        
        Subscription standard = subscriptionService.findById(2l);
        saasUser.setSubscription(standard);
        
        service.save(saasUser);
   

        return "saasuser-subscription-list";
		
	}
	
	@PostMapping("/saveSignUpPremi")
	public String saveUserSaasPremium (@ModelAttribute("saasUser") SaasUser saasUser, Model model) {
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
        
        Subscription premium = subscriptionService.findById(3l);
        saasUser.setSubscription(premium);
        
        service.save(saasUser);
   

        return "saasuser-subscription-list";
		
	}
	
	

	
	
	@GetMapping
	public String showSuccesForm() {
		return "saasuser-signup-success";
		
	}

}
