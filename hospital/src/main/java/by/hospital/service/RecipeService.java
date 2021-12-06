package by.hospital.service;

import by.hospital.dao.IRecipeDAO;
import by.hospital.dao.impl.RecipeDAOImpl;
import by.hospital.domain.Recipe;

public class RecipeService {
	private IRecipeDAO repository;

	public RecipeService() {
		super();
		repository = new RecipeDAOImpl();
	}

	public void create(Recipe recipe) {

		repository.create(recipe);
	}
}
