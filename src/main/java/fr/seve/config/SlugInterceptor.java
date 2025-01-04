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
        // Récupère l'URL demandée
        String path = request.getRequestURI().substring(1);

        // Supprime "seve/"
        if (path.startsWith("seve/")) {
            path = path.substring(5);
        }

        // Divise l'URL restante en segments
        String[] pathParts = path.split("/");

        // Vérifie s'il y a au moins un segment (slug)
        if (pathParts.length > 0) {
            String slug = pathParts[0]; // Le premier segment est le slug
            System.out.println("Slug extrait : " + slug);

            // Récupère l'AMAP correspondant au slug
            AMAP amap = amapService.findBySlug(slug);
            if (amap == null) {
                System.out.println("AMAP non trouvée pour le slug : " + slug);
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "AMAP not found");
                return false;
            }

            request.setAttribute("amap", amap);
        }
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
