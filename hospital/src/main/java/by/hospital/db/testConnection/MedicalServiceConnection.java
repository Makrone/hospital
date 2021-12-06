package by.hospital.db.testConnection;

import by.hospital.dao.IMedicalAssignmentDAO;
import by.hospital.dao.impl.MedicalAssignmentDAOImpl;
import by.hospital.domain.MedicalServiceAssignment;

public class MedicalServiceConnection {
	public static void main(String[] args) {

		MedicalServiceAssignment md = new MedicalServiceAssignment();
		md.setMedicalServiceId(null);
		md.setQuantity(null);
		md.setTreatmentId(null);
		md.setId(null);
		
//		IMedicalAssignmentDAO med = new MedicalAssignmentDAOImpl();
//		Lond id = med.create(md);


	}
}
