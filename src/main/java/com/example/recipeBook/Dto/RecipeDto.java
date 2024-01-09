package com.example.recipeBook.Dto;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.recipeBook.Entity.Ingredient;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Component
public class RecipeDto {
	private int recipeId;

	private Map<String, String> recipeName = new HashMap<String, String>();

	private String instructions;

	@JsonIgnore
	private String recipeNameKey;
	private LocalDate date;

	private boolean status;
	private String summary;
	//private int quantity;

	private List<Ingredient> ingredient;

	public RecipeDto() {
		super();
	}

	public RecipeDto(int recipeId, Map<String, String> recipeName, String instructions, LocalDate date, boolean status,
			String summary, List<Ingredient> ingredient) {
		super();
		this.recipeId = recipeId;
		this.recipeName = recipeName;
		this.instructions = instructions;
		this.date = date;
		this.status = status;
		this.summary = summary;
		this.ingredient = ingredient;
	}

	public int getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}

	@JsonAnyGetter
	public Map<String, String> getRecipeName() {
		return recipeName;
	}

	public String getRecipeNameKey() {
		return recipeNameKey;
	}

	@JsonAnySetter
	public void setRecipeName(@Value("${recipe.dto.recipeName}") String key, String value) {
		recipeName.put(key, value);
		recipeNameKey = key;
		System.out.println("Key name is: " + key + " Value is: " + value);
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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

//	public int getQuantity() {
//		return quantity;
//	}
//
//	public void setQuantity(int quantity) {
//		this.quantity = quantity;
//	}

	public List<Ingredient> getIngredient() {
		return ingredient;
	}

	public void setIngredient(List<Ingredient> ingredient) {
		this.ingredient = ingredient;
	}

}