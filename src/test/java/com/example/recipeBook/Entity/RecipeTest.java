package com.example.recipeBook.Entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class RecipeTest {

	@Test
	public void testCreateRecipe() {
		int recipeId = 1;
		String recipeName = "maggie";
		LocalDate date = LocalDate.now();
		String instructions = "cook properly";
		String summary = "boil it";
		boolean status = true;
		List<Ingredient> ingredients = new ArrayList<>();

		Recipe recipe = new Recipe(recipeId, recipeName, instructions, date, summary, status, ingredients);

		assertEquals(recipeId, recipe.getRecipeId());
		assertEquals(recipeName, recipe.getRecipeName());
		assertEquals(date, recipe.getDate());
		assertEquals(instructions, recipe.getInstructions());
		assertEquals(summary, recipe.getSummary());
		assertEquals(status, recipe.getStatus());
		assertEquals(ingredients, recipe.getIngredient());
	}
}
