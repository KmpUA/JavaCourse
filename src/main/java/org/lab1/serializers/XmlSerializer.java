package org.lab1.serializers;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;

public class XmlSerializer<T> implements EntitySerializer<T> {
	private final XmlMapper xmlMapper;

	public XmlSerializer() {
		xmlMapper = new XmlMapper();
	}
	@Override
	public void serialize(T entity, String filePath) throws SerializationException {
		xmlMapper.registerModule(new JavaTimeModule());
		xmlMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
		try {
			xmlMapper.writeValue(new File(filePath), entity);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public T deserialize(Class<T> entityType, String filePath) throws SerializationException {
		try {
			return xmlMapper.readValue(new File(filePath), entityType);
		} catch (IOException e) {
			throw new SerializationException("Failed to deserialize from XML", e);
		}
	}
}
