package by.hospital.db.testConnection;

import by.hospital.dao.IUserDAO;
import by.hospital.dao.impl.UserDAOImpl;
import by.hospital.domain.User;
import by.hospital.exception.DAOException;

public class UserTest {

	public static void main(String[] args) throws DAOException {
		IUserDAO ud = new UserDAOImpl();
		User id = ud.get(7l);
		id.getMoney();
		System.out.println(id);

		// ud.delete(1L);
//		System.out.println();
//		System.out.println(id);
//		User u1 = ud.get(2L);
//		System.out.println(u1);

//		ud.update(user);

	}
}