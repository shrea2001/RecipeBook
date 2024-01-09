package com.example.recipeBook.Service;

import java.util.List;

import com.example.recipeBook.Dto.RecipeDto;
import com.example.recipeBook.Entity.Recipe;

public interface RecipeService {
	public List<Recipe> getAllRecipes();

	public RecipeDto getRecipeByName(String recipeName);

	public List<Recipe> getRecipesWithSugarAndMilk();

	public RecipeDto addRecipes(RecipeDto recipeDto);

	public Recipe updateRecipe(int recipeId, Recipe recipe);

	public void deleteRecipes(int recipeId);
}