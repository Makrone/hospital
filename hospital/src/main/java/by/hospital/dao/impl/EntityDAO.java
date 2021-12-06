package by.hospital.dao.impl;

import java.sql.Connection;

import by.hospital.dao.IEntityDAO;
import by.hospital.db.ConnectionPool;
import by.hospital.domain.Entity;

public abstract class EntityDAO<T extends Entity> implements IEntityDAO<T> {

	private ConnectionPool connectionPool;

	public EntityDAO() {
		super();
		this.connectionPool = ConnectionPool.getInstance();
	}

	public Connection getConnection() {
		return connectionPool.getConnection();
	}

	public void releaseConnection(Connection connection) {
		connectionPool.closeConnection(connection);

	}



}

