package by.hospital.service;

import by.hospital.dao.IRecipeDAO;
import by.hospital.dao.impl.RecipeDAOImpl;
import by.hospital.domain.Recipe;
import by.hospital.exception.DAOException;
import by.hospital.exception.ServiceException;

public class RecipeService {
	private IRecipeDAO repository;

	public RecipeService() {
		super();
		repository = new RecipeDAOImpl();
	}

	public void create(Recipe recipe) throws ServiceException {
		try {
			repository.create(recipe);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public Recipe findByTreatmentId(Long treatmentId) throws ServiceException {
		try {
			return repository.findByTreatmentId(treatmentId);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

}
