package fr.seve.controller;


import java.time.LocalDateTime;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
	public ModelAndView showForm() {
		ModelAndView mv = new ModelAndView("saasuser-signup-form");
        mv.addObject("css", "/resources/css/saas/signup-form.css");
        return mv;
		
	}
	
	@GetMapping("/souscription-essentiel")
	public ModelAndView showFormEs() {
		ModelAndView mv = new ModelAndView("saas-signup-es");
        mv.addObject("css", "/resources/css/saas/signup-form.css");
        return mv;	
	}
	
	@GetMapping("/souscription-standard")
	public ModelAndView showFormSt() {
		ModelAndView mv = new ModelAndView("saas-signup-st");
        mv.addObject("css", "/resources/css/saas/signup-form.css");
        return mv;
	}
	
	@GetMapping("/souscription-premium")
	public ModelAndView showFormPr() {
		ModelAndView mv = new ModelAndView("saas-signup-pr");
        mv.addObject("css", "/resources/css/saas/signup-form.css");
        return mv;
	}
	
	
	@PostMapping("/saveSignUpEssential")
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
        
        Subscription essential = subscriptionService.findById(1l);
        saasUser.setSubscription(essential);
        
        service.save(saasUser);
   

        return "saasuser-signup-success";
		
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
   

        return "saasuser-signup-success";
		
	}
	
	@PostMapping("/saveSignUpPremium")
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
   

        return "saasuser-signup-success";
		
	}
	
	

	
	
	@GetMapping
	public String showSuccesForm() {
		return "saasuser-signup-success";
		
	}

}
