package fr.seve.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import fr.seve.entities.AMAP;
import fr.seve.service.AmapService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class SlugInterceptor implements HandlerInterceptor {

    private final AmapService amapService;

    public SlugInterceptor(AmapService amapService) {
        this.amapService = amapService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // Récupérer l'URL demandée (par exemple "/seve/delphine/box")
        String path = request.getRequestURI().substring(1); // Enlève le premier slash
        System.out.println("URL complète demandée : " + request.getRequestURI()); // Afficher l'URL complète

        // Si l'URL commence par "seve", on l'enlève
        if (path.startsWith("seve/")) {
            path = path.substring(5); // Supprimer "seve/"
            System.out.println("URL après suppression de 'seve/': " + path); // Afficher l'URL après modification
        }

        // Vérifier si l'URL reste avec un slug et un chemin, par exemple "/delphine/box"
        String[] pathParts = path.split("/");

        if (pathParts.length > 1) {
            String slug = pathParts[0]; // Le premier segment est le slug
            System.out.println("Slug extrait : " + slug); // Afficher le slug extrait

            // Récupérer l'AMAP correspondant au slug
            AMAP amap = amapService.findBySlug(slug);
            if (amap == null) {
                System.out.println("AMAP non trouvée pour le slug : " + slug); // Afficher si l'AMAP n'est pas trouvée
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "AMAP not found");
                return false;
            }

            // Ajouter l'AMAP au contexte de la requête
            request.setAttribute("amap", amap);
        } else {
            System.out.println("Aucun slug trouvé dans l'URL"); // Afficher si aucun slug n'est trouvé
        }

        // Si l'URL ne correspond pas à {slug}/**, on ne fait rien
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // Ajouter l'AMAP au modèle de la vue, si elle est présente
        if (modelAndView != null && request.getAttribute("amap") != null) {
            modelAndView.addObject("amap", request.getAttribute("amap"));
        }
    }
}
