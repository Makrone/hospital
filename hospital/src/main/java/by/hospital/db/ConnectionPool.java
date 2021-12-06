package by.hospital.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConnectionPool {
	private static BlockingQueue<Connection> freeConnections;
	private static List<Connection> allConnections;
	private static final int CONNECTION_POOL_SIZE = 10;

	private static volatile ConnectionPool instance;

	public static ConnectionPool getInstance() {
		ConnectionPool localInstance = instance;
		if (localInstance == null) {
			synchronized (ConnectionPool.class) {
				localInstance = instance;
				if (localInstance == null) {
					instance = localInstance = new ConnectionPool();
				}
			}
		}
		return localInstance;
	}

	private ConnectionPool() {
		super();
		init();

	}

	private void init() {

		String url = "jdbc:postgresql://localhost/academy";
		Properties props = new Properties();
		props.setProperty("user", "postgres");
		props.setProperty("password", "1");
		freeConnections = new ArrayBlockingQueue<>(CONNECTION_POOL_SIZE);
		allConnections = new ArrayList<>(CONNECTION_POOL_SIZE);
		try {
			DriverManager.registerDriver(new org.postgresql.Driver());
			for (int i = 0; i < CONNECTION_POOL_SIZE; i++) {
				Connection connection = DriverManager.getConnection(url, props);
				freeConnections.add(connection);
				allConnections.add(connection);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public Connection getConnection() {
		Connection connection = null;
		try {
			connection = freeConnections.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public void closeConnection(Connection connection) {

		freeConnections.offer(connection);

	}

	public void destroy() throws SQLException {
		for (int i = 0; i < allConnections.size(); i++) {
			allConnections.get(i).close();
		}

	}

}
