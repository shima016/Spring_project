package com.example.demo.multi.service;

import org.springframework.stereotype.Service;

@Service
public class MultiService {

	// 掛け算を行うメソッド
	public int multiply(int num1, int num2) {
		int result = num1 * num2;
		return result;
	}
}