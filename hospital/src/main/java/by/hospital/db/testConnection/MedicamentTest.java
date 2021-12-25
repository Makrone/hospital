package by.hospital.db.testConnection;

import java.math.BigDecimal;

import by.hospital.dao.IMedicamentDAO;
import by.hospital.dao.impl.MedicamentDAOImpl;
import by.hospital.domain.Medicament;
import by.hospital.exception.DAOException;

public class MedicamentTest {
	
	public static void main(String[] args) throws DAOException{
		Medicament md = new Medicament();
		md.setName("Aspirin");
		md.setCost(BigDecimal.valueOf(141));
		md.setDescription("DescriptionTest");
		IMedicamentDAO med = new MedicamentDAOImpl();
		Medicament mre = med.findByName("Aspirin");
		
		System.out.println(mre);

	}
}
