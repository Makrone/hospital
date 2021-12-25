package by.hospital.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.hospital.dao.IUserDAO;
import by.hospital.domain.User;
import by.hospital.domain.type.Gender;
import by.hospital.domain.type.UserType;
import by.hospital.exception.DAOException;

public class UserDAOImpl extends EntityDAO<User> implements IUserDAO {

	private static final String SELECT_ALL_USERS = "SELECT * FROM epam.users";
	private static final String SELECT_USER_BY_ID = "SELECT * FROM epam.users WHERE ID = ?";
	private static final String DELETE_USER_BY_ID = "DELETE FROM epam.users WHERE ID = ?";
	private static final String UPDATED_USER_BY_ID = "UPDATE epam.users SET first_name=?, last_name=?, email=?, username=?,"
			+ "updated=?, type=?, phone=?, gender=?, money=? WHERE ID=?";
	private static final String CREATED_USER = "INSERT INTO epam.users (first_name,last_name,email,username,created,updated,password,type,phone,gender,money)"
			+ " values(?,?,?,?,?,?,?,?,?,?,?)";
	private static final String FIND_USER_BY_USERNAME = "SELECT * FROM epam.users WHERE username = ?";
	private static final String FIND_BY_TYPE = "SELECT * FROM epam.users WHERE type = ?";

