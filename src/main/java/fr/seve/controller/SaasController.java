package fr.seve.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/saas")
public class SaasController {

//	@GetMapping
//	public String homeSaas() {
//		
//		return "saas-home";
//	}
	
	@GetMapping
	public ModelAndView homeSaas() {
		ModelAndView mv = new ModelAndView("saas-home");
        mv.addObject("css", "/resources/css/saas/home.css");
        return mv;
		}
	
	
	@GetMapping("/packages")
	public ModelAndView packagesSaas() {
		ModelAndView mv = new ModelAndView("saas-subscription");
        mv.addObject("css", "/resources/css/saas/subscription.css");
        return mv;
		}
	
}
