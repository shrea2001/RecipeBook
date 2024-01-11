package com.example.recipeBook.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.recipeBook.Entity.Recipe;
import com.example.recipeBook.Repository.RecipeRepository;

@Service
public class RecipeServiceImplementation implements RecipeService{
 
@Autowired	
private RecipeRepository recipeRepository;
	

public List <Recipe> getAllRecipes(){
	List<Recipe> recipe =recipeRepository.findAll();
	return recipe;
}

}