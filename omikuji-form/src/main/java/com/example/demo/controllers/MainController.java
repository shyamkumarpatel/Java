package com.example.demo.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainController {
	/* ------- HOME PAGE (REDIRECT to /home) -------------- */	
	@GetMapping("/")
	public String goToHomePage() {
		return "redirect:/home";
	}

	/* ------- Displays form for Omikuji (GET METHOD) ----- */	
	@GetMapping("/home")
	public String showHomePage(HttpSession session) {
		return "form.jsp";
	}
	
	/* ------- Process form for Omikuji (POST METHOD) ----- */	
	@RequestMapping(value="/submit", method=RequestMethod.POST)
	public String processForm(
	    @RequestParam("pickNumber") Integer pickNumber,
	    @RequestParam("city") String city,
		@RequestParam("person") String person,
		@RequestParam("hobby") String hobby,
		@RequestParam("livingThing") String livingThing,
		@RequestParam("somethingNice") String somethingNice,
		HttpSession session,
		RedirectAttributes redirectAttributes) {
		if(pickNumber < 5 || pickNumber > 25 || pickNumber == null){
			redirectAttributes.addFlashAttribute("error", "Pick a number between 5 and 25!");
			return "redirect:/home";
		}
		session.setAttribute("pickNumber", pickNumber);
		session.setAttribute("city", city);
		session.setAttribute("person", person);
		session.setAttribute("hobby", hobby);
		session.setAttribute("livingThing", livingThing);
		session.setAttribute("somethingNice", somethingNice);
		
	    return "redirect:/show";
	}
	
	/* ------- Displays Omikuji (GET METHOD) -------------- */	
	@GetMapping("/show")
	public String showOmikuji(HttpSession session) {
		return "displayData.jsp";
	}
}
