package com.example.demo.minus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.minus.service.MinusService;

@Controller
public class MinusController {

	@Autowired
	private MinusService minusService;

	@GetMapping("/minus")
	public String minusForm() {
		return "minus";
	}

	@PostMapping("/minus")
	public String calculateDifference(@RequestParam("firstNumber") int firstNumber,
			@RequestParam("secondNumber") int secondNumber,
			Model model) {
		int result = minusService.subtract(firstNumber, secondNumber);
		model.addAttribute("result", result);
		return "minus";
	}
}