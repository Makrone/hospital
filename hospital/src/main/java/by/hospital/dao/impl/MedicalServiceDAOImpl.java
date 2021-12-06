package by.hospital.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.hospital.dao.IMedicalServiceDAO;
import by.hospital.domain.MedicalService;

public class MedicalServiceDAOImpl extends EntityDAO<MedicalService> implements IMedicalServiceDAO {

	private static final String SELECT_ALL_SERVICES = "SELECT * FROM epam.medical_service";
	private static final String SELECT_SERVICE_BY_ID = "SELECT * FROM epam.medical_service WHERE ID = ?";
	private static final String DELETE_SERVICE_BY_ID = "DELETE FROM epam.medical_service WHERE ID = ?";
	private static final String UPDATED_SERVICE_BY_ID = "UPDATE epam.medical_service SET cost = ?, description = ? , name = ? WHERE ID= ?";
	private static final String CREATED_SERVICE = "INSERT INTO epam.medical_service (cost,description,name) values(?,?,?)";

	@Override
	public Long create(MedicalService entity) {
		Connection c = getConnection();
		try (PreparedStatement preparedStatement = c.prepareStatement(CREATED_SERVICE,
				Statement.RETURN_GENERATED_KEYS)) {
			preparedStatement.setBigDecimal(1, entity.getCost());
			preparedStatement.setString(2, entity.getDescription());
			preparedStatement.setString(3, entity.getName());
			if (preparedStatement.executeUpdate() == 0) {
				throw new SQLException("Creating service failed, no rows affected.");
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
	public Long update(MedicalService entity) {
		Connection c = getConnection();
		try (PreparedStatement preparedStatement = c.prepareStatement(UPDATED_SERVICE_BY_ID)) {
			if (entity.getId() == null) {
				throw new SQLException("Entity id can't be null. ");
			}			
			preparedStatement.setBigDecimal(1, entity.getCost());
			preparedStatement.setString(2, entity.getDescription());
			preparedStatement.setString(3, entity.getName());
			preparedStatement.setLong(4, entity.getId());
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
		try (PreparedStatement preparedStatement = c.prepareStatement(DELETE_SERVICE_BY_ID)) {
			preparedStatement.setLong(1, id);
			return preparedStatement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public MedicalService get(Long id) {
		Connection c = getConnection();
		try (PreparedStatement preparedStatement = c.prepareStatement(SELECT_SERVICE_BY_ID)) {
			preparedStatement.setLong(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				return populateService(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<MedicalService> getAll() {
		Connection c = getConnection();
		List<MedicalService> service = new ArrayList<>();

		try (Statement statement = c.createStatement()) {
			ResultSet resultSet = statement.executeQuery(SELECT_ALL_SERVICES);
			while (resultSet.next()) {
				service.add(populateService(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		releaseConnection(c);

		return service;
	}

	private MedicalService populateService(ResultSet resultSet) throws SQLException {
		MedicalService service = new MedicalService();
		service.setId(resultSet.getLong(Fields.ID));
		service.setCost(resultSet.getBigDecimal(Fields.COST));
		service.setDescription(resultSet.getString(Fields.DESCRIPTION));
		service.setName(resultSet.getString(Fields.NAME));

		return service;
	}

	class Fields {
		private static final String ID = "id";
		private static final String COST = "cost";
		private static final String DESCRIPTION = "description";
		private static final String NAME = "name";
	}

}
