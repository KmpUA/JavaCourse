package org.lab1.serializer;

import java.io.IOException;

public interface EntitySerializer<T> {
	void serialize(T entity, String filePath) throws SerializationException;
	T deserialize(Class<T> entityType, String filePath) throws SerializationException, IOException;
}
