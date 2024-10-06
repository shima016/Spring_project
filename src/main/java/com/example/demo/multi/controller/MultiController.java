package com.example.demo.multi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.multi.service.MultiService;

@Controller
public class MultiController {

	private final MultiService multiService;

	// コンストラクタで依存性注入
	public MultiController(MultiService multiService) {
		this.multiService = multiService;
	}

	// "/multiply" エンドポイントで掛け算の結果を返す
	@GetMapping("multiply")
	public String multiply(Model model) {
		String result = String.valueOf(multiService.multiply(5, 6)); // 5 * 6 の計算結果
		model.addAttribute("result", result); // 計算結果をビューに渡す
		return "multiply.html"; // multiply.htmlを返す
	}
}