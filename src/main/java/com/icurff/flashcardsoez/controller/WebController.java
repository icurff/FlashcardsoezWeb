package com.icurff.flashcardsoez.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.icurff.flashcardsoez.model.User;
import com.icurff.flashcardsoez.service.MyService;

@Controller
public class WebController {

	@Autowired
	MyService myService;

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}


	@PostMapping("/register")
	public String registerAccount(Model model, @ModelAttribute User user) {
		try {
			myService.saveUser(user);
			model.addAttribute("successMessage", "Registered successfully!");
			System.out.println("Account created");
			return "/register";
		} catch (Exception e) {
			model.addAttribute("errorMessage", e.getMessage());
			return "register";
		}

	}
}