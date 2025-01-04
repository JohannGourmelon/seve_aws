package fr.seve.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import fr.seve.entities.AMAP;

import fr.seve.service.AmapService;


@Controller
public class AmapSlugController {

    private static final List<String> RESERVED_PATHS = List.of("login", "home", "saas", "about", "profile");

    @Autowired
    private AmapService amapService;


    @GetMapping("/{slug}")
    public String handleAmapSlug(@PathVariable String slug, Model model) {
        if (RESERVED_PATHS.contains(slug)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Page not found");
        }

        AMAP amap = amapService.findBySlug(slug);
        if (amap == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "AMAP not found");
        }

        model.addAttribute("amap", amap);
        return "amap-home";
    }
    
    
}
