package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Travels;
import com.example.demo.services.TravelsService;

@RestController
@RequestMapping("/api")
public class TravelsAPI {
	@Autowired
	private TravelsService travelsService;
	
	// get all
	@RequestMapping("/expenses")
	public List<Travels>findAllTravels(){
		return travelsService.allTravels();
	}
	
	// create one
	@PostMapping("/expenses")
	public Travels createTravels(
				@RequestParam("expense") String expense,
				@RequestParam("vendor") String vendor,
				@RequestParam("amount") Double amount,
				@RequestParam("description") String description){
		Travels newTravel = new Travels(expense, vendor, amount, description);
		return travelsService.createTravels(newTravel);
	}
	
	// read one
	@GetMapping("/expenses/{id}")
	public Travels findTravel(@PathVariable("id") Long id){
		return travelsService.oneTravels(id);
	}
	
	//update
	@PutMapping("/expenses/{id}")
	public Travels updateTravels(
			@PathVariable("id") Long id,
			@RequestParam("expense") String expense,
			@RequestParam("vendor") String vendor,
			@RequestParam("amount") Double amount,
			@RequestParam("description") String description){
		return travelsService.updateTravels(id, expense, vendor, amount, description);
	}
	// Delete
	@DeleteMapping("/expenses/{id}")
	public void removeTravels(@PathVariable("id") Long id) {
		travelsService.deleteTravels(id);
	}
}
