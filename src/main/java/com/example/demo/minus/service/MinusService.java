package com.example.demo.minus.service;

import org.springframework.stereotype.Service;

@Service
public class MinusService {

	public int subtract(int firstNumber, int secondNumber) {
		return firstNumber - secondNumber;
	}
}