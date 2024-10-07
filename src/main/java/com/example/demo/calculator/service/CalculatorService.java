package com.example.demo.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

	public int calculate(int num1, int num2, String operation) {
		switch (operation) {
		case "+":
			return num1 + num2;
		case "-":
			return num1 - num2;
		case "*":
			return num1 * num2;
		case "/":
			if (num2 == 0) {
				throw new ArithmeticException("ゼロ除算はできません");
			}
			return num1 / num2;
		default:
			throw new IllegalArgumentException("無効な操作");
		}
	}
}