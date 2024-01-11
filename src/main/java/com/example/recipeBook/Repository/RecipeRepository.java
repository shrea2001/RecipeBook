package com.example.recipeBook.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.recipeBook.Entity.Recipe;


@Repository
public interface RecipeRepository extends JpaRepository<Recipe,Integer>{

}
