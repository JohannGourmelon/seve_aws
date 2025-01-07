package fr.seve.controller;

import fr.seve.entities.AMAP;
import fr.seve.entities.AmapIndividualUser;
import fr.seve.entities.AmapProducerUser;
import fr.seve.entities.AmapSpace;
import fr.seve.entities.AmapUser;
import fr.seve.entities.Product;
import fr.seve.entities.enums.AmapUserRole;
import fr.seve.entities.enums.AmapUserType;
import fr.seve.service.AmapIndividualUserService;
import fr.seve.service.AmapProducerUserService;
import fr.seve.service.ProductService;
import fr.seve.service.impl.ProductServiceImpl;
import fr.seve.utils.AmapUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/{slug}/producer")
public class AmapProducerUserController {

    @Autowired
    private AmapProducerUserService amapProducerUserService;
    
    @Autowired
    private ProductService productService;

    
    /**
     * Afficher le formulaire de création de compte.
     */
    @GetMapping("/signup")
    public String showSignupForm(HttpServletRequest request, Model model) {

    	model.addAttribute("slug", AmapUtils.getAmapFromRequest(request).getSlug());
        model.addAttribute("amapProducerUser", new AmapProducerUser());
        return "amap-producer-signup";
    }

    /**
     * Traiter le formulaire de création de compte.
     */
    @PostMapping("/signup")
    public String processSignupForm(
            @Valid @ModelAttribute("amapProducerUser") AmapProducerUser amapProducerUser,
            BindingResult result,
            HttpServletRequest request,
            Model model) {
    	AMAP amap = AmapUtils.getAmapFromRequest(request);
    	String slug = amap.getSlug();
    	model.addAttribute("slug",slug);
    	amapProducerUser.getAmapUser().setRole(AmapUserRole.AMAP_USER);
    	amapProducerUser.getAmapUser().setType(AmapUserType.PRODUCER);
        amapProducerUser.getAmapUser().setAmapSpace(amap.getAmapSpace());

        if (result.hasErrors()) {
        	System.out.println( "Au moins une erreur est présente dans le formulaire.");
        	model.addAttribute("signupError", "Au moins une erreur est présente dans le formulaire.");
            return "amap-producer-signup";
        }

        try {
            amapProducerUserService.createProducerUser(amapProducerUser);
            return "redirect:/{slug}/login";
        } catch (Exception e) {
            model.addAttribute("signupError", "Une erreur s'est produite lors de la création du compte.");
            return "amap-producer-signup";
        }
    }
    
    @GetMapping("/myproducts")
    public String showProducts(HttpServletRequest request, Model model, @ModelAttribute("amapUser") AmapUser amapUser) {
    	model.addAttribute("slug", AmapUtils.getAmapFromRequest(request).getSlug());
        if (amapUser == null || (amapUser.getType() != AmapUserType.PRODUCER)) {
        	return "redirect:/{slug}/login";
        }
        List<Product> products = productService.findByProducerId(amapUser.getProducerUser().getId());
        model.addAttribute("products", products);
    	return "amap-producer-view";
    }
}
