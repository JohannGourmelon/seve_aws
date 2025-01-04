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
        String path = request.getRequestURI().substring(1); // Enlever le slash initial

        // Si l'URL commence par "seve/", retirez cette partie
        if (path.startsWith("seve/")) {
            path = path.substring(5); // "seve/" a une longueur de 5, donc on enlève les 5 premiers caractères
        }

        System.out.println("Slug reçu après retrait du préfixe : " + path);

        // Logique pour traiter les slugs dynamiques
        AMAP amap = amapService.findBySlug(path);
        if (amap == null) {
            System.out.println("AMAP non trouvée pour le slug : " + path);
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "AMAP not found");
            return false;
        }

        System.out.println("AMAP trouvée : " + amap.getName());
        request.setAttribute("amap", amap);
        return true;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (modelAndView != null && request.getAttribute("amap") != null) {
            modelAndView.addObject("amap", request.getAttribute("amap"));
        }
    }
}
