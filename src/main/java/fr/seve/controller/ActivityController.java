package fr.seve.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.seve.entities.AMAP;
import fr.seve.entities.Activity;
import fr.seve.entities.AmapSpace;
import fr.seve.service.ActivityService;
import fr.seve.service.AmapService;
import fr.seve.service.AmapSpaceService;

@Controller
@RequestMapping("/{slug}/activity")
public class ActivityController {

	@Autowired
	private ActivityService activityService;
	
	@Autowired
	private AmapService amapService;
	
	@Autowired
	private AmapSpaceService amapSpaceService;

	@GetMapping
	public ModelAndView listActivities(@PathVariable String slug, Model model) {
		AMAP amap = amapService.findBySlug(slug);
        if (amap == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "AMAP not found");
        }
        
        Long amapSpaceId = amap.getId();
        
		List<Activity> activities = activityService.findByAmapSpaceId(amapSpaceId);
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
        
        Long amapSpaceId = amap.getId();
        
		List<Activity> activities = activityService.findByAmapSpaceId(amapSpaceId);
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
	public String saveActivity(@PathVariable String slug, @ModelAttribute Activity activity,
			@RequestParam("image") MultipartFile image, RedirectAttributes redirectAttributes) {
		AMAP amap = amapService.findBySlug(slug);		
        if (amap == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "AMAP not found");
        }
        
        AmapSpace amapSpace = amapSpaceService.findById(amap.getId());
        
        if (image != null && !image.isEmpty()) {
			try {
				activity.setImageData(image.getBytes());
			} catch (IOException e) {
				redirectAttributes.addFlashAttribute("message", "Erreur lors de l'importation de l'image.");
				e.printStackTrace();
				return "redirect:/{slug}/activity/admin";
			}
		}
        
		activity.setCreationDate(LocalDate.now());
		activity.setAmapSpace(amapSpace);
		
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
	public String updateActivity(@PathVariable String slug, @PathVariable Long id, @ModelAttribute Activity activity,
			@RequestParam("image") MultipartFile image, RedirectAttributes redirectAttributes) {
		AMAP amap = amapService.findBySlug(slug);
        if (amap == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "AMAP not found");
        }
        
		Activity oldActivity = activityService.findById(id);
		AmapSpace amapSpace = amapSpaceService.findById(amap.getId());
		
		activity.setCreationDate(oldActivity.getCreationDate());
		activity.setLastModifiedDate(LocalDate.now());
		activity.setAmapSpace(amapSpace);
		if (oldActivity.getImageData() != null) {
			activity.setImageData(oldActivity.getImageData());
		}
		if (image != null && !image.isEmpty()) {
			try {
				activity.setImageData(image.getBytes());
			} catch (IOException e) {
				redirectAttributes.addFlashAttribute("message", "Erreur lors de l'importation de l'image.");
				e.printStackTrace();
				return "redirect:/{slug}/activity/admin";
			}
		}
		activityService.save(activity);
		return "redirect:/{slug}/activity/admin";
	}
	
	@GetMapping("/image/{id}")
	public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
	    Activity activity = activityService.findById(id);
	    if (activity == null) {
	        System.out.println("Aucun panier trouvé avec l'ID : " + id);
	        return ResponseEntity.notFound().build();
	    }

	    byte[] imageData = activity.getImageData();
	    if (imageData != null) {
	        System.out.println("Image trouvée pour l'ID : " + id);
	        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(imageData);
	    }

	    System.out.println("Pas d'image pour l'ID : " + id);
	    return ResponseEntity.notFound().build();
	}

}
