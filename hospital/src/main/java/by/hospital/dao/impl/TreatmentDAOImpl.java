package by.hospital.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.hospital.dao.ITreatmentDAO;
import by.hospital.domain.Treatment;
import by.hospital.exception.DAOException;

public class TreatmentDAOImpl extends EntityDAO<Treatment> implements ITreatmentDAO {

	private static final String SELECT_ALL_TREATMENS = "SELECT * FROM epam.treatment";
	private static final String SELECT_TREATMENT_BY_ID = "SELECT * FROM epam.treatment WHERE ID = ?";
	private static final String DELETE_TREATMENT_BY_ID = "DELETE FROM epam.treatment WHERE ID = ?";
	private static final String UPDATED_TREATMENT_BY_ID = "UPDATE epam.treatment SET client_id=?, doctor_id=?, medical_conclusion=?, date_time=? WHERE ID=?";
	private static final String CREATED_TREATMENT = "INSERT INTO epam.treatment (client_id, doctor_id, medical_conclusion, date_time) values(?,?,?,?)";
	private static final String SELECT_TREATMENS_BY_DOCTOR_ID = "SELECT * FROM epam.treatment WHERE doctor_id=?";
	private static final String SELECT_TREATMENS_BY_CLIENT_ID = "SELECT * FROM epam.treatment WHERE client_id=?";

	@Override
	public List<Treatment> findByDoctorId(Long doctorId) throws DAOException {
		Connection c = getConnection();
		List<Treatment> treatmens = new ArrayList<>();

		try (PreparedStatement preparedStatement = c.prepareStatement(SELECT_TREATMENS_BY_DOCTOR_ID)) {
			preparedStatement.setLong(1, doctorId);

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				treatmens.add(populateTreatment(resultSet));
			}
		} catch (SQLException e) {
			throw new DAOException("Find doctor error by Treatment", e);
		} finally {
			releaseConnection(c);
		}

		return treatmens;
	}

	@Override
	public List<Treatment> findByClientId(Long clientId) throws DAOException {
		Connection c = getConnection();
		List<Treatment> treatmens = new ArrayList<>();

		try (PreparedStatement preparedStatement = c.prepareStatement(SELECT_TREATMENS_BY_CLIENT_ID)) {
			preparedStatement.setLong(1, clientId);

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				treatmens.add(populateTreatment(resultSet));
			}
		} catch (SQLException e) {
			throw new DAOException("Find client error by Treatment", e);
		} finally {
			releaseConnection(c);
		}

		return treatmens;
	}

	@Override
	public Long create(Treatment entity) throws DAOException {
		Connection c = getConnection();
		try (PreparedStatement preparedStatement = c.prepareStatement(CREATED_TREATMENT,
				Statement.RETURN_GENERATED_KEYS)) {
			preparedStatement.setLong(1, entity.getClientId());
			preparedStatement.setLong(2, entity.getDoctorId());
			preparedStatement.setString(3, entity.getMedicalConclusion());
			preparedStatement.setTimestamp(4, entity.getDateTime());
			if (preparedStatement.executeUpdate() == 0) {
				throw new DAOException("Creating treatment failed, no rows affected.");
			}
			try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					entity.setId(generatedKeys.getLong(1));
				}

			}
			return entity.getId();
		} catch (SQLException e) {
			throw new DAOException("Create error by Treatment", e);
		} finally {
			releaseConnection(c);
		}

	}

	@Override
	public Long update(Treatment entity) throws DAOException {
		Connection c = getConnection();
		try (PreparedStatement preparedStatement = c.prepareStatement(UPDATED_TREATMENT_BY_ID)) {
			if (entity.getId() == null) {
				throw new DAOException("Entity id can't be null. ");
			}
			preparedStatement.setLong(1, entity.getClientId());
			preparedStatement.setLong(2, entity.getDoctorId());
			preparedStatement.setString(3, entity.getMedicalConclusion());
			preparedStatement.setTimestamp(4, entity.getDateTime());
			preparedStatement.setLong(5, entity.getId());
			if (preparedStatement.executeUpdate() > 1) {
				throw new DAOException("Updated more then one entity. Entity ID: " + entity.getId());
			}
			return entity.getId();
		} catch (SQLException e) {
			throw new DAOException("Update error by Treatment", e);
		} finally {
			releaseConnection(c);
		}
	}

	@Override
	public Boolean delete(Long id) throws DAOException {
		Connection c = getConnection();
		try (PreparedStatement preparedStatement = c.prepareStatement(DELETE_TREATMENT_BY_ID)) {
			preparedStatement.setLong(1, id);
			return preparedStatement.executeUpdate() > 0;
		} catch (SQLException e) {
			throw new DAOException("Delete error by Treatment", e);
		} finally {
			releaseConnection(c);
		}

	}

	@Override
	public Treatment get(Long id) throws DAOException {
		Connection c = getConnection();
		try (PreparedStatement preparedStatement = c.prepareStatement(SELECT_TREATMENT_BY_ID)) {
			preparedStatement.setLong(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return populateTreatment(resultSet);
			}
		} catch (SQLException e) {
			throw new DAOException("Get error by Treatment", e);
		} finally {
			releaseConnection(c);
		}

		return null;
	}

	@Override
	public List<Treatment> getAll() throws DAOException {
		Connection c = getConnection();
		List<Treatment> treatmens = new ArrayList<>();

		try (Statement statement = c.createStatement()) {
			ResultSet resultSet = statement.executeQuery(SELECT_ALL_TREATMENS);
			while (resultSet.next()) {
				treatmens.add(populateTreatment(resultSet));
			}
		} catch (SQLException e) {
			throw new DAOException("Get all error by Treatment", e);
		} finally {
			releaseConnection(c);
		}

		return treatmens;
	}

	private Treatment populateTreatment(ResultSet resultSet) throws SQLException {
		Treatment treatment = new Treatment();
		treatment.setId(resultSet.getLong(Fields.ID));
		treatment.setClientId(resultSet.getLong(Fields.ID_CLIENT));
		treatment.setDateTime(resultSet.getTimestamp(Fields.DATE_TIME));
		treatment.setDoctorId(resultSet.getLong(Fields.ID_DOCTOR));
		treatment.setMedicalConclusion(resultSet.getString(Fields.MEDICAL_CONCLUSIONS));

		return treatment;
	}

	class Fields {
		private static final String ID = "id";
		private static final String ID_CLIENT = "client_id";
		private static final String DATE_TIME = "date_time";
		private static final String ID_DOCTOR = "doctor_id";
		private static final String MEDICAL_CONCLUSIONS = "medical_conclusion";
	}

}
