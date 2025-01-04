package fr.seve.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import fr.seve.entities.AMAP;

@Controller
public class AmapSlugController {

    
    @GetMapping("/{slug}")
    public String handleAmapSlug(@PathVariable String slug, Model model, HttpServletRequest request) {
        // Récupérer l'AMAP depuis l'intercepteur
        AMAP amap = (AMAP) request.getAttribute("amap");
        if (amap == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "AMAP not found");
        }

        model.addAttribute("amap", amap);
        return "amap-home";
    }
    
    
}
