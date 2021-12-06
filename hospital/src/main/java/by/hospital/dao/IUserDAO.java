package by.hospital.dao;

import java.math.BigDecimal;
import java.util.List;

import by.hospital.domain.User;
import by.hospital.domain.type.UserType;

public interface IUserDAO extends IEntityDAO<User> {

	User findByUsername(String username);

	User addMoney(BigDecimal money);
	
	List<User> findByType(UserType type);
}
