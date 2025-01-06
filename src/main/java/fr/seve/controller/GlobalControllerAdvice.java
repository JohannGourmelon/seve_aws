package fr.seve.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import fr.seve.service.AmapService;

import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalControllerAdvice {

    @Autowired
    private AmapService amapService;

    @ModelAttribute
    public void addCommonAttributes(HttpServletRequest request, Model model) {
        // Récupérer l'URL complète de la requête
        String requestURI = request.getRequestURI();
  

        String pathsub = requestURI.substring(5);
        // Supposons que l'URL est sous la forme "/{slug}", donc on peut extraire le slug
        String[] pathParts = pathsub.split("/");
        if (pathParts.length > 1) {
            String slug = pathParts[1];  // Récupère le slug depuis l'URL (première partie après "/")
            
            System.out.println("------------------------------------------------------------- SLUG " + slug);

            // Trouver le subscriptionId avec le slug
            Long subscriptionId = amapService.findSubscriptionIdBySlug(slug);

            // Déterminer les valeurs de showProducts et showActivities
            boolean showProducts = subscriptionId == 2 || subscriptionId == 3;
            boolean showActivities = subscriptionId == 3;

            // Ajouter les attributs au modèle
            model.addAttribute("showProducts", showProducts);
            model.addAttribute("showActivities", showActivities);
        }
    }
}
