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

public class UserTest {

	public static void main(String[] args) throws DAOException {
		Date date = new Date();
		Timestamp ts = new Timestamp(date.getTime());
		User user = new User();
		user.setCreated(ts);
		user.setEmail("email@mail.ru");
		user.setFirstName("Oleg");
		user.setGender(Gender.MALE);
		user.setLastName("Kuznetsov");
		user.setMoney(BigDecimal.valueOf(10241));
		user.setPassword("Qwerty123");
		user.setPhone("+37529123-11-12");
		user.setType(UserType.CLIENT);
		user.setUpdated(null);
		user.setUsername("killer3221");
		IUserDAO ud = new UserDAOImpl();
//		User id = ud.get(7l);
		User id = ud.findByUsername("TestFindUser");
		System.out.println(id);

		// ud.delete(1L);
//		System.out.println();
//		System.out.println(id);
//		User u1 = ud.get(2L);
//		System.out.println(u1);

//		ud.update(user);

	}
}