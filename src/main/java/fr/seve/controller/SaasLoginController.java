package fr.seve.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SaasLoginController {

    @GetMapping("/login") // C'est la route qui affichera votre page de connexion
    public String login() {
        return "saasuser-login"; // Renvoie la vue JSP ou Tiles pour la page de connexion
    }

    @GetMapping("/home")
    public String home() {
        return "home"; // Page d'accueil après connexion
    }
}