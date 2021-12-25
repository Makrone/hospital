package by.hospital.db.testConnection;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import by.hospital.dao.IUserDAO;
import by.hospital.dao.impl.UserDAOImpl;
import by.hospital.domain.User;
import by.hospital.domain.type.Gender;
import by.hospital.domain.type.UserType;
import by.hospital.exception.DAOException;

public class TestConnection {

	public static void main(String[] args) throws DAOException{
		Date date = new Date();
		Timestamp ts = new Timestamp(date.getTime());
		User user = new User();
		user.setCreated(ts);
		user.setEmail("emadfdfdil@mail.ru");
		user.setFirstName("Oleggggg");
		user.setGender(Gender.MALE);
		user.setLastName("Kuzndfdfdfetsov");
		user.setMoney(BigDecimal.valueOf(10241));
		user.setPassword("111asd23");
		user.setPhone("+37529123123123");
		user.setType(UserType.CLIENT);
		user.setUpdated(null);
		user.setUsername("ki23221");
//		user.setId(2L);
		IUserDAO ud = new UserDAOImpl();
//		ud.delete(1L);
//		System.out.println();
//		Long id = ud.create(user);
//		System.out.println(id);
//		User u1 = ud.get(2L);
//		System.out.println(u1);

//		ud.update(user);

	}
}