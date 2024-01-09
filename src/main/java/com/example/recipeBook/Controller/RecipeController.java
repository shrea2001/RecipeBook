package com.example.recipeBook.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.recipeBook.Dto.RecipeDto;
import com.example.recipeBook.Entity.Recipe;
import com.example.recipeBook.Service.RecipeService;

import jakarta.validation.Valid;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/recipes")
public class RecipeController {

	@Autowired
	private RecipeService recipeService;

	@GetMapping("/all")
	public ResponseEntity<List<Recipe>> fetchAllRecipes() {

		return new ResponseEntity<>(recipeService.getAllRecipes(), HttpStatus.OK);

	}

	@GetMapping("/sugar-and-milk")
	public ResponseEntity<List<Recipe>> findRecipesWithSugarAndMilk() {
		try {

			List<Recipe> recipe = recipeService.getRecipesWithSugarAndMilk();
			return new ResponseEntity<>(recipe, HttpStatus.OK);
		} catch (Exception e) {

			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/{recipeName}")
	public ResponseEntity<String> fetchRecipesByName(@PathVariable String recipeName) {
		
		try {
			// RecipeDto recipeDto =recipeService.getRecipeByName(recipeName);
			recipeService.getRecipeByName(recipeName);
			return new ResponseEntity<>("Recipe name found", HttpStatus.OK);
		} catch (Exception e) {

			return new ResponseEntity<>("Recipe name not found", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PostMapping("/save")
	public ResponseEntity<RecipeDto> addRecipes(@Valid @RequestBody RecipeDto recipeDto) {
		try {
			if (recipeDto.getDate() == null || recipeDto.getRecipeName() == null
					|| recipeDto.getInstructions() == null) {

				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
				
			}
//			if(recipeDto.getQuantity() <1||recipeDto.getQuantity()>100)
//			{
//				
//				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);	
//			}

			recipeService.addRecipes(recipeDto);

			return new ResponseEntity<>(recipeDto, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update/{recipeId}")
	public ResponseEntity<String> updateRecipes(@PathVariable int recipeId, @RequestBody Recipe recipe) {
		try {
			recipeService.updateRecipe(recipeId, recipe);
			
			return new ResponseEntity<>("updated Successfully", HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>("An error occured ", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	@DeleteMapping("/delete/{recipeId}")
	public ResponseEntity<String> deleteRecipes(@PathVariable int recipeId) {
		try {
			recipeService.deleteRecipes(recipeId);

			return new ResponseEntity<>("Recipe is deleted", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Something went wrong  ", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}