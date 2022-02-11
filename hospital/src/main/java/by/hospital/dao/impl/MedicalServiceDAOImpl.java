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
import by.hospital.exception.DAOException;

public class MedicalServiceDAOImpl extends EntityDAO<MedicalService> implements IMedicalServiceDAO {

	private static final String SELECT_ALL_SERVICES = "SELECT * FROM epam.medical_service";
	private static final String SELECT_SERVICE_BY_ID = "SELECT * FROM epam.medical_service WHERE ID = ?";
	private static final String DELETE_SERVICE_BY_ID = "DELETE FROM epam.medical_service WHERE ID = ?";
	private static final String UPDATED_SERVICE_BY_ID = "UPDATE epam.medical_service SET cost = ?, description = ? , name = ? WHERE ID= ?";
	private static final String CREATED_SERVICE = "INSERT INTO epam.medical_service (cost,description,name) values(?,?,?)";

	@Override
	public Long create(MedicalService entity) throws DAOException {
		Connection c = getConnection();
		try (PreparedStatement preparedStatement = c.prepareStatement(CREATED_SERVICE,
				Statement.RETURN_GENERATED_KEYS)) {
			preparedStatement.setBigDecimal(1, entity.getCost());
			preparedStatement.setString(2, entity.getDescription());
			preparedStatement.setString(3, entity.getName());
			if (preparedStatement.executeUpdate() == 0) {
				throw new DAOException("Creating service failed, no rows affected.");
			}
			try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					entity.setId(generatedKeys.getLong(1));
				}

			}
			return entity.getId();
		} catch (SQLException e) { 
			throw new DAOException("Create error by MedicalService", e);
		} finally {
			releaseConnection(c);
		}
	}

	@Override
	public Long update(MedicalService entity) throws DAOException{
		Connection c = getConnection();
		try (PreparedStatement preparedStatement = c.prepareStatement(UPDATED_SERVICE_BY_ID)) {
			if (entity.getId() == null) {
				throw new DAOException("Entity id can't be null. ");
			}
			preparedStatement.setBigDecimal(1, entity.getCost());
			preparedStatement.setString(2, entity.getDescription());
			preparedStatement.setString(3, entity.getName());
			preparedStatement.setLong(4, entity.getId());
			if (preparedStatement.executeUpdate() > 1) {
				throw new DAOException("Updated more then one entity. Entity ID: " + entity.getId());
			}
			return entity.getId();
		} catch (SQLException e) {
			throw new DAOException("Update error by MedicalService", e);
		} finally {
			releaseConnection(c);
		}
	}

	@Override
	public Boolean delete(Long id) throws DAOException{
		Connection c = getConnection();
		try (PreparedStatement preparedStatement = c.prepareStatement(DELETE_SERVICE_BY_ID)) {
			preparedStatement.setLong(1, id);
			return preparedStatement.executeUpdate() > 0;
		} catch (SQLException e) {
			throw new DAOException("Delete error by MedicalService", e);
		} finally {
			releaseConnection(c);
		}

	}

	@Override
	public MedicalService get(Long id) throws DAOException{
		Connection c = getConnection();
		try (PreparedStatement preparedStatement = c.prepareStatement(SELECT_SERVICE_BY_ID)) {
			preparedStatement.setLong(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return populateService(resultSet);
			}
		} catch (SQLException e) {
			throw new DAOException("Get by id error by MedicalService", e);
		} finally {
			releaseConnection(c);
		}

		return null;
	}

	@Override
	public List<MedicalService> getAll() throws DAOException{
		Connection c = getConnection();
		List<MedicalService> service = new ArrayList<>();

		try (Statement statement = c.createStatement()) {
			ResultSet resultSet = statement.executeQuery(SELECT_ALL_SERVICES);
			while (resultSet.next()) {
				service.add(populateService(resultSet));
			}
		} catch (SQLException e) {
			throw new DAOException("Get all error by MedicalService", e);
		} finally {
			releaseConnection(c);
		}

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
