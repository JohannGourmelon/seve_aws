package fr.seve.controller;

import fr.seve.entities.AMAP;
import fr.seve.entities.AmapIndividualUser;
import fr.seve.entities.AmapSpace;
import fr.seve.entities.AmapUser;
import fr.seve.entities.enums.AmapUserRole;
import fr.seve.entities.enums.AmapUserType;
import fr.seve.service.AmapIndividualUserService;
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

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/{slug}")
public class AmapIndividualUserController {

    @Autowired
    private AmapIndividualUserService amapIndividualUserService;

    private AMAP getAmapFromRequest(HttpServletRequest request) {
        AMAP amap = (AMAP) request.getAttribute("amap");
        if (amap == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "AMAP not found");
        }
        return amap;
    }
    /**
     * Afficher le formulaire de création de compte.
     */
    @GetMapping("/signup")
    public String showSignupForm(HttpServletRequest request, Model model) {

    	model.addAttribute("slug", getAmapFromRequest(request).getSlug());
        model.addAttribute("amapUser", new AmapUser());
        model.addAttribute("amapIndividualUser", new AmapIndividualUser());
        return "amap-individual-signup";
    }

    /**
     * Traiter le formulaire de création de compte.
     */
    @PostMapping("/signup")
    public String processSignupForm(
            @Valid @ModelAttribute("amapIndividualUser") AmapIndividualUser amapIndividualUser,
            @Valid @ModelAttribute("amapUser") AmapUser amapUser,
            BindingResult result,
            HttpServletRequest request,
            Model model) {
    	AMAP amap = getAmapFromRequest(request);
    	String slug = amap.getSlug();
    	model.addAttribute("slug",slug);
    	amapUser.setRole(AmapUserRole.AMAP_USER);
        amapUser.setType(AmapUserType.INDIVIDUAL);
        amapIndividualUser.getAmapUser().setAmapSpace(amap.getAmapSpace());
    	System.out.println("j'arrive ici");
    	System.out.println(amapIndividualUser.getAmapUser().getEmail());
    	System.out.println(amapIndividualUser.getAmapUser().getName());
    	System.out.println(amapIndividualUser.getAmapUser().getFirstname());
    	System.out.println(amapIndividualUser.getAmapUser().getPassword());
    	System.out.println(amapIndividualUser.isVolunteer());
    	System.out.println(amapUser.getType());
    	System.out.println(amapIndividualUser.getAmapUser().getAmapSpace());
        if (result.hasErrors()) {
        	System.out.println( "Au moins une erreur est présente dans le formulaire.");
            // Si erreurs, retourner au formulaire avec les erreurs
        	model.addAttribute("signupError", "Au moins une erreur est présente dans le formulaire.");
            return "amap-individual-signup";
        }

        try {
        	System.out.println( "Au moins j'essaye");
            // Créer l'utilisateur
            amapIndividualUserService.createIndividualUser(amapIndividualUser);

            // Rediriger vers la page de connexion en cas de succès
            return "redirect:/{slug}/login";
        } catch (Exception e) {
            // En cas d'erreur, retourner au formulaire avec un message d'erreur
            model.addAttribute("signupError", "Une erreur s'est produite lors de la création du compte.");
            return "amap-individual-signup";
        }
    }
    
}
