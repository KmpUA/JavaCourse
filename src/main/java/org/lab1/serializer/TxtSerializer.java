package org.lab1.serializer;


import java.io.*;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.UUID;

public class TxtSerializer<T> {

	public void serialize(T entity, String filePath) throws SerializationException {
		try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
			Field[] fields = entity.getClass().getDeclaredFields();
			writer.println(entity.getClass().getName());
			for (Field field : fields) {
				field.setAccessible(true);
				String fieldName = field.getName();
				Object value = field.get(entity);
				writer.println(fieldName + ": " + value);
			}
		} catch (IOException | IllegalAccessException e) {
			throw new RuntimeException("Failed to serialize to file: " + filePath, e);
		}
	}

	public T deserialize(String filePath) {
		T entity = null;
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			String name = reader.readLine();
			Class<?> entityClass = Class.forName(name);
			entity = (T) entityClass.newInstance();
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(": ", 2);
				if (parts.length == 2) {
					String key = parts[0];
					String value = parts[1];
					setEntityAttribute(entity, key, value);
				}
			}
		} catch (IOException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new RuntimeException("Failed to deserialize from file: " + filePath, e);
		}
		return entity;
	}

	private void setEntityAttribute(T entity, String key, String value) {
		try {
			Field field = entity.getClass().getDeclaredField(key);
			field.setAccessible(true);

			if (field.getType() == UUID.class) {
				field.set(entity, UUID.fromString(value));
			} else if (field.getType() == LocalDateTime.class) {
				field.set(entity, LocalDateTime.parse(value));
			} else {
				field.set(entity, value);
			}
		} catch (NoSuchFieldException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
