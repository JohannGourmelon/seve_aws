package fr.seve.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.seve.entities.AMAP;
import fr.seve.entities.Configuration;
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
	public String listConfig(Model model) {
		List<Configuration> configurations = configurationService.findAll();
		model.addAttribute("configurations", configurations);
		return "";
	}

	@GetMapping("{id}")
	public String getConfig(@PathVariable Long id, Model model) {
		Configuration configuration = configurationService.findById(id);
		model.addAttribute("configuration", configuration);
		return "";
	}

	
	@GetMapping("/contenu")
	public ModelAndView configContent(Model model) {
	    Configuration configuration = configurationService.findById(2L);
	    AMAP amap = amapService.findById(2L);
	    model.addAttribute("configuration", configuration);
	    model.addAttribute("amap", amap);
		ModelAndView mv = new ModelAndView("saas-account-config-content");
		 mv.addObject("css", "/resources/css/saas/config.css");
	        return mv;
	}
	
	@GetMapping("/design")
	public ModelAndView configDesign(Model model) {
		Configuration configuration = configurationService.findById(2L);
	    AMAP amap = amapService.findById(2L);
	    model.addAttribute("configuration", configuration);
	    model.addAttribute("amap", amap);
		ModelAndView mv = new ModelAndView("saas-account-config-design");
        mv.addObject("css", "/resources/css/saas/config.css");
        return mv;
		}


	@PostMapping("editDesign/{id}")
	public String editDesign(@PathVariable Long id, Configuration configuration, RedirectAttributes redirectAttributes) {
		Configuration newConf = configurationService.findById(id);
		newConf.setPrimaryColor(configuration.getPrimaryColor());
		newConf.setSecondaryColor(configuration.getSecondaryColor());
		newConf.setTertiaryColor(configuration.getTertiaryColor());
		newConf.setPolice(configuration.getPolice());
		newConf.setIsRoundedBorders(configuration.getIsRoundedBorders());
		configurationService.save(newConf);

		redirectAttributes.addFlashAttribute("message", "Les informations ont bien été enregistrées");
		return  "redirect:/configuration/design";
	}
	
	@PostMapping("editContent/{id}")
	public String editContent(@PathVariable Long id, Configuration configuration, RedirectAttributes redirectAttributes) {
		Configuration newConf = configurationService.findById(id);
		newConf.setPresentationText(configuration.getPresentationText());
		configurationService.save(newConf);;

		redirectAttributes.addFlashAttribute("message", "Les informations ont bien été enregistrées");
		return "redirect:/configuration/contenu";
	}

}