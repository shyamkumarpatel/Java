package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Travels;
import com.example.demo.repositories.TravelsRepository;

@Service
public class TravelsService {
	private final TravelsRepository travelsRepo;

	public TravelsService(TravelsRepository travelsRepo) {
		this.travelsRepo = travelsRepo;
	}
	//create 
	public Travels createTravels(Travels travel) {
		return travelsRepo.save(travel);
	}
	
	//read all
	public List<Travels> allTravels(){
		return travelsRepo.findAll();
	}
	
	//read one
	public Travels oneTravels(Long id) {
		Optional<Travels> optionalTravel = travelsRepo.findById(id);
		if(optionalTravel.isPresent()) { 
			return optionalTravel.get();
		}else {
			return null;
		}	
	}
	
	//update one	
	public Travels editTravels(Travels travel) {
		return travelsRepo.save(travel);
	}
	//update one	
	public Travels updateTravels(Long id, String expense, String vendor, Double amount, String description) {
		Travels travels = this.oneTravels(id);
		travels.setExpense(expense);
		travels.setVendor(vendor); 
		travels.setAmount(amount);
		travels.setDescription(description);
		return travelsRepo.save(travels);
	}
	
	// delete one
	public void deleteTravels(Long id) {
		travelsRepo.deleteById(id);
	}


}
