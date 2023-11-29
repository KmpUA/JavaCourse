package org.lab1.dao;

import lombok.Getter;
import org.lab1.utility.AppConfig;

import java.sql.*;
import java.util.UUID;

public class PSQLConnection {

	private final Connection connection;
	private QueryTemplate<?> queries;

	public PSQLConnection() throws Exception {
		this.connection = DriverManager.getConnection(AppConfig.getProperty("DB_URL"),
				AppConfig.getProperty("DB_USER"), AppConfig.getProperty("DB_PASSWORD"));
	}

	public <T extends QueryTemplate<?>> void sync(T queries) {
		this.queries = queries;
	}

	public void close() throws SQLException {
		this.connection.close();
	}

	public <T> int insert(T object) throws Exception {
		String query = queries.insert(object);
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			setParameters(preparedStatement, object);

			if (canExecute()) {
				return preparedStatement.executeUpdate();
			}
		} catch (SQLException e) {
			throw new SQLException("Failed to execute insert operation", e);
		}
		throw new SQLException("Cannot execute");
	}

	public int update(String column_name, Object value, String condition) throws Exception {
		String query = queries.update(column_name, value, condition);
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			if (canExecute()) {
				return preparedStatement.executeUpdate();
			}
			throw new Exception("Cannot execute");
		}
	}

	public int delete(String condition) throws Exception {
		String query = queries.delete(condition);
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			if (canExecute()) {
				return preparedStatement.executeUpdate();
			}
			throw new Exception("Cannot execute");
		}
	}

	private <T> void setParameters(PreparedStatement preparedStatement, T object) throws Exception {
		if (queries != null) {
			QueryTemplate<?> template = (QueryTemplate<?>) queries;
			template.setParameters(preparedStatement, object);
		}
	}

	public ResultSet selectAll() throws Exception {
		PreparedStatement preparedStatement = connection.prepareStatement(queries.selectAll());
		if (canExecute()) {
			return preparedStatement.executeQuery();
		}
		throw new Exception("Cannot execute");
	}

	public ResultSet select(UUID id) throws Exception {
		PreparedStatement preparedStatement = connection.prepareStatement(queries.selectById(id));
		if (canExecute()) {
			return preparedStatement.executeQuery();
		}
		throw new Exception("Cannot execute");
	}

	private boolean canExecute() {
		return queries != null;
	}

}