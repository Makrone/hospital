package by.hospital.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import by.hospital.dao.IUserDAO;
import by.hospital.dao.impl.UserDAOImpl;
import by.hospital.domain.User;
import by.hospital.domain.type.UserType;

public class UserService {

	private IUserDAO repository;

	public UserService() {
		super();
		repository = new UserDAOImpl();
	}

	public void create(User user) {
		Date date = new Date();
		user.setCreated(new Timestamp(date.getTime()));
		repository.create(user);
	}

	public User findByUsername(String username) {
		return repository.findByUsername(username);
	}

	public User addMoney(BigDecimal money) {
		return repository.addMoney(money);
	}

	public List<User> getAll() {
		return repository.getAll();
	}
	
	public List<User> findByType(UserType type) { 
		return repository.findByType(type);
	}
	

}
