package by.hospital.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.hospital.dao.IMedicamentDAO;
import by.hospital.domain.Medicament;

public class MedicamentDAOImpl extends EntityDAO<Medicament> implements IMedicamentDAO {

	private static final String SELECT_ALL_MEDICAMENTS = "SELECT * FROM epam.medicament";
	private static final String SELECT_MEDICAMENT_BY_ID = "SELECT * FROM epam.medicament WHERE ID = ?";
	private static final String DELETE_MEDICAMENT_BY_ID = "DELETE FROM epam.medicament WHERE ID = ?";
	private static final String UPDATED_MEDICAMENT_BY_ID = "UPDATE epam.medicament SET name = ?, descriptoin = ? , cost = ? WHERE ID= ?";
	private static final String CREATED_MEDICAMENT = "INSERT INTO epam.medicament (name,description,cost) values(?,?,?)";
	private static final String FIND_BY_NAME = "SELECT * FROM epam.medicament WHERE name = ?";

	@Override
	public Long create(Medicament entity) {
		Connection c = getConnection();
		try (PreparedStatement preparedStatement = c.prepareStatement(CREATED_MEDICAMENT,
				Statement.RETURN_GENERATED_KEYS)) {
			preparedStatement.setString(1, entity.getName());
			preparedStatement.setString(2, entity.getDescription());
			preparedStatement.setBigDecimal(3, entity.getCost());
			if (preparedStatement.executeUpdate() == 0) {
				throw new SQLException("Creating medicament failed, no rows affected.");
			}
			try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					entity.setId(generatedKeys.getLong(1));
				}

			}
			return entity.getId();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Long update(Medicament entity) {
		Connection c = getConnection();
		try (PreparedStatement preparedStatement = c.prepareStatement(UPDATED_MEDICAMENT_BY_ID)) {
			if (entity.getId() == null) {
				throw new SQLException("Entity id can't be null. ");
			}
			preparedStatement.setString(1, entity.getName());
			preparedStatement.setString(2, entity.getDescription());
			preparedStatement.setBigDecimal(3, entity.getCost());
			if (preparedStatement.executeUpdate() > 1) {
				throw new SQLException("Updated more then one entity. Entity ID: " + entity.getId());
			}
			return entity.getId();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Boolean delete(Long id) {
		Connection c = getConnection();
		try (PreparedStatement preparedStatement = c.prepareStatement(DELETE_MEDICAMENT_BY_ID)) {
			preparedStatement.setLong(1, id);
			return preparedStatement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Medicament get(Long id) {
		Connection c = getConnection();
		try (PreparedStatement preparedStatement = c.prepareStatement(SELECT_MEDICAMENT_BY_ID)) {
			preparedStatement.setLong(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return populateMedicament(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Medicament> getAll() {
		Connection c = getConnection();
		List<Medicament> medicaments = new ArrayList<>();

		try (Statement statement = c.createStatement()) {
			ResultSet resultSet = statement.executeQuery(SELECT_ALL_MEDICAMENTS);
			while (resultSet.next()) {
				medicaments.add(populateMedicament(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		releaseConnection(c);

		return medicaments;
	}

	@Override
	public Medicament findByName(String name) {
		Connection c = getConnection();
		try (PreparedStatement preparedStatement = c.prepareStatement(FIND_BY_NAME)) {
			preparedStatement.setString(1, name);
			ResultSet resultSet = preparedStatement.executeQuery();
			return populateMedicament(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	private Medicament populateMedicament(ResultSet resultSet) throws SQLException {

		Medicament medicament = new Medicament();
		medicament.setId(resultSet.getLong(Fields.ID));
		medicament.setName(resultSet.getString(Fields.NAME));
		medicament.setDescription(resultSet.getString(Fields.DESCRIPTION));
		medicament.setCost(resultSet.getBigDecimal(Fields.COST));

		return medicament;
	}

	class Fields {
		private static final String ID = "id";
		private static final String NAME = "name";
		private static final String DESCRIPTION = "description";
		private static final String COST = "cost";

	}

}
