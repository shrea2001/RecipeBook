package com.example.recipeBook.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.recipeBook.Dto.RecipeDto;
import com.example.recipeBook.Entity.Ingredient;
import com.example.recipeBook.Entity.Recipe;
import com.example.recipeBook.Repository.RecipeRepository;

@Service
public class RecipeServiceImplementation implements RecipeService {

	@Autowired
	private RecipeRepository recipeRepository;

	@Override
	public List<Recipe> getAllRecipes() {
		return recipeRepository.findAll();

	}

	public List<Recipe> getRecipesWithSugarAndMilk() {
		return recipeRepository.findRecipesWithSugarAndMilk();
	}

	@Override
	public RecipeDto getRecipeByName(String recipeName) {

		Recipe recipe = recipeRepository.findByRecipeName(recipeName);
		RecipeDto recipeDto = new RecipeDto();
		recipeDto.setRecipeName(null, recipe.getRecipeName());
		recipeDto.setDate(recipe.getDate());
		recipeDto.setInstructions(recipe.getInstructions());
		recipeDto.setStatus(recipe.getStatus());
		recipeDto.setSummary(recipe.getSummary());
		recipeDto.setIngredient(recipe.getIngredient());
		recipeDto.setRecipeId(recipe.getRecipeId());
		return recipeDto;

	}

	@Override
	public RecipeDto addRecipes(RecipeDto recipeDto) {

		List<Ingredient> ingredient = recipeDto.getIngredient();
		Recipe recipe = new Recipe();
		recipe.setDate(recipeDto.getDate());
		recipe.setInstructions(recipeDto.getInstructions());
		recipe.setRecipeName(recipeDto.getRecipeName().get(recipeDto.getRecipeNameKey()));
		recipe.setSummary(recipeDto.getSummary());
		recipe.setStatus(true);
		if (recipeDto.getIngredient() != null) {
			for (Ingredient i : ingredient) {
				i.setRecipe(recipe);

			}
		}
		recipe.setIngredient(ingredient);
		recipeRepository.save(recipe);
		return recipeDto;

	}

	@Override
	public Recipe updateRecipe(int recipeId, Recipe recipe) {

		Optional<Recipe> optionalRpecipe = recipeRepository.findById(recipeId);

		if (optionalRpecipe.isPresent()) {
			Recipe updaterecipes = optionalRpecipe.get();

			recipe.setRecipeId(recipeId);
			recipe.setStatus(true);
			List<Ingredient> ingredient = updaterecipes.getIngredient();
			List<Ingredient> updatedIngredients = recipe.getIngredient();
			if (recipe.getIngredient() != null) {
				for (int i = 0; i < updatedIngredients.size(); i++) {
					if (i < ingredient.size()) {
						updatedIngredients.get(i).setIngredientId(ingredient.get(i).getIngredientId());
					}
					updatedIngredients.get(i).setRecipe(recipe);
				}
			}
			recipe.setIngredient(updatedIngredients);
			return recipeRepository.save(recipe);
		}
		return null;
	}

	@Override
	public void deleteRecipes(int recipeId) {

		Recipe deleteRecipe = recipeRepository.findById(recipeId).get();
		if (deleteRecipe != null) {

			deleteRecipe.setStatus(false);
			recipeRepository.save(deleteRecipe);
		}

	}

}