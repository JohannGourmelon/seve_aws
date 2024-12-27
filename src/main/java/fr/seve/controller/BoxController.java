package fr.seve.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.seve.entities.Box;
import fr.seve.service.BoxService;


@Controller
@RequestMapping("/box")
public class BoxController {

	@Autowired
	private BoxService boxService;
	
	@GetMapping
	public String listBoxes(Model model) {
		List<Box> boxes = boxService.findAll();
		model.addAttribute("boxes", boxes);
		
		return "box-list";
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
		box.setCreationDate(LocalDateTime.now().toString());
		boxService.save(box);
		return "redirect:/box";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteBox(@PathVariable Long id) {
		boxService.deleteById(id);
		return "redirect:/box";
		
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
		box.setLastModifiedDate(LocalDateTime.now().toString());
    	boxService.save(box);
        return "redirect:/box";
    }
    

}