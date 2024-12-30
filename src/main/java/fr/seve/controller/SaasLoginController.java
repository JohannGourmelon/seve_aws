package fr.seve.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SaasLoginController {

	 @GetMapping("/profile")
	    public String profile(Model model) {
	        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

	        if (authentication == null || !authentication.isAuthenticated() || "anonymousUser".equals(authentication.getPrincipal())) {
	            return "redirect:/login"; // Redirige vers la page de connexion si non authentifié
	        }

	        model.addAttribute("username", authentication.getName()); // Récupère le nom d'utilisateur
	        return "profile"; // Nom de la vue JSP
	    }


	 @GetMapping("/login")
	 public String login() {
		 return "saasuser-login";
	 }
	 
    @GetMapping("/home")
    public String home() {
        return "home"; // Page d'accueil après connexion
    }
}