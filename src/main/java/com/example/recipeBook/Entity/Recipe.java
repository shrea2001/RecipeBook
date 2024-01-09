package com.example.recipeBook.Entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "RECIPES")
public class Recipe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RECIPE_ID")
	private int recipeId;

	@NotNull
	@Column(name = "RECIPE_NAME")
	private String recipeName;

	@NotNull
	@Column(name = "INSTRUCTIONS")
	private String instructions;

	@NotNull
	@Column(name = "DATE")
	private LocalDate date;

	@Column(name = "SUMMARY")
	private String summary;

	@NotNull
	private boolean status;
	@Column(name = "INGREDIENTS")
	@OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
	private List<Ingredient> ingredient;

	public Recipe() {
		super();
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Recipe(int recipeId, String recipeName, String instructions, LocalDate date, String summary, boolean status,
			List<Ingredient> ingredient) {
		super();
		this.recipeId = recipeId;
		this.recipeName = recipeName;
		this.instructions = instructions;
		this.date = date;
		this.summary = summary;
		this.status = status;
		this.ingredient = ingredient;
	}

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

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public List<Ingredient> getIngredient() {
		return ingredient;
	}

	public void setIngredient(List<Ingredient> ingredient) {
		this.ingredient = ingredient;
	}

}
