package com.example.demo.animalsAPI.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.animalsAPI.data.AnimalData;
import com.example.demo.animalsAPI.service.AnimalService;

@Controller
public class AnimalController {

    private final AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping("/animal-search")
    public String showSearchPage(Model model) throws IOException {
        List<AnimalData> animalsList = animalService.getAllAnimals();
        model.addAttribute("animalsList", animalsList);
        return "animal-search";
    }

    @GetMapping("/animal-detail")
    public String getAnimalDetail(@RequestParam("id") int id, Model model) throws IOException {
        List<AnimalData> animalList = animalService.getAnimalById(id);
        model.addAttribute("animalList", animalList);
        return "animal-detail";
    }
}
