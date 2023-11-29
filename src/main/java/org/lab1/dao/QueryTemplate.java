package org.lab1.dao;

import org.lab1.dao.annotation.Column;
import org.lab1.dao.annotation.Condition;
import org.lab1.dao.annotation.Table;

import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public abstract class QueryTemplate<T> {
	private static final String UPDATE_QUERY = "UPDATE %s SET %s = %s WHERE %s;";
	private static final String SELECT_QUERY = "SELECT * FROM %s";
	private static final String DELETE_QUERY = "DELETE FROM %s WHERE %s";
	private static final String INSERT_QUERY = "INSERT INTO %s (%s) VALUES(%s);";

	private final Table table;
	private final Field[] fields;

	public QueryTemplate(Class<T> type) {
		this.table = type.getDeclaredAnnotation(Table.class);
		this.fields = type.getDeclaredFields();
	}

	public String selectAll() {
		return String.format(SELECT_QUERY + ";", table.value());
	}

	public String delete(String condition) {
		return String.format(DELETE_QUERY, table.value(), condition);
	}

	public String update(String column_name, Object value, String condition) throws Exception {
		if (value instanceof String s) {
			value = "'" + s + "'";
		}
		return String.format(UPDATE_QUERY, table.value(), column_name, value.toString(), condition);
	}

	public String selectById(UUID id) throws Exception {
		return String.format(SELECT_QUERY + " WHERE id = '%s';", table.value(), id);
	}

	public String insert(Object object) throws Exception {
		var record = getRecord(object);
		var columns = new StringBuilder();
		var values = new StringBuilder();
		for (var entry : record.entrySet()) {
			columns.append(entry.getKey()).append(",");
			values.append("?,"); // Using placeholders for parameters
		}
		columns.deleteCharAt(columns.length() - 1);
		values.deleteCharAt(values.length() - 1);
		return String.format(INSERT_QUERY, table.value(), columns, values);
	}

	protected <R> String check(Class<R> type, Object value) throws Exception {
		var methods = type.getMethods();
		for (var method : methods) {
			if (method != null) {
				var condition = method.getAnnotation(Condition.class);
				return String.format(condition.value(), value.toString());
			}
		}
		throw new Exception();
	}

	private Map<String, Object> getRecord(Object object) throws IllegalAccessException {
		var record = new HashMap<String, Object>();
		for (var field : fields) {
			field.setAccessible(true);
			var annotation = field.getAnnotation(Column.class);
			var entry = annotation != null ? annotation.value() : field.getName();
			var value = field.get(object);
			record.put(entry, value);
		}
		return record;
	}

	public <T> void setParameters(PreparedStatement preparedStatement, T object) throws Exception {
		var record = getRecord(object);
		int index = 1;
		for (var entry : record.entrySet()) {
			preparedStatement.setObject(index++, entry.getValue());
		}
	}
}