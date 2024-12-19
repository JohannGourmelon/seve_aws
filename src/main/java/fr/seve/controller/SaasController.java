package fr.seve.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import fr.seve.entities.AMAP;

@Controller
@RequestMapping("/saas")
public class SaasController {

	
	@GetMapping
	public ModelAndView homeSaas() {
		ModelAndView mv = new ModelAndView("saas-home");
        mv.addObject("css", "/resources/css/saas/home.css");
        return mv;
		}
	
	
	@GetMapping("/forfaits")
	public ModelAndView subscriptionSaas() {
		ModelAndView mv = new ModelAndView("saas-subscription");
        mv.addObject("css", "/resources/css/saas/subscription.css");
        return mv;
		}
	
	@GetMapping("/configuration-amap")
	public ModelAndView configAmap(Model model) {
        model.addAttribute("amap", new AMAP());
		ModelAndView mv = new ModelAndView("saas-account-config-amap");
//        mv.addObject("css", "/resources/css/saas/subscription.css");
        return mv;
		}
	
	@GetMapping("/configuration-texte")
	public ModelAndView configText() {
		ModelAndView mv = new ModelAndView("saas-account-config-text");
//        mv.addObject("css", "/resources/css/saas/subscription.css");
        return mv;
		}
	
	@GetMapping("/configuration-design")
	public ModelAndView configDesign() {
		ModelAndView mv = new ModelAndView("saas-account-config-design");
//        mv.addObject("css", "/resources/css/saas/subscription.css");
        return mv;
		}
	
}