	@Override
	public Long create(User entity) throws DAOException{
		Connection c = getConnection();
		try (PreparedStatement preparedStatement = c.prepareStatement(CREATED_USER, Statement.RETURN_GENERATED_KEYS)) {
			preparedStatement.setString(1, entity.getFirstName());
			preparedStatement.setString(2, entity.getLastName());
			preparedStatement.setString(3, entity.getEmail());
			preparedStatement.setString(4, entity.getUsername());
			preparedStatement.setTimestamp(5, entity.getCreated());
			preparedStatement.setTimestamp(6, entity.getUpdated());
			preparedStatement.setString(7, entity.getPassword());
			preparedStatement.setString(8, entity.getType() != null ? entity.getType().name() : null);
			preparedStatement.setString(9, entity.getPhone());
			preparedStatement.setString(10, entity.getGender() != null ? entity.getGender().name() : null);
			preparedStatement.setBigDecimal(11, entity.getMoney());
			if (preparedStatement.executeUpdate() == 0) {
				throw new DAOException("Creating user failed, no rows affected.");
			}
			try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					entity.setId(generatedKeys.getLong(1));
				}

			}
			return entity.getId();
		} catch (SQLException e) {
			throw new DAOException("Create error by User",e);
		} finally {
			releaseConnection(c);
		}

	}

	@Override
	public Long update(User entity) throws DAOException{

		Connection c = getConnection();
		try (PreparedStatement preparedStatement = c.prepareStatement(UPDATED_USER_BY_ID)) {
			if (entity.getId() == null) {
				throw new DAOException("Entity id can't be null. ");
			}
			preparedStatement.setString(1, entity.getFirstName());
			preparedStatement.setString(2, entity.getLastName());
			preparedStatement.setString(3, entity.getEmail());
			preparedStatement.setString(4, entity.getUsername());
			preparedStatement.setTimestamp(5, entity.getUpdated());
			preparedStatement.setString(6, entity.getType() != null ? entity.getType().name() : null);
			preparedStatement.setString(7, entity.getPhone());
			preparedStatement.setString(8, entity.getGender() != null ? entity.getGender().name() : null);
			preparedStatement.setBigDecimal(9, entity.getMoney());
			preparedStatement.setLong(10, entity.getId());
			if (preparedStatement.executeUpdate() > 1) {
				throw new DAOException("Updated more then one entity. Entity ID: " + entity.getId());
			}
			return entity.getId();
		} catch (SQLException e) {
			throw new DAOException("Update error by User",e);
		}
	}

	@Override
	public Boolean delete(Long id) throws DAOException{
		Connection c = getConnection();
		try (PreparedStatement preparedStatement = c.prepareStatement(DELETE_USER_BY_ID)) {
			preparedStatement.setLong(1, id);
			return preparedStatement.executeUpdate() > 0;
		} catch (SQLException e) {
			throw new DAOException("Delete error by User",e);
		} finally {
			releaseConnection(c);
		}

	}

	@Override
	public User get(Long id) throws DAOException{
		Connection c = getConnection();
		try (PreparedStatement preparedStatement = c.prepareStatement(SELECT_USER_BY_ID)) {
			preparedStatement.setLong(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return populateUser(resultSet);
			}
		} catch (SQLException e) {
			throw new DAOException("Get error by User",e);
		} finally {
			releaseConnection(c);
		}

		return null;
	}

	@Override
	public User findByUsername(String username) throws DAOException{
		Connection c = getConnection();
		try (PreparedStatement preparedStatement = c.prepareStatement(FIND_USER_BY_USERNAME)) {
			preparedStatement.setString(1, username);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return populateUser(resultSet);
			}
		} catch (SQLException e) {
			throw new DAOException("Find username error by User",e);
		} finally {
			releaseConnection(c);
		}

		return null;
	}

	@Override
	public User addMoney(BigDecimal money) throws DAOException{
		Connection c = getConnection();
		try (PreparedStatement preparedStatement = c.prepareStatement(CREATED_USER)) {
			preparedStatement.setBigDecimal(1, money);
			ResultSet resultSet = preparedStatement.executeQuery();
			return populateUser(resultSet);
		} catch (SQLException e) {
			throw new DAOException("Add money error by User",e);
		} finally {
			releaseConnection(c);
		}
	}

	@Override
	public List<User> getAll() throws DAOException{
		Connection c = getConnection();
		List<User> users = new ArrayList<>();

		try (Statement statement = c.createStatement()) {
			ResultSet resultSet = statement.executeQuery(SELECT_ALL_USERS);
			while (resultSet.next()) {
				users.add(populateUser(resultSet));
			}
		} catch (SQLException e) {
			throw new DAOException("Get all error by User",e);
		} finally {
			releaseConnection(c);
		}	
		return users;
	}

	@Override
	public List<User> findByType(UserType type) throws DAOException{
		Connection c = getConnection();
		List<User> users = new ArrayList<>();
		try (PreparedStatement preparedStatement = c.prepareStatement(FIND_BY_TYPE)) {
			preparedStatement.setString(1, type.name());
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				users.add(populateUser(resultSet));
			}
		} catch (SQLException e) {
			throw new DAOException("Find type error by User",e);
		}
		releaseConnection(c);
		
		return users;
	}

	private User populateUser(ResultSet resultSet) throws SQLException {
		User user = new User();
		user.setId(resultSet.getLong(Fields.ID));
		user.setFirstName(resultSet.getString(Fields.FIRST_NAME));
		user.setLastName(resultSet.getString(Fields.LAST_NAME));
		user.setEmail(resultSet.getString(Fields.EMAIL));
		user.setUsername(resultSet.getString(Fields.USERNAME));
		user.setCreated(resultSet.getTimestamp(Fields.CREATED));
		user.setUpdated(resultSet.getTimestamp(Fields.UPDATED));
		user.setPassword(resultSet.getString(Fields.PASSWORD));
		user.setType(UserType.valueOf(resultSet.getString(Fields.TYPE)));
		user.setPhone(resultSet.getString(Fields.PHONE));
		user.setGender(Gender.valueOf(resultSet.getString(Fields.GENDER)));
		user.setMoney(resultSet.getBigDecimal(Fields.MONEY));
		return user;
	}

	class Fields {
		private static final String ID = "id";
		private static final String FIRST_NAME = "first_name";
		private static final String LAST_NAME = "last_name";
		private static final String EMAIL = "email";
		private static final String USERNAME = "username";
		private static final String CREATED = "created";
		private static final String UPDATED = "updated";
		private static final String PASSWORD = "password";
		private static final String TYPE = "type";
		private static final String PHONE = "phone";
		private static final String GENDER = "gender";
		private static final String MONEY = "money";

	}

}
