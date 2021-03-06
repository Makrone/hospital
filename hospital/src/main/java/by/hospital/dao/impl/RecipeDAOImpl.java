package by.hospital.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.hospital.dao.IRecipeDAO;
import by.hospital.domain.Recipe;
import by.hospital.exception.DAOException;

public class RecipeDAOImpl extends EntityDAO<Recipe> implements IRecipeDAO {

	private static final String SELECT_ALL_RECIPES = "SELECT * FROM epam.recipe";
	private static final String SELECT_RECIPE_BY_ID = "SELECT * FROM epam.recipe WHERE ID = ?";
	private static final String DELETE_RECIPE_BY_ID = "DELETE FROM epam.recipe WHERE ID = ?";
	private static final String UPDATED_RECIPE_BY_ID = "UPDATE epam.recipe SET treatment_id = ?, medicament_id = ? ,quantity = ? WHERE ID= ?";
	private static final String CREATED_RECIPE = "INSERT INTO epam.recipe (treatment_id,medicament_id,quantity) values(?,?,?)";
	private static final String FIND_RECIPE_BY_TREATMENT_ID = "SELECT * FROM epam.recipe WHERE treatment_id = ?";

	@Override
	public Long create(Recipe entity) throws DAOException {
		Connection c = getConnection();
		try (PreparedStatement preparedStatement = c.prepareStatement(CREATED_RECIPE,
				Statement.RETURN_GENERATED_KEYS)) {
			preparedStatement.setLong(1, entity.getTreatmentId());
			preparedStatement.setLong(2, entity.getMedicamentId());
			preparedStatement.setInt(3, entity.getQuantity());
			if (preparedStatement.executeUpdate() == 0) {
				throw new DAOException("Creating recipe failed, no rows affected.");
			}
			try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					entity.setId(generatedKeys.getLong(1));
				}

			}
			return entity.getId();
		} catch (SQLException e) {
			throw new DAOException("Creatig error of Recipe", e);
		} finally {
			releaseConnection(c);
		}

	}

	@Override
	public Long update(Recipe entity) throws DAOException {
		Connection c = getConnection();
		try (PreparedStatement preparedStatement = c.prepareStatement(UPDATED_RECIPE_BY_ID)) {
			if (entity.getId() == null) {
				throw new DAOException("Entity id can't be null. ");
			}
			preparedStatement.setLong(1, entity.getTreatmentId());
			preparedStatement.setLong(2, entity.getMedicamentId());
			preparedStatement.setInt(3, entity.getQuantity());
			if (preparedStatement.executeUpdate() > 1) {
				throw new DAOException("Updated more then one entity. Entity ID: " + entity.getId());
			}
			return entity.getId();
		} catch (SQLException e) {
			throw new DAOException("Update error of Recipe", e);
		} finally {
			releaseConnection(c);
		}
	}

	@Override
	public Boolean delete(Long id) throws DAOException {
		Connection c = getConnection();
		try (PreparedStatement preparedStatement = c.prepareStatement(DELETE_RECIPE_BY_ID)) {
			preparedStatement.setLong(1, id);
			return preparedStatement.executeUpdate() > 0;
		} catch (SQLException e) {
			throw new DAOException("Delete error of Recipe", e);
		} finally {
			releaseConnection(c);
		}

	}

	@Override
	public Recipe get(Long id) throws DAOException {
		Connection c = getConnection();
		try (PreparedStatement preparedStatement = c.prepareStatement(SELECT_RECIPE_BY_ID)) {
			preparedStatement.setLong(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return populateRecipe(resultSet);
			}
		} catch (SQLException e) {
			throw new DAOException("Get error of Recipe", e);
		} finally {
			releaseConnection(c);
		}

		return null;
	}

	@Override
	public Recipe findByTreatmentId(Long treatmentId) throws DAOException {
		Connection c = getConnection();
		try (PreparedStatement preparedStatement = c.prepareStatement(FIND_RECIPE_BY_TREATMENT_ID)) {
			preparedStatement.setLong(1, treatmentId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return populateRecipe(resultSet);
			}
		} catch (SQLException e) {
			throw new DAOException("Find treatment error of Recipe", e);
		} finally {
			releaseConnection(c);
		}

		return null;
	}

	@Override
	public List<Recipe> getAll() throws DAOException {
		Connection c = getConnection();
		List<Recipe> recipe = new ArrayList<>();

		try (Statement statement = c.createStatement()) {
			ResultSet resultSet = statement.executeQuery(SELECT_ALL_RECIPES);
			while (resultSet.next()) {
				recipe.add(populateRecipe(resultSet));
			}
		} catch (SQLException e) {
			throw new DAOException("Get all error of Recipe", e);
		} finally {
			releaseConnection(c);
		}

		return recipe;
	}

	private Recipe populateRecipe(ResultSet resultSet) throws SQLException {
		Recipe recipe = new Recipe();
		recipe.setId(resultSet.getLong(Fields.ID));
		recipe.setTreatmentId(resultSet.getLong(Fields.TREATMENT_ID));
		recipe.setMedicamentId(resultSet.getLong(Fields.MEDICAMENT_ID));
		recipe.setQuantity(resultSet.getInt(Fields.QUANTITY));
		return recipe;
	}

	class Fields {
		private static final String ID = "id";
		private static final String TREATMENT_ID = "treatment_id";
		private static final String MEDICAMENT_ID = "medicament_id";
		private static final String QUANTITY = "quantity";

	}

}
