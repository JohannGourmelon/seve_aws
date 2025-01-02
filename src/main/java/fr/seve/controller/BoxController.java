package fr.seve.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import fr.seve.entities.AMAP;
import fr.seve.entities.Box;
import fr.seve.entities.Configuration;
import fr.seve.service.BoxService;


@Controller
@RequestMapping("/box")
public class BoxController {

	@Autowired
	private BoxService boxService;
	
	@GetMapping
	public ModelAndView listBoxes(Model model) {
		List<Box> boxes = boxService.findAll();
		model.addAttribute("boxes", boxes);
		ModelAndView mv = new ModelAndView("box-list");
		mv.addObject("css", "/resources/css/amap/boxList.css");
	    return mv;
	}
	
	@GetMapping("/admin")
	public ModelAndView adminListBoxes(Model model) {
		List<Box> boxes = boxService.findAll();
		model.addAttribute("boxes", boxes);
		ModelAndView mv = new ModelAndView("admin-box-list");
		mv.addObject("css", "/resources/css/amap/boForms.css");
	    return mv;
	}	
	
	@GetMapping("{id}")
	public String getBox(@PathVariable Long id, Model model) {
		
		Box box = boxService.findById(id);
		model.addAttribute("box", box);
		return "box-details";
		
	}
	
	@GetMapping("/add")
	public String showAddForm(Model model) {
		model.addAttribute("categories", Box.Category.values());
        model.addAttribute("frequencies", Box.Frequency.values());
		model.addAttribute("box", new Box());
		return "box-form";
	}
	
	
	@PostMapping("add")
	public String saveBox(@ModelAttribute Box box) {
		box.setCreationDate(LocalDate.now());
		boxService.save(box);
		return "redirect:/box/admin";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteBox(@PathVariable Long id) {
		boxService.deleteById(id);
		return "redirect:/box/admin";
		
	}
	
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Box box = boxService.findById(id);
        model.addAttribute("categories", Box.Category.values());
        model.addAttribute("frequencies", Box.Frequency.values());
        model.addAttribute("box", box);
        return "box-form";
    }

    @PostMapping("/edit/{id}")
    public String updateBox(@PathVariable Long id, @ModelAttribute Box box) {
    	Box oldBox = boxService.findById(id);
    	box.setCreationDate(oldBox.getCreationDate());
		box.setLastModifiedDate(LocalDate.now());
    	boxService.save(box);
        return "redirect:/box/admin";
    }
    

}