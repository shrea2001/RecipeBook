package com.example.recipeBook.Entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "RECIPES")
public class Recipe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int recipeId;
	private String recipeName;
	private String instructions;
	private LocalDate date;

	@OneToMany(mappedBy = "recipe")
	private List<Ingredient> ingredient;

	public int getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}

	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

}
