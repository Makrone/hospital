package by.hospital.service;

import by.hospital.dao.IMedicalAssignmentDAO;
import by.hospital.dao.impl.MedicalAssignmentDAOImpl;
import by.hospital.domain.MedicalServiceAssignment;
import by.hospital.exception.DAOException;
import by.hospital.exception.ServiceException;

public class MedicalAssignmentService {
	private IMedicalAssignmentDAO repository;

	public MedicalAssignmentService() {
		super();
		repository = new MedicalAssignmentDAOImpl();
	}

	public void create(MedicalServiceAssignment medicalServiceAssignment) throws ServiceException{
		try {
			repository.create(medicalServiceAssignment);
		}catch (DAOException e) {
			throw new ServiceException(e.getMessage(),e);
		}
	}

	public MedicalServiceAssignment findByAssignmentId(Long treatmentId) throws ServiceException {
		try {
			return repository.findByAssignmentId(treatmentId);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(),e);
		}
	}

}
