package by.hospital.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.hospital.dao.IMedicalAssignmentDAO;
import by.hospital.domain.MedicalServiceAssignment;
import by.hospital.exception.DAOException;

public class MedicalAssignmentDAOImpl extends EntityDAO<MedicalServiceAssignment> implements IMedicalAssignmentDAO {

	private static final String SELECT_ALL_MEDICAMENTS = "SELECT * FROM epam.medical_service_assignment";
	private static final String SELECT_MEDICAMENT_BY_ID = "SELECT * FROM epam.medical_service_assignment WHERE ID = ?";
	private static final String DELETE_MEDICAMENT_BY_ID = "DELETE FROM epam.medical_service_assignment WHERE ID = ?";
	private static final String UPDATED_MEDICAMENT_BY_ID = "UPDATE epam.medical_service_assignment SET treatment_id = ?, "
			+ "medical_service_id = ? , quantity = ? WHERE ID= ?";
	private static final String CREATED_MEDICAMENT = "INSERT INTO epam.medical_service_assignment (treatment_id,medical_service_id,quantity) values(?,?,?)";
	private static final String FIND_MEDICAL_SERVICE_ASSIGNMENT_BY_ID = "SELECT * FROM epam.medical_service_assignment WHERE treatment_id = ?";

	@Override
	public Long create(MedicalServiceAssignment entity) throws DAOException{
		Connection c = getConnection();
		try (PreparedStatement preparedStatement = c.prepareStatement(CREATED_MEDICAMENT,
				Statement.RETURN_GENERATED_KEYS)) {
			preparedStatement.setLong(1, entity.getTreatmentId());
			preparedStatement.setLong(2, entity.getMedicalServiceId());
			preparedStatement.setInt(3, entity.getQuantity());
			if (preparedStatement.executeUpdate() == 0) {
				throw new DAOException("Creating medicament assigment failed, no rows affected.");
			}
			try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					entity.setId(generatedKeys.getLong(1));
				}

			}
			return entity.getId();
		} catch (SQLException e) {
			throw new DAOException ("Create error of MedicalServiceAssignment",e);
		} finally {
			releaseConnection(c);
		}
	}

	@Override
	public Long update(MedicalServiceAssignment entity) throws DAOException{
		Connection c = getConnection();
		try (PreparedStatement preparedStatement = c.prepareStatement(UPDATED_MEDICAMENT_BY_ID)) {
			if (entity.getId() == null) {
				throw new DAOException("Entity id can't be null. ");
			}
			preparedStatement.setLong(1, entity.getTreatmentId());
			preparedStatement.setLong(2, entity.getMedicalServiceId());
			preparedStatement.setInt(3, entity.getQuantity());
			if (preparedStatement.executeUpdate() > 1) {
				throw new DAOException("Update more then one entity. Entity ID: " + entity.getId());
			}
			return entity.getId();
		} catch (SQLException e) {
			throw new DAOException ("Update error of MedicalServiceAssignment",e);
		} finally {
			releaseConnection(c);
		}
	}

	@Override
	public Boolean delete(Long id) throws DAOException{
		Connection c = getConnection();
		try (PreparedStatement preparedStatement = c.prepareStatement(DELETE_MEDICAMENT_BY_ID)) {
			preparedStatement.setLong(1, id);
			return preparedStatement.executeUpdate() > 0;
		} catch (SQLException e) {
			throw new DAOException ("Delete error of MedicalServiceAssignment",e);
		} finally {
			releaseConnection(c);
		}
	}

	@Override
	public MedicalServiceAssignment get(Long id) throws DAOException{
		Connection c = getConnection();
		try (PreparedStatement preparedStatement = c.prepareStatement(SELECT_MEDICAMENT_BY_ID)) {
			preparedStatement.setLong(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return populateMedicalAssignment(resultSet);
			}
		} catch (SQLException e) {
			throw new DAOException ("Get error of MedicalServiceAssignment",e);
		} finally {
			releaseConnection(c);
		}

		return null;
	}

	@Override
	public List<MedicalServiceAssignment> getAll() throws DAOException{
		Connection c = getConnection();
		List<MedicalServiceAssignment> medicaments = new ArrayList<>();

		try (Statement statement = c.createStatement()) {
			ResultSet resultSet = statement.executeQuery(SELECT_ALL_MEDICAMENTS);
			while (resultSet.next()) {
				medicaments.add(populateMedicalAssignment(resultSet));
			}
		} catch (SQLException e) {
			throw new DAOException ("Get all error of MedicalServiceAssignment",e);
		}finally {
			releaseConnection(c);
		}

		return medicaments;
	}
	@Override
	public MedicalServiceAssignment findByAssignmentId(Long treatmentId) throws DAOException{
		Connection c = getConnection();
		try (PreparedStatement preparedStatement = c.prepareStatement(FIND_MEDICAL_SERVICE_ASSIGNMENT_BY_ID)) {
			preparedStatement.setLong(1, treatmentId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return populateMedicalAssignment(resultSet);
			}
		} catch (SQLException e) {
			throw new DAOException ("Find error of MedicalServiceAssignment",e);
		} finally {
			releaseConnection(c);
		}

		return null;
	}

	private MedicalServiceAssignment populateMedicalAssignment(ResultSet resultSet) throws SQLException {
		MedicalServiceAssignment medicamentAssigment = new MedicalServiceAssignment();
		medicamentAssigment.setId(resultSet.getLong(Fields.ID));
		medicamentAssigment.setTreatmentId(resultSet.getLong(Fields.TREATMENT_ID));
		medicamentAssigment.setMedicalServiceId(resultSet.getLong(Fields.MEDICAL_SERVICE_ID));
		medicamentAssigment.setQuantity(resultSet.getInt(Fields.QUANTITY));

		return medicamentAssigment;
	}

	class Fields {
		private static final String ID = "id";
		private static final String TREATMENT_ID = "treatment_id";
		private static final String MEDICAL_SERVICE_ID = "medical_service_id";
		private static final String QUANTITY = "quantity";

	}





}
