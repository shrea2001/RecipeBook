package com.example.recipeBook.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.recipeBook.Entity.Ingredient;



@Repository
public interface IngredientRepository extends JpaRepository<Ingredient,Integer> {

}
