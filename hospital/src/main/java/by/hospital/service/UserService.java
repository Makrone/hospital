package by.hospital.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import by.hospital.dao.IUserDAO;
import by.hospital.dao.impl.UserDAOImpl;
import by.hospital.domain.User;
import by.hospital.domain.type.UserType;
import by.hospital.exception.DAOException;
import by.hospital.exception.ServiceException;

public class UserService {

	private IUserDAO repository;

	public UserService() {
		super();
		repository = new UserDAOImpl();
	}

	public void create(User user) throws ServiceException {
		try {
			user.setCreated(new Timestamp(new Date().getTime()));
			repository.create(user);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public User findByUsername(String username) throws ServiceException {
		try {
			return repository.findByUsername(username);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public Boolean delete(Long id) throws ServiceException {
		try {
			return repository.delete(id);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public List<User> getAll() throws ServiceException {
		try {
			return repository.getAll();
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public List<User> findByType(UserType type) throws ServiceException {
		try {
			return repository.findByType(type);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public User getById(Long id) throws ServiceException {
		try {
			return repository.get(id);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void update(User user) throws ServiceException {
		try {
			user.setUpdated(new Timestamp(new Date().getTime()));
			repository.update(user);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public BigDecimal pay(Long userId, BigDecimal money) throws ServiceException {
		try {
			User user = repository.get(userId);
			BigDecimal userMoney = user.getMoney();
			BigDecimal total = userMoney.subtract(money);
			user.setMoney(total);
			repository.update(user);
			return total;
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}

	}
}
