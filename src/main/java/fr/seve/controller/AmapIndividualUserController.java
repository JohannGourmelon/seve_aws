package fr.seve.controller;

import fr.seve.entities.AMAP;
import fr.seve.entities.AmapIndividualUser;
import fr.seve.entities.AmapSpace;
import fr.seve.entities.AmapUser;
import fr.seve.entities.enums.AmapUserRole;
import fr.seve.entities.enums.AmapUserType;
import fr.seve.service.AmapIndividualUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class AmapIndividualUserController {

    @Autowired
    private AmapIndividualUserService amapIndividualUserService;

    /**
     * Afficher le formulaire de création de compte.
     */
    @GetMapping("/{slug}/signup")
    public String showSignupForm(HttpServletRequest request, Model model) {
        // Préparer un objet vide pour le formulaire
        AmapIndividualUser amapIndividualUser = new AmapIndividualUser();
        AmapUser amapUser = new AmapUser();
        amapUser.setRole(AmapUserRole.AMAP_USER);
        amapUser.setType(AmapUserType.INDIVIDUAL);
        amapIndividualUser.setAmapUser(amapUser);

        model.addAttribute("amapIndividualUser", amapIndividualUser);
        return "signup";
    }

    /**
     * Traiter le formulaire de création de compte.
     */
    @PostMapping("/{slug}/signup")
    public String processSignupForm(
            @Valid @ModelAttribute("amapIndividualUser") AmapIndividualUser amapIndividualUser,
            BindingResult result,
            HttpServletRequest request,
            Model model) {

        if (result.hasErrors()) {
            // Si erreurs, retourner au formulaire avec les erreurs
            return "amap-individual-signup";
        }

        try {
            // Associer l'utilisateur à l'espace AMAP récupéré via l'intercepteur
        	AmapSpace amapSpace = ((AMAP) request.getAttribute("amap")).getAmapSpace();
            amapIndividualUser.getAmapUser().setAmapSpace(amapSpace);
            
            // Créer l'utilisateur
            amapIndividualUserService.createIndividualUser(amapIndividualUser);

            // Rediriger vers la page de connexion en cas de succès
            return "redirect:/login?signupSuccess";
        } catch (Exception e) {
            // En cas d'erreur, retourner au formulaire avec un message d'erreur
            model.addAttribute("signupError", "Une erreur s'est produite lors de la création du compte.");
            return "amap-individual-signup";
        }
    }
}
