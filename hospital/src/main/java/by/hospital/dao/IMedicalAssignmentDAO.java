package by.hospital.dao;

import by.hospital.domain.MedicalServiceAssignment;
import by.hospital.exception.DAOException;

public interface IMedicalAssignmentDAO extends IEntityDAO <MedicalServiceAssignment> {

	MedicalServiceAssignment findByAssignmentId(Long treatmentId) throws DAOException;

}
