package com.example.demo.calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.calculator.service.CalculatorService;

@Controller
public class CalculatorController {

	@Autowired
	private CalculatorService calculatorService;

	@GetMapping("/calculator")
	public String showCalculator() {
		return "calculator";
	}

	@PostMapping("/calculator")
	public String calculate(
			@RequestParam("num1") int num1,
			@RequestParam("num2") int num2,
			@RequestParam("operation") String operation,
			Model model) {

		try {
			int result = calculatorService.calculate(num1, num2, operation);
			model.addAttribute("result", result);
		} catch (ArithmeticException e) {
			model.addAttribute("error", "ゼロ除算はできません");
		}

		return "calculator";
	}
}