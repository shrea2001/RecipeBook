package com.example.recipeBook.Controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.recipeBook.Dto.RecipeDto;
import com.example.recipeBook.Entity.Recipe;
import com.example.recipeBook.Service.RecipeService;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

@SpringBootTest
public class RecipeControllerTest {

	@Mock
	private RecipeService recipeService;

	@InjectMocks
	private RecipeController recipeController;

	@Test
	    public void testFetchAllRecipes() {
	        when(recipeService.getAllRecipes()).thenReturn(Collections.emptyList());
	        ResponseEntity<List<Recipe>> response = recipeController.fetchAllRecipes();

	        assertAll(() -> assertEquals(HttpStatus.OK, response.getStatusCode()),
	        		() -> assertEquals(Collections.emptyList(), response.getBody()));
	    
	    }

	@Test
	public void testFetchRecipesByName() {
		String recipeName = "maggie";
		when(recipeService.getRecipeByName(recipeName)).thenReturn(new RecipeDto());

		ResponseEntity<String> response = recipeController.fetchRecipesByName(recipeName);

		assertAll(() -> assertEquals(HttpStatus.OK, response.getStatusCode()),
				() -> assertEquals("Recipe name found", response.getBody()));

	}

//	@Test
//	public void testAddRecipes() {
//		RecipeDto recipeDto = new RecipeDto();
//		recipeDto.setRecipeName("maggie", null);
//		recipeDto.setInstructions("boil it");
//		recipeDto.setDate(LocalDate.now());
//
//		when(recipeService.addRecipes(recipeDto)).thenReturn(recipeDto);
//
//		ResponseEntity<RecipeDto> response = recipeController.addRecipes(recipeDto);
//
//		assertAll(() -> assertEquals(HttpStatus.OK, response.getStatusCode()),
//				() -> assertEquals(recipeDto, response.getBody()));
//
//	}

	@Test
	public void testUpdateRecipes() {
		int recipeId = 1;
		Recipe recipe = new Recipe();

		when(recipeService.updateRecipe(recipeId, recipe)).thenReturn(recipe);

		ResponseEntity<String> response = recipeController.updateRecipes(recipeId, recipe);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("updated Successfully", response.getBody());

	}

	@Test
	public void testDeleteRecipes() {
		int recipeId = 1;
		//when(recipeService.deleteRecipes(recipeId)).thenReturn(recipeId);
		//when(recipeService.deleteRecipes(recipeId)).thenReturn(true);

		ResponseEntity<String> response = recipeController.deleteRecipes(recipeId);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("Recipe is deleted", response.getBody());

	}

}