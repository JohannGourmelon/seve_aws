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

import fr.seve.entities.AMAP;
import fr.seve.entities.Configuration;
import fr.seve.entities.Subscription;
import fr.seve.service.AmapService;
import fr.seve.service.ConfigurationService;

@Controller
@RequestMapping("/configuration")
public class ConfigurationController {

	private final ConfigurationService configurationService;

	private final AmapService amapService;

	public ConfigurationController(ConfigurationService configurationService, AmapService amapService) {
		super();
		this.configurationService = configurationService;
		this.amapService = amapService;
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
	public String saveConfigText(@ModelAttribute Configuration configuration, RedirectAttributes redirectAttributes) {
		
		Configuration newConf = configurationService.findById(1L);
		newConf.setPresentationText(configuration.getPresentationText());
		configurationService.save(newConf);;

		redirectAttributes.addFlashAttribute("message", "Les informations ont bien été enregistrées");
		return "redirect:/saas/configuration-texte";
	}
	
	@PostMapping("addConfigDesign")
	public String saveConfigDesign(@ModelAttribute Configuration configuration, RedirectAttributes redirectAttributes) {
		
		Configuration newConf = configurationService.findById(1L);
		newConf.setPrimaryColor(configuration.getPrimaryColor());
		configurationService.save(newConf);

		redirectAttributes.addFlashAttribute("message", "Les informations ont bien été enregistrées");
		return "redirect:/saas/configuration-design";
	}

	@GetMapping("/edit/{id}")
	public String showEditForm(@PathVariable Long id, Model model) {
		Configuration configuration = configurationService.findById(id);
		model.addAttribute("configuration", configuration);
		return "";
	}

}