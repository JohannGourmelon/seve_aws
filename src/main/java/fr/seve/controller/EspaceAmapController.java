package fr.seve.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/amap-space")
public class EspaceAmapController {
	

	@GetMapping
	public ModelAndView homeSaas() {
		ModelAndView mv = new ModelAndView("amap-home");
        mv.addObject("css", "/resources/css/amap/home.css");
        return mv;
		}
	
}
