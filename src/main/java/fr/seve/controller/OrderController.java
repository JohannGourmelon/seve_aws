package fr.seve.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/order")
public class OrderController {
	
	@GetMapping
	public ModelAndView listBoxes(Model model) {
		ModelAndView mv = new ModelAndView("cart");
		mv.addObject("css", "/resources/css/amap/order.css");
	    return mv;
	}

}
