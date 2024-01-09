package com.example.recipeBook.Service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.recipeBook.Dto.RecipeDto;
import com.example.recipeBook.Entity.Recipe;
import com.example.recipeBook.Repository.RecipeRepository;

import java.time.LocalDate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class RecipeServiceImplementationTest {

	@Mock
	private RecipeRepository recipeRepository;

	@InjectMocks
	private RecipeServiceImplementation recipeService;

	@Test
	public void testGetAllRecipes() {
		List<Recipe> expectedRecipes = Arrays.asList(
				new Recipe(1, "Recipe1", "Instructions1", LocalDate.now(), "Summary1", true, null),
				new Recipe(2, "Recipe2", "Instructions2", LocalDate.now(), "Summary2", true, null));

		when(recipeRepository.findAll()).thenReturn(expectedRecipes);

		List<Recipe> actualRecipes = recipeService.getAllRecipes();

		assertEquals(expectedRecipes, actualRecipes);

	}

	@Test
	public void testAddRecipe() {
		RecipeDto recipeDto = new RecipeDto();
		
		recipeDto.setDate(LocalDate.now());
 
		Recipe expectedRecipe = new Recipe(1, "Recipe1", "Instructions1", LocalDate.now(), "Summary1", true, null);
 
		when(recipeRepository.save(any())).thenReturn(expectedRecipe);
 
		RecipeDto savedRecipeDto = recipeService.addRecipes(recipeDto);
		assertEquals(expectedRecipe.getDate(), savedRecipeDto.getDate());

 
	}

	@Test
	public void testUpdateRecipe() {
		int recipeId = 1;
		Recipe updatedRecipe = new Recipe(recipeId, "UpdatedRecipe", "UpdatedInstructions", LocalDate.now(),
				"UpdatedSummary", true, null);

		when(recipeRepository.findById(recipeId)).thenReturn(Optional.of(new Recipe()));
		when(recipeRepository.save(updatedRecipe)).thenReturn(updatedRecipe);
		Recipe savedRecipe = recipeService.updateRecipe(recipeId, updatedRecipe);

		assertEquals(updatedRecipe.getRecipeName(), savedRecipe.getRecipeName());

	}

	@Test
	public void testDeleteRecipe() {
		int recipeId = 1;
		Recipe deleteRecipes = new Recipe();
		deleteRecipes.setStatus(true);

		when(recipeRepository.findById(recipeId)).thenReturn(Optional.of(deleteRecipes));

		// when(recipeRepository.save(deleteRecipes)).thenReturn(deletedRecipes);

		// verify(recipeRepository).findById(recipeId);
		recipeService.deleteRecipes(recipeId);
		verify(recipeRepository).save(deleteRecipes);

		assertFalse(deleteRecipes.getStatus());

		// assertEquals(deletedRecipes.getStatus(),deleteRecipes.getStatus());

	}
}