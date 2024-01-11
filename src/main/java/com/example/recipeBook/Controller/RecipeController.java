package com.example.recipeBook.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.recipeBook.Entity.Recipe;
import com.example.recipeBook.Service.RecipeService;

@RestController
public class RecipeController {
	
	@Autowired
	private RecipeService recipeService;

	@GetMapping("recipes/all")
	 public List<Recipe> fetchAllRecipes(){
		 return recipeService.getAllRecipes();
		 
	 }
}