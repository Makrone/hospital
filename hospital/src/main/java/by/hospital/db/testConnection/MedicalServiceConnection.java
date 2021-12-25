package by.hospital.db.testConnection;

import by.hospital.domain.MedicalServiceAssignment;
import by.hospital.exception.DAOException;

public class MedicalServiceConnection {
	public static void main(String[] args) throws DAOException{

		MedicalServiceAssignment md = new MedicalServiceAssignment();
		md.setMedicalServiceId(null);
		md.setQuantity(null);
		md.setTreatmentId(null);
		md.setId(null);
		
//		IMedicalAssignmentDAO med = new MedicalAssignmentDAOImpl();
//		Lond id = med.create(md);


	}
}
