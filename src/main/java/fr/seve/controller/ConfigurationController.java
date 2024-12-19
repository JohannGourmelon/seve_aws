package fr.seve.controller;

import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.seve.entities.Configuration;
import fr.seve.service.ConfigurationService;

@Controller
@RequestMapping("/configuration")
public class ConfigurationController {

	private final ConfigurationService configurationService;

	public ConfigurationController(ConfigurationService configService) {
		this.configurationService = configService;
	}
	
	@GetMapping
	public String listAmaps(Model model) {
		List<Configuration> configurations = configurationService.findAll();
		model.addAttribute("configurations", configurations);
		return "";
	}
	
	@GetMapping("{id}")
	public String getAmap(@PathVariable Long id, Model model) {
		Configuration configuration = configurationService.findById(id);
		model.addAttribute("configuration", configuration);
		return "";
	}
	
	
	@PostMapping("addConfigText")
	public String saveConfigAmap(@ModelAttribute Configuration configuration, RedirectAttributes redirectAttributes) {
		configurationService.save(configuration);
	   	redirectAttributes.addFlashAttribute("message", "Les informations ont bien été enregistrées");
	    return "redirect:/saas/configuration-amap";
	}
	
	
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Configuration configuration = configurationService.findById(id);
        model.addAttribute("configuration", configuration);
        return "";
    }

}