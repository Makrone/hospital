package by.hospital.dao;

import java.math.BigDecimal;
import java.util.List;

import by.hospital.domain.User;
import by.hospital.domain.type.UserType;
import by.hospital.exception.DAOException;

public interface IUserDAO extends IEntityDAO<User>{

	User findByUsername(String username) throws DAOException;

	User addMoney(BigDecimal money) throws DAOException;
	
	List<User> findByType(UserType type) throws DAOException;
}
