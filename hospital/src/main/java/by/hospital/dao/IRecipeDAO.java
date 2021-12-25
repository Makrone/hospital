package by.hospital.dao;

import by.hospital.domain.Recipe;
import by.hospital.exception.DAOException;

public interface IRecipeDAO extends IEntityDAO<Recipe>{

	Recipe findByTreatmentId(Long treatmentId) throws DAOException;

}
