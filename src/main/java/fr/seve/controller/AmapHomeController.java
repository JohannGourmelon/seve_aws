package fr.seve.controller;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import fr.seve.utils.AmapUtils;


@Controller
public class AmapHomeController {
	
    
    @GetMapping("/{slug}")
    public String handleAmapSlug(Model model, HttpServletRequest request) {
    	model.addAttribute("amap", AmapUtils.getAmapFromRequest(request));
    	return "amap-home";
    }
    
    @Secured({"ROLE_AMAP_USER","ROLE_AMAP_MEMBER","ROLE_AMAP_ADMIN","ROLE_AMAP_SUPERVISOR"})
    @GetMapping("/{slug}/dashboard")
    public String myAccount(Model model, HttpServletRequest request) {
    	model.addAttribute("amap", AmapUtils.getAmapFromRequest(request));
    	return "amap-account";
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
