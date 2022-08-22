package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.models.Travels;
import com.example.demo.services.TravelsService;

@Controller
public class MainController {
	@Autowired
	private TravelsService travelsService;

	/* ------- HOME PAGE (REDIRECT to /home) -------------- */	
	@GetMapping("/")
	public String goToHomePage() {
		return "redirect:/expenses";
	}	
	
	/* ------- Displays Dashboard and form (GET METHOD) ----- */	
	@GetMapping("/expenses")
	public String showHomePage(Model model) {
		
		List<Travels> travels = new ArrayList<Travels>();
		travels = travelsService.allTravels();
		model.addAttribute("travels",travels);
		model.addAttribute("newtravel",new Travels());
		return "dashboard.jsp";
	}
	/* ------- Process form for Save Travels (POST METHOD) ----- */	
	
	@PostMapping("/submit")
	public String processForm(@Valid  @ModelAttribute("newtravel") Travels newtravel, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Travels> travels = new ArrayList<Travels>();
			travels = travelsService.allTravels();
			model.addAttribute("travels",travels);
			return "dashboard.jsp";
		}
		else {
			travelsService.createTravels(newtravel);
		    return "redirect:/expenses";
		}
	}
	/* ------- Displays Expense ----- */	
	@GetMapping("/expenses/{id}")
	public String showDetailsPage(@PathVariable("id") Long id, Model model) {

		Travels travel = travelsService.oneTravels(id);
		model.addAttribute("travel", travel);
		return "details.jsp";
	}
	

	/* ------- Edit Travel Expense ----- */	
	@GetMapping("/expenses/edit/{id}")
	public String showEditPage(@PathVariable("id") Long id, Model model) {

		Travels travel = travelsService.oneTravels(id);
		model.addAttribute("travel", travel);
		return "EditPage.jsp";
	}

	@RequestMapping(value="/expenses/edit/{id}", method=RequestMethod.PUT)
	public String processEdit(@Valid @ModelAttribute("travel")Travels travels, BindingResult result) {
		if(result.hasErrors()) {
			return "EditPage.jsp";
		}else {
			travelsService.editTravels(travels);
			return "redirect:/expenses";
		}
	}

	/* ------- Delete Expense ----- */
	@DeleteMapping("/expenses/delete/{id}")
	public String processDelete(@PathVariable("id")Long id) {
		travelsService.deleteTravels(id);
		return "redirect:/expenses";
	}
}
