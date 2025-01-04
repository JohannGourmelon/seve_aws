package fr.seve.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import fr.seve.entities.AMAP;
import fr.seve.entities.Activity;
import fr.seve.service.ActivityService;
import fr.seve.service.AmapService;

@Controller
@RequestMapping("/{slug}/activity")
public class ActivityController {

	@Autowired
	private ActivityService activityService;
	
	@Autowired
	private AmapService amapService;

	@GetMapping
	public ModelAndView listActivities(@PathVariable String slug, Model model) {
		AMAP amap = amapService.findBySlug(slug);
        if (amap == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "AMAP not found");
        }
        
		List<Activity> activities = activityService.findAll();
		model.addAttribute("activities", activities);
		ModelAndView mv = new ModelAndView("activity-list");
		mv.addObject("css", "/resources/css/amap/boxList.css");
	    return mv;
	}

	@GetMapping("/admin")
	public ModelAndView adminListActivities(@PathVariable String slug, Model model) {
		AMAP amap = amapService.findBySlug(slug);
        if (amap == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "AMAP not found");
        }
        
		List<Activity> activities = activityService.findAll();
		model.addAttribute("activities", activities);
		ModelAndView mv = new ModelAndView("admin-activity-list");
		mv.addObject("css", "/resources/css/amap/boForms.css");
	    return mv;
	}	
	
	
	@GetMapping("{id}")
	public String getActivity(@PathVariable String slug, @PathVariable Long id, Model model) {
		AMAP amap = amapService.findBySlug(slug);
        if (amap == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "AMAP not found");
        }
        
		Activity activity = activityService.findById(id);
		model.addAttribute("activity", activity);
		return "activity-details";
	}

	
	@GetMapping("/add")
	public String showAddForm(@PathVariable String slug, Model model) {
		AMAP amap = amapService.findBySlug(slug);
        if (amap == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "AMAP not found");
        }
        
		model.addAttribute("activity", new Activity());
		return "activity-form";
	}
	

	@PostMapping("add")
	public String saveActivity(@PathVariable String slug, @ModelAttribute Activity activity) {
		AMAP amap = amapService.findBySlug(slug);
        if (amap == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "AMAP not found");
        }
        
		activity.setCreationDate(LocalDate.now());
		activityService.save(activity);
		return "redirect:/{slug}/activity/admin";
	}

	@GetMapping("/delete/{id}")
	public String deleteActivity(@PathVariable String slug, @PathVariable Long id, Model model) {
		AMAP amap = amapService.findBySlug(slug);
        if (amap == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "AMAP not found");
        }
        
		activityService.deletebyId(id);
		return "redirect:/{slug}/activity/admin";
	}

	
	@GetMapping("/edit/{id}")
	public String showEditForm(@PathVariable String slug, @PathVariable Long id, Model model) {
		AMAP amap = amapService.findBySlug(slug);
        if (amap == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "AMAP not found");
        }
        
		Activity activity = activityService.findById(id);
		model.addAttribute("activity", activity);
		return "activity-form";
	}
	

	@PostMapping("/edit/{id}")
	public String updateActivity(@PathVariable String slug, @PathVariable Long id, @ModelAttribute Activity activity) {
		AMAP amap = amapService.findBySlug(slug);
        if (amap == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "AMAP not found");
        }
        
		Activity oldActivity = activityService.findById(id);
		activity.setCreationDate(oldActivity.getCreationDate());
		activity.setLastModifiedDate(LocalDate.now());
		activityService.save(activity);
		return "redirect:/{slug}/activity/admin";
	}

}
