package fr.seve.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import fr.seve.entities.Subscription;

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
