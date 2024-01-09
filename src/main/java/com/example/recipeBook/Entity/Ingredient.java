package com.example.recipeBook.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "INGREDIENTS")
public class Ingredient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "INGREDIENT_ID")
	private int ingredientId;

	@Column(name = "INGREDIENT_NAME")
	private String ingredientName;

	@Min(value = 1, message = " Quantity must be atleast one")
	@Max(value = 100, message = " Quantity cannot exceed 100")
	@Column(name = "QUANTITY")
	private int quantity;

	@Column(name = "MEASUREMENT")
	private String measurement;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "recipe_id")
	private Recipe recipe;

	public Ingredient() {
		super();
	}

	public Ingredient(int ingredientId, String ingredientName,
			@Min(value = 1, message = " Quantity must be atleast one") @Max(value = 100, message = " Quantity cannot exceed 100") int quantity,
			String measurement, Recipe recipe) {
		super();
		this.ingredientId = ingredientId;
		this.ingredientName = ingredientName;
		this.quantity = quantity;
		this.measurement = measurement;
		this.recipe = recipe;
	}

	public int getIngredientId() {
		return ingredientId;
	}

	public void setIngredientId(int ingredientId) {
		this.ingredientId = ingredientId;
	}

	public String getIngredientName() {
		return ingredientName;
	}

	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getMeasurement() {
		return measurement;
	}

	public void setMeasurement(String measurement) {
		this.measurement = measurement;
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}
}
