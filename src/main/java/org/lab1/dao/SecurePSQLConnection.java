package org.lab1.dao;

import lombok.Getter;
import org.lab1.dao.annotation.Column;
import org.lab1.dao.annotation.Table;
import org.lab1.utility.AppConfig;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.Properties;
import java.util.UUID;

public class SecurePSQLConnection {

	private final Connection connection;
	@Getter
	private final Statement statement;

	public SecurePSQLConnection() throws Exception {
		Class.forName("org.postgresql.Driver");
		Properties props = new Properties();
		props.setProperty("user", AppConfig.getProperty("DB_USER"));
		props.setProperty("password", AppConfig.getProperty("DB_PASSWORD"));
		this.connection = DriverManager.getConnection(AppConfig.getProperty("DB_URL"), props);
		this.statement = connection.createStatement();
	}

	public void close() throws SQLException {
		this.connection.close();
	}

	public <T> int insert(T object) throws Exception {
		PreparedStatement preparedStatement = generateInsertStatement(object);
		if (preparedStatement != null) {
			return preparedStatement.executeUpdate();
		}
		throw new Exception("Cannot execute");
	}

	public <T> int update(T object, UUID id) throws Exception {
		PreparedStatement preparedStatement = generateUpdateStatement(object, id);
		return preparedStatement.executeUpdate();
	}

	public int delete(UUID id, Class<?> type) throws Exception {
		PreparedStatement preparedStatement = generateDeleteStatement(id, type);
		return preparedStatement.executeUpdate();
	}

	public <T> ResultSet selectAll(Class<T> type) throws Exception {
		PreparedStatement preparedStatement = generateSelectAllStatement(type);
		if (preparedStatement != null) {
			return preparedStatement.executeQuery();
		}
		throw new Exception("Cannot execute");
	}

	public <T> ResultSet selectById(UUID id, Class<T> type) throws Exception {
		PreparedStatement preparedStatement = generateSelectByIdStatement(id, type);
		return preparedStatement.executeQuery();
	}

	private <T> PreparedStatement generateInsertStatement(T object) throws Exception {
		Table table = object.getClass().getDeclaredAnnotation(Table.class);
		Field[] fields = object.getClass().getDeclaredFields();

		String tableName = table.value();
		StringBuilder columns = new StringBuilder();
		StringBuilder values = new StringBuilder();

		for (Field field : fields) {
			field.setAccessible(true);
			Column annotation = field.getAnnotation(Column.class);
			String columnName = (annotation != null) ? annotation.value() : field.getName();

			columns.append(columnName).append(",");
			values.append("?,");
		}

		columns.deleteCharAt(columns.length() - 1);
		values.deleteCharAt(values.length() - 1);

		String query = "INSERT INTO " + tableName + " (" + columns + ") VALUES(" + values + ")";
		PreparedStatement preparedStatement = connection.prepareStatement(query);

		int index = 1;
		for (Field field : fields) {
			field.setAccessible(true);
			Object value = field.get(object);
			if(!(value instanceof String)){
				value = value.toString();
			}
			preparedStatement.setObject(index++, value);
		}

		return preparedStatement;
	}

	private <T> PreparedStatement generateUpdateStatement(T object, UUID id) throws Exception {
		Table table = object.getClass().getDeclaredAnnotation(Table.class);
		Field[] fields = object.getClass().getDeclaredFields();

		String tableName = table.value();
		StringBuilder setClause = new StringBuilder();

		for (Field field : fields) {
			field.setAccessible(true);
			Column annotation = field.getAnnotation(Column.class);
			String columnName = (annotation != null) ? annotation.value() : field.getName();

			if (!columnName.equals("id")) {
				setClause.append(columnName).append(" = ?,");
			}
		}

		setClause.deleteCharAt(setClause.length() - 1);

		String query = "UPDATE " + tableName + " SET " + setClause + " WHERE id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);

		int index = 1;
		for (Field field : fields) {
			field.setAccessible(true);
			Object value = field.get(object);
			if(!(value instanceof String)){
				value = value.toString();
			}
			if (!field.getName().equals("id")) {
				preparedStatement.setObject(index++, value);
			}
		}
		preparedStatement.setObject(index, id);

		return preparedStatement;
	}

	private PreparedStatement generateDeleteStatement(UUID id, Class<?> type) throws SQLException {
		Table table = type.getDeclaredAnnotation(Table.class);
		String tableName = table.value();
		String query = "DELETE FROM " + tableName + " WHERE id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setObject(1, id.toString());
		return preparedStatement;
	}

	private <T> PreparedStatement generateSelectAllStatement(Class<T> type) throws SQLException {
		Table table = type.getDeclaredAnnotation(Table.class);
		String tableName = table.value();
		String query = "SELECT * FROM " + tableName;
		return connection.prepareStatement(query);
	}

	private <T> PreparedStatement generateSelectByIdStatement(UUID id, Class<T> type) throws SQLException {
		Table table = type.getDeclaredAnnotation(Table.class);
		String tableName = table.value();
		String query = "SELECT * FROM " + tableName + " WHERE id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setObject(1, id.toString());
		return preparedStatement;
	}
}
