package by.hospital.db.testConnection;

import by.hospital.dao.IMedicalAssignmentDAO;
import by.hospital.dao.impl.MedicalAssignmentDAOImpl;
import by.hospital.domain.MedicalServiceAssignment;
import by.hospital.exception.DAOException;

public class MedicalAssignmentConnection {

	public static void main(String[] args) throws DAOException {

		MedicalServiceAssignment meds = new MedicalServiceAssignment();
		meds.setMedicalServiceId(2L);
		meds.setQuantity(5);
		meds.setTreatmentId(2L);
		IMedicalAssignmentDAO imeds = new MedicalAssignmentDAOImpl();
		Long id = imeds.create(meds);
		System.out.println(id);

	}

}
