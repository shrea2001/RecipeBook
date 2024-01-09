package com.example.recipeBook.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import com.example.recipeBook.Entity.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {

	Recipe findByRecipeName(String recipeName);

	// @Query(value="select * from recipes where recipe_id in "+"(select recipe_id  from ingredients where ingredient_name ='sugar' OR ingredient_name='milk' order by recipe_id)" ,nativeQuery = true)
	@Query(value = "select * from recipes  where recipe_id in "
			+ "(select recipe_id from ingredients  where ingredient_name ='sugar') and recipe_id in "
		+ " (select recipe_id from ingredients  where ingredient_name ='milk') order by recipe_id", nativeQuery = true)
	List<Recipe> findRecipesWithSugarAndMilk();
}
