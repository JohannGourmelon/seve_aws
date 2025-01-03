package fr.seve.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class SaasLoginController {

	 @GetMapping("/profile")
	    public ModelAndView profile(Model model) {
	        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

	        if (authentication == null || !authentication.isAuthenticated() || "anonymousUser".equals(authentication.getPrincipal())) {
	        	return new ModelAndView("redirect:/login"); // Redirige vers la page de connexion si non authentifié
	        }

	        model.addAttribute("username", authentication.getName()); // Récupère le nom d'utilisateur
	        ModelAndView mv = new ModelAndView("profile");
	        mv.addObject("css", "/resources/css/saas/config.css");
	        return mv;
	    }


	 @GetMapping("/login")
	 public String login(Model model, @RequestParam(value = "error", required = false) String error) {
	     if (error != null) {
	         model.addAttribute("error", "Nom d'utilisateur ou mot de passe incorrect.");
	     }
	     return "saasuser-login"; 
	 }

}