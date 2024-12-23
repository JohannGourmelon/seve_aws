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
import fr.seve.entities.AmapSpace;
import fr.seve.entities.Configuration;
import fr.seve.entities.SaasUser;
import fr.seve.service.AmapService;
import fr.seve.service.AmapSpaceService;
import fr.seve.service.SaasUserService;

@Controller
@RequestMapping("/amap")
public class AmapController {

	private final AmapService amapService;
	
	private final SaasUserService saasUserService;
	
	private final AmapSpaceService amapSpaceService;

	public AmapController(AmapService amapService, SaasUserService saasUserService, AmapSpaceService amapSpaceService) {
		super();
		this.amapService = amapService;
		this.saasUserService = saasUserService;
		this.amapSpaceService = amapSpaceService;
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
	    SaasUser user = saasUserService.findById(id);
	    AMAP amap = user.getAmap();
	    model.addAttribute("amap", amap);
		ModelAndView mv = new ModelAndView("saas-account-config-amap");
        mv.addObject("css", "/resources/css/saas/config.css");
        return mv;
		}
	
	@GetMapping("/info")
	public ModelAndView configContent(Model model) {
	    SaasUser user = saasUserService.findById(1L);
	    model.addAttribute("user", user);
		ModelAndView mv = new ModelAndView("saas-account-config-amap");
        mv.addObject("css", "/resources/css/saas/config.css");
        return mv;
	}
	
//	@PostMapping("addAmap")
//	public String saveConfigAmap(@PathVariable Long id, @ModelAttribute AMAP amap, RedirectAttributes redirectAttributes) {
//
//	    AMAP newAmap = new AMAP();
//	    newAmap.setName(amap.getName());
//	    newAmap.setAddress(amap.getAddress());
//	    newAmap.setSiret(amap.getSiret());
//	    newAmap.setSaasUser(saasUserService.findById(id));
//	    
//	    AmapSpace amapSpace = new AmapSpace();
//	    amapSpace.setAmap(newAmap);
//	    amapSpaceService.save(amapSpace);
//	    amapService.save(newAmap);
//		
//	   	redirectAttributes.addFlashAttribute("message", "Les informations ont bien été enregistrées");
//	    return "redirect:/amap/info/{id}";
//	}
	
//	@PostMapping("addAmap/{id}")
//	public String saveConfigAmap(@PathVariable Long id, @ModelAttribute AMAP amap, RedirectAttributes redirectAttributes) {
//
//	    AMAP newAmap = new AMAP();
//	    newAmap.setName(amap.getName());
//	    newAmap.setAddress(amap.getAddress());
//	    newAmap.setSiret(amap.getSiret());
//	    newAmap.setSaasUser(saasUserService.findById(id));
//	    
//	    AmapSpace amapSpace = new AmapSpace();
//	    amapSpace.setAmap(newAmap);
//	    amapSpaceService.save(amapSpace);
//	    amapService.save(newAmap);
//		
//	   	redirectAttributes.addFlashAttribute("message", "Les informations ont bien été enregistrées");
//	    return "redirect:/amap/info/{id}";
//	}
	
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