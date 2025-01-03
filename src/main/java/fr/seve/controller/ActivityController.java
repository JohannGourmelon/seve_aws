package fr.seve.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.seve.entities.Activity;
import fr.seve.service.ActivityService;

@Controller
@RequestMapping("/activity")
public class ActivityController {

	@Autowired
	private ActivityService activityService;

	@GetMapping
	public String listActivities(Model model) {
		List<Activity> activities = activityService.findAll();
		model.addAttribute("activities", activities);
		return "activity-list";

	}

	@GetMapping("{id}")
	public String getActivity(@PathVariable Long id, Model model) {

		Activity activity = activityService.findById(id);
		model.addAttribute("activity", activity);
		return "activity-details";
	}

	@GetMapping("/add")
	public String showAddForm(Model model) {
		model.addAttribute("activity", new Activity());
		return "activity-form";
	}

	@PostMapping("add")
	public String saveActivity(@ModelAttribute Activity activity) {
		activity.setCreationDate(LocalDate.now());
		activityService.save(activity);
		return "redirect:/activity";

	}

	@GetMapping("/delete/{id}")
	public String deleteActivity(@PathVariable Long id, Model model) {
		activityService.deletebyId(id);
		return "redirect:/activity";
	}

	@GetMapping("/edit/{id}")
	public String showEditForm(@PathVariable Long id, Model model) {
		Activity activity = activityService.findById(id);
		model.addAttribute("activity", activity);
		return "activity-form";

	}

	@PostMapping("/edit/{id}")
	public String updateActivity(@PathVariable Long id, @ModelAttribute Activity activity) {
		Activity oldActivity = activityService.findById(id);
		activity.setCreationDate(oldActivity.getCreationDate());
		activity.setLastModifiedDate(LocalDate.now());
		activityService.save(activity);
		return "redirect:/activity";

	}

}
