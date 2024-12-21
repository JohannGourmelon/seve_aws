package fr.seve.controller;

import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.seve.entities.AMAP;
import fr.seve.entities.Configuration;
import fr.seve.service.AmapService;

@Controller
@RequestMapping("/amap")
public class AmapController {

	private final AmapService amapService;

	public AmapController(AmapService amapService) {
		this.amapService = amapService;
	}
	
	@GetMapping
	public String listAmaps(Model model) {
		List<AMAP> amaps = amapService.findAll();
		model.addAttribute("amaps", amaps);
		
		return "amap-list";
	}
	
	@GetMapping("{id}")
	public String getAmap(@PathVariable Long id, Model model) {
		
		AMAP amap = amapService.findById(id);
		model.addAttribute("amap", amap);
		return "amap-details";
		
	}
	
	@GetMapping("/add")
	public String showAddForm(Model model) {
		model.addAttribute("amap", new AMAP());
		return "amap-form";
	}
	
	
	@PostMapping("add")
	public String saveAmap(@ModelAttribute AMAP amap) {
		amapService.save(amap);
		return "redirect:/amap";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteAdherent(@PathVariable Long id) {
		amapService.deleteById(id);
		return "redirect:/amap";
		
	}
	
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        AMAP amap = amapService.findById(id);
        model.addAttribute("amap", amap);
        return "amap-form";
    }

    @PostMapping("/edit/{id}")
    public String updateAmap(@ModelAttribute AMAP amap) {
        amapService.save(amap);
        return "redirect:/amap";
    }
    
    
    
	@GetMapping("/info/{id}")
	public ModelAndView configAmap(@PathVariable Long id, Model model) {
		AMAP amap = amapService.findById(id);
	    model.addAttribute("amap", amap);
		ModelAndView mv = new ModelAndView("saas-account-config-amap");
//        mv.addObject("css", "/resources/css/saas/subscription.css");
        return mv;
		}
	
	@PostMapping("addAmap")
	public String saveConfigAmap(@ModelAttribute AMAP amap, RedirectAttributes redirectAttributes) {

	    AMAP newAmap = new AMAP();
	    newAmap.setName(amap.getName());
	    newAmap.setAddress(amap.getAddress());
	    newAmap.setSiret(amap.getSiret());
	    
	    Configuration emptyConfig = new Configuration();
	    emptyConfig.setPresentationText("");

	    newAmap.setConfiguration(emptyConfig);
	    amapService.save(newAmap);
		
	   	redirectAttributes.addFlashAttribute("message", "Les informations ont bien été enregistrées");
	    return "redirect:/amap/info";
	}
	
	@PostMapping("editAmap/{id}")
	public String editDesign(@PathVariable Long id, AMAP amap, RedirectAttributes redirectAttributes) {
		AMAP newAmap = amapService.findById(id);
		newAmap.setName(amap.getName());
		newAmap.setAddress(amap.getAddress());
		newAmap.setSiret(amap.getSiret());
		amapService.save(newAmap);

		redirectAttributes.addFlashAttribute("message", "Les informations ont bien été enregistrées");
		return  "redirect:/amap/info";
	}

}