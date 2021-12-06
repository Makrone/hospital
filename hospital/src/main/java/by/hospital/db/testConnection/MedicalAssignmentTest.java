package by.hospital.db.testConnection;

import by.hospital.dao.IMedicalAssignmentDAO;
import by.hospital.dao.impl.MedicalAssignmentDAOImpl;
import by.hospital.domain.MedicalServiceAssignment;

public class MedicalAssignmentTest {

	public static void main(String[] args) {

		MedicalServiceAssignment meds = new MedicalServiceAssignment();
		meds.setMedicalServiceId(2L);
		meds.setQuantity(5);
		meds.setTreatmentId(2L);
		IMedicalAssignmentDAO imeds = new MedicalAssignmentDAOImpl();
		MedicalServiceAssignment ms = imeds.get(2l);
		System.out.println(ms);

	}

}
