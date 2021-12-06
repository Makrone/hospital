package by.hospital.service;

import by.hospital.dao.IMedicalAssignmentDAO;
import by.hospital.dao.impl.MedicalAssignmentDAOImpl;
import by.hospital.domain.MedicalServiceAssignment;

public class MedicalAssignmentService {
	private IMedicalAssignmentDAO repository;

	public MedicalAssignmentService() {
		super();
		repository = new MedicalAssignmentDAOImpl();
	}

	public void create(MedicalServiceAssignment medicalServiceAssignment) {

		repository.create(medicalServiceAssignment);
	}

}
