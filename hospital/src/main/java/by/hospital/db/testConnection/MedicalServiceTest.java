package by.hospital.db.testConnection;

import java.math.BigDecimal;

import by.hospital.dao.IMedicalServiceDAO;
import by.hospital.dao.impl.MedicalServiceDAOImpl;
import by.hospital.domain.MedicalService;
import by.hospital.exception.DAOException;

public class MedicalServiceTest {
	public static void main(String[] args) throws DAOException{

		MedicalService md = new MedicalService();
		md.setName("Процедура имя");
		md.setDescription("МРТ позвоночника");
		md.setCost(BigDecimal.valueOf(2231));
		IMedicalServiceDAO med = new MedicalServiceDAOImpl();
		med.create(md);

	}
}
