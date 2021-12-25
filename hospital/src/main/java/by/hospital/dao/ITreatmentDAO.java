package by.hospital.dao;

import java.util.List;

import by.hospital.domain.Treatment;
import by.hospital.exception.DAOException;

public interface ITreatmentDAO extends IEntityDAO<Treatment> {

	List<Treatment> findByDoctorId(Long doctorId) throws DAOException;

	List<Treatment> findByClientId(Long clientId) throws DAOException;

}
