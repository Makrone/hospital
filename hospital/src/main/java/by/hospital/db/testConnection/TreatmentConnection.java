package by.hospital.db.testConnection;

import by.hospital.dao.ITreatmentDAO;
import by.hospital.dao.impl.TreatmentDAOImpl;
import by.hospital.domain.Treatment;

public class TreatmentConnection {
	public static void main(String[] args) { 
		Treatment tr = new Treatment();
		tr.setClientId(3L);
		tr.setDoctorId(2L);
		tr.setMedicalConclusion("Лекарство");
		ITreatmentDAO td = new TreatmentDAOImpl();
		td.create(tr);
		
//	любо удаляю с скюл

	}
}
