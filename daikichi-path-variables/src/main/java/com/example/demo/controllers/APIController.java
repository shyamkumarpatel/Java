package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class APIController {
	
    @RequestMapping("/daikichi/travel/{location}")
    public String index(@PathVariable("location") String location) {
        return "Congratulations! You will soon travel to " + location + "!";
    }	
    
    @RequestMapping("/daikichi/lotto/{number}")
    public String index(@PathVariable("number") Integer number) {
    	if(number%2 == 0) {
    		return "You will take a grand journey in the near future, but be weary of tempting offers";
    	}
        return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";
    }
}
