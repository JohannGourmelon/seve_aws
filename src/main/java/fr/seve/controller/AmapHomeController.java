package fr.seve.controller;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;
import fr.seve.entities.AMAP;
import fr.seve.utils.AmapUtils;


@Controller
public class AmapHomeController {
	
    
    @GetMapping("/{slug}")
    public String handleAmapSlug(@PathVariable String slug, Model model, HttpServletRequest request) {
    	AMAP amap = (AMAP) request.getAttribute("amap");
    	if (amap == null) {
    		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "AMAP not found");
    	}
    	
    	model.addAttribute("amap", amap);
    	return "amap-home";
    }
    
    /**
     * Afficher le type de compte à créer
     */
    
    @GetMapping("/{slug}/signup")
    public String showSignupForm(HttpServletRequest request, Model model) {

    	 List<Map.Entry<String, String>> types = List.of(
    		        new AbstractMap.SimpleEntry<>("individual", "Particulier"),
    		        new AbstractMap.SimpleEntry<>("works-comittee", "Comité d'entreprise"),
    		        new AbstractMap.SimpleEntry<>("producer", "Producteur")
    		    );

    		    model.addAttribute("types", types);
    	model.addAttribute("slug", AmapUtils.getAmapFromRequest(request).getSlug());
        return "amap-signup";
    }   
}
