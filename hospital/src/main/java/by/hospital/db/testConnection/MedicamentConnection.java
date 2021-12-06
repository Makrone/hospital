package by.hospital.db.testConnection;

import java.math.BigDecimal;

import by.hospital.dao.IMedicamentDAO;
import by.hospital.dao.impl.MedicamentDAOImpl;
import by.hospital.domain.Medicament;

public class MedicamentConnection {
	public static void main(String[] args) {
		Medicament md = new Medicament();
		md.setName("oleg");
		md.setCost(BigDecimal.valueOf(141));
		md.setDescription("DescriptionTest");
		IMedicamentDAO med = new MedicamentDAOImpl();
		Long id = med.create(md);
//		Medicament mmd = med.get(1L);
//		System.out.println(mmd);

	}
}
