package fr.seve.controller;

import java.time.LocalDateTime;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.seve.entities.AMAP;
import fr.seve.entities.AmapSpace;
import fr.seve.entities.Configuration;
import fr.seve.entities.SaasUser;
import fr.seve.entities.SaasUserLevel;
import fr.seve.entities.Subscription;

import fr.seve.service.AmapService;
import fr.seve.service.AmapSpaceService;
import fr.seve.service.ConfigurationService;
import fr.seve.service.SaasUserService;
import fr.seve.service.SubscriptionService;

@Controller
@RequestMapping("/saasuser")
public class SaasUserController {

	@Autowired
	private SaasUserService service;

	@Autowired
	private AmapSpaceService amapSpaceService;

	@Autowired
	private SubscriptionService subscriptionService;

	@ModelAttribute("saasUser")
	public SaasUser setSaasUser() {
		return new SaasUser();
	}

	@GetMapping("/showSignUpForm")
	public ModelAndView showForm() {
		ModelAndView mv = new ModelAndView("saasuser-signup-form");
		mv.addObject("css", "/resources/css/saas/signup-form.css");
		return mv;

	}

	@GetMapping("/souscription-essentiel")
	public ModelAndView showFormEs() {
		ModelAndView mv = new ModelAndView("saas-signup-es");
		mv.addObject("css", "/resources/css/saas/signup-form.css");
		return mv;
	}

	@GetMapping("/souscription-standard")
	public ModelAndView showFormSt() {
		ModelAndView mv = new ModelAndView("saas-signup-st");
		mv.addObject("css", "/resources/css/saas/signup-form.css");
		return mv;
	}

