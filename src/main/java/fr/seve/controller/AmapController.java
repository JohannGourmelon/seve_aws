package fr.seve.controller;

import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.seve.entities.AMAP;
import fr.seve.service.AmapService;

@Controller
@RequestMapping("/amaps")
public class AmapController {

	private final AmapService amapService;

	public AmapController(AmapService amapService) {
		this.amapService = amapService;
	}
	
	@GetMapping
	public String listAmaps(Model model) {
		List<AMAP> amaps = amapService.findAll();
		model.addAttribute("amaps", amaps);
		
		return "amap/list";
	}
	
	@GetMapping("{id}")
	public String getAmap(@PathVariable Long id, Model model) {
		
		AMAP amap = amapService.findById(id);
		model.addAttribute("amap", amap);
		return "amap/details";
		
	}
	
	@GetMapping("/add")
	public String showAddForm(Model model) {
		model.addAttribute("amap", new AMAP());
		return "amap/form";
	}
	
	
	@PostMapping("add")
	public String saveAmap(@ModelAttribute AMAP amap) {
		amapService.save(amap);
		return "redirect:/amaps";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteAdherent(@PathVariable Long id) {
		amapService.deleteById(id);
		return "redirect:/amaps";
		
	}
	
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        AMAP amap = amapService.findById(id);
        model.addAttribute("amap", amap);
        return "amap/form";
    }

    @PostMapping("/edit/{id}")
    public String updateAmap(@ModelAttribute AMAP amap) {
        amapService.save(amap);
        return "redirect:/amaps";
    }

}