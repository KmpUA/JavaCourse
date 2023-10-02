package org.lab1.serializers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class JsonSerializer<T> implements EntitySerializer<T> {

	private final Gson gson;

	public JsonSerializer() {
		this.gson = new GsonBuilder()
				.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter())
				.create();
	}

	@Override
	public void serialize(T entity, String filePath) throws SerializationException {
		try (FileWriter writer = new FileWriter(filePath)) {
			gson.toJson(entity, writer);
		} catch (IOException e) {
			throw new SerializationException("Failed to serialize to JSON", e);
		}
	}

	@Override
	public T deserialize(Class<T> entityType, String filePath) throws SerializationException {
		try (FileReader reader = new FileReader(filePath)) {
			return gson.fromJson(reader, entityType);
		} catch (IOException e) {
			throw new SerializationException("Failed to deserialize from JSON", e);
		}
	}
}
