package org.lab1.serializers;

import com.google.gson.*;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeTypeAdapter implements JsonDeserializer<LocalDateTime>, JsonSerializer<LocalDateTime> {
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-uuuu HH:mm:ss");

	@Override
	public JsonElement serialize(LocalDateTime localDateTime, Type srcType,
	                             JsonSerializationContext context) {

		return new JsonPrimitive(formatter.format(localDateTime));
	}

	@Override
	public LocalDateTime deserialize(JsonElement json, Type typeOfT,
	                                 JsonDeserializationContext context) {

		return LocalDateTime.parse(json.getAsString(), formatter);
	}
}