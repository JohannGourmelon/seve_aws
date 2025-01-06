package fr.seve.controller;

import javax.servlet.http.HttpServletRequest;

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
public class AmapSpaceController {
	
    @Autowired
    private AmapService amapService;
	
    @GetMapping("/{slug}")
    public String handleAmapSlug(@PathVariable String slug, Model model, HttpServletRequest request) {
        AMAP amap = (AMAP) request.getAttribute("amap");
        if (amap == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "AMAP not found");
        }
        
        Long id = amapService.findSubcriptionIdBySlug(slug);
        System.out.println("-------------------------------- ID FORFAIT : " + id);

        model.addAttribute("amap", amap);
        return "amap-home";
    }
	
}
