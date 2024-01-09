package com.example.recipeBook.Entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class IngredientTest {

	@Test
	public void testCreateIngredient() {
		int ingredientId = 1;
		String ingredientName = "maggie masala";
		int quantity = 1;
		String measurement= "5 gm";
		Recipe recipe =new Recipe();

		
		Ingredient ingredient = new Ingredient(ingredientId,ingredientName,quantity,measurement,recipe);

		assertEquals(ingredientId, ingredient.getIngredientId());
		assertEquals(ingredientName, ingredient.getIngredientName());
		assertEquals(quantity, ingredient.getQuantity());
		assertEquals(recipe, ingredient.getRecipe());
		assertEquals(recipe, ingredient.getMeasurement());
	}
}