	@GetMapping("/souscription-premium")
	public ModelAndView showFormPr() {
		ModelAndView mv = new ModelAndView("saas-signup-pr");
		mv.addObject("css", "/resources/css/saas/signup-form.css");
		return mv;
	}

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {

		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@PostMapping("/saveSignUpEssential")
	public ModelAndView saveUserSaas(@Valid @ModelAttribute("saasUser") SaasUser saasUser, BindingResult bindingResult,
			Model model) {

		System.out.println("Firstname : " + saasUser.getFirstname());
		System.out.println("Name : " + saasUser.getName());
		System.out.println("Phone : " + saasUser.getPhone());
		System.out.println("Email : " + saasUser.getEmail());
		System.out.println("Password : " + saasUser.getPassword());
		saasUser.setSaasUserLevel(SaasUserLevel.CUSTOM);
		System.out.println("UserLevel : " + saasUser.getSaasUserLevel());
		saasUser.setCreateDate(LocalDateTime.now().toString());
		System.out.println("DateCreated : " + saasUser.getCreateDate());
		saasUser.setLastModifyDate(LocalDateTime.now().toString());
		System.out.println("DateLastModifyDate : " + saasUser.getLastModifyDate());

		Subscription essential = subscriptionService.findById(1l);
		saasUser.setSubscription(essential);

		if (bindingResult.hasErrors()) {
			// Si des erreurs de validation sont présentes, retour à la page du formulaire

			ModelAndView mv = new ModelAndView("saas-signup-es");
			mv.addObject("css", "/resources/css/saas/signup-form.css");
			mv.addObject("saasUser", saasUser); // renvoie le user pour garder les informations saisies
			mv.addObject("errors", bindingResult.getAllErrors()); // renvoie les erreurs
			return mv;

		} else {

			// Création du user avec une amap, une configuration et un espace AMAP
			AMAP amap = new AMAP();
			amap.setSaasUser(saasUser);
			saasUser.setAmap(amap);

			Configuration configuration = new Configuration();

			AmapSpace amapSpace = new AmapSpace();
			amapSpace.setAmap(amap);
			amapSpace.setConfiguration(configuration);
			amapSpace.setSubscription(essential);

			amapSpaceService.save(amapSpace);
			service.save(saasUser);

			ModelAndView mv = new ModelAndView("saasuser-signup-payment");
			mv.addObject("css", "/resources/css/saas/payment.css");
			return mv;

		}

	}

	@PostMapping("/saveSignUpStandard")
	public ModelAndView saveUserSaasStandard(@Valid @ModelAttribute("saasUser") SaasUser saasUser, BindingResult bindingResult, Model model) {
		System.out.println("Firstname : " + saasUser.getFirstname());
		System.out.println("Name : " + saasUser.getName());
		System.out.println("Phone : " + saasUser.getPhone());
		System.out.println("Email : " + saasUser.getEmail());
		System.out.println("Password : " + saasUser.getPassword());
		saasUser.setSaasUserLevel(SaasUserLevel.CUSTOM);
		System.out.println("UserLevel : " + saasUser.getSaasUserLevel());
		saasUser.setCreateDate(LocalDateTime.now().toString());
		System.out.println("DateCreated : " + saasUser.getCreateDate());
		saasUser.setLastModifyDate(LocalDateTime.now().toString());
		System.out.println("DateLastModifyDate : " + saasUser.getLastModifyDate());

		Subscription standard = subscriptionService.findById(2l);
		saasUser.setSubscription(standard);

		if (bindingResult.hasErrors()) {
			// Si des erreurs de validation sont présentes, retour à la page du formulaire

			ModelAndView mv = new ModelAndView("saas-signup-st");
			mv.addObject("css", "/resources/css/saas/signup-form.css");
			mv.addObject("saasUser", saasUser); // renvoie le user pour garder les informations saisies
			mv.addObject("errors", bindingResult.getAllErrors()); // renvoie les erreurs
			return mv;
			
		} else {

			// Création du user avec une amap, une configuration et un espace AMAP
			AMAP amap = new AMAP();
			amap.setSaasUser(saasUser);
			saasUser.setAmap(amap);

			Configuration configuration = new Configuration();

			AmapSpace amapSpace = new AmapSpace();
			amapSpace.setAmap(amap);
			amapSpace.setConfiguration(configuration);
			amapSpace.setSubscription(standard);

			amapSpaceService.save(amapSpace);
			service.save(saasUser);

			ModelAndView mv = new ModelAndView("saasuser-signup-payment");
			mv.addObject("css", "/resources/css/saas/payment.css");
			return mv;
		}

	}

	@PostMapping("/saveSignUpPremium")
	public ModelAndView saveUserSaasPremium(@Valid @ModelAttribute("saasUser") SaasUser saasUser, BindingResult bindingResult, Model model) {
		
		System.out.println("Firstname : " + saasUser.getFirstname());
		System.out.println("Name : " + saasUser.getName());
		System.out.println("Phone : " + saasUser.getPhone());
		System.out.println("Email : " + saasUser.getEmail());
		System.out.println("Password : " + saasUser.getPassword());
		saasUser.setSaasUserLevel(SaasUserLevel.CUSTOM);
		System.out.println("UserLevel : " + saasUser.getSaasUserLevel());
		saasUser.setCreateDate(LocalDateTime.now().toString());
		System.out.println("DateCreated : " + saasUser.getCreateDate());
		saasUser.setLastModifyDate(LocalDateTime.now().toString());
		System.out.println("DateLastModifyDate : " + saasUser.getLastModifyDate());

		Subscription premium = subscriptionService.findById(3l);
		saasUser.setSubscription(premium);

		if (bindingResult.hasErrors()) {
			// Si des erreurs de validation sont présentes, retour à la page du formulaire

			ModelAndView mv = new ModelAndView("saas-signup-pr");
			mv.addObject("css", "/resources/css/saas/signup-form.css");
			mv.addObject("saasUser", saasUser); // renvoie le user pour garder les informations saisies
			mv.addObject("errors", bindingResult.getAllErrors()); // renvoie les erreurs
			return mv;
			
		} else {

			// Création du user avec une amap, une configuration et un espace AMAP
			AMAP amap = new AMAP();
			amap.setSaasUser(saasUser);
			saasUser.setAmap(amap);

			Configuration configuration = new Configuration();

			AmapSpace amapSpace = new AmapSpace();
			amapSpace.setAmap(amap);
			amapSpace.setConfiguration(configuration);
			amapSpace.setSubscription(premium);

			amapSpaceService.save(amapSpace);
			service.save(saasUser);

			ModelAndView mv = new ModelAndView("saasuser-signup-payment");
			mv.addObject("css", "/resources/css/saas/payment.css");
			return mv;
		}

	}

}
