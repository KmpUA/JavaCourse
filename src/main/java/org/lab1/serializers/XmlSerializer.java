package org.lab1.serializers;

import java.beans.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.UUID;

public class XmlSerializer<T> implements EntitySerializer<T> {

	public static class UUIDPersistenceDelegate extends PersistenceDelegate {
		private final HashSet<UUID> hashesWritten = new HashSet<UUID>();

		public Expression instantiate(Object oldInstance, Encoder out) {
			UUID id = (UUID) oldInstance;
			hashesWritten.add(id);
			return new Expression(oldInstance, UUID.class, "fromString", new Object[]{id.toString()});
		}

		protected boolean mutatesTo(Object oldInstance, Object newInstance) {
			return hashesWritten.contains(oldInstance);
		}
	}
	@Override
	public void serialize(T entity, String filePath) throws SerializationException {
		try {
			FileOutputStream fos = new FileOutputStream(filePath);
			XMLEncoder encoder = new XMLEncoder(fos);

			encoder.setPersistenceDelegate(LocalDateTime.class,
					new PersistenceDelegate() {
						@Override
						protected Expression instantiate(Object localDate, Encoder encdr) {
							return new Expression(localDate,
									LocalDateTime.class,
									"parse",
									new Object[]{localDate.toString()});
						}

					});
			encoder.setPersistenceDelegate(UUID.class, new UUIDPersistenceDelegate());

			encoder.setExceptionListener(new ExceptionListener() {
				public void exceptionThrown(Exception e) {
					System.out.println("Exception! :"+e.toString());
				}
			});

			encoder.writeObject(entity);
			encoder.close();
			fos.close();
		} catch (IOException e) {
			throw new SerializationException("Failed to serialize to XML", e);
		}
	}

	@Override
	public T deserialize(Class<T> entityType, String filePath) throws SerializationException {
		try {
			FileInputStream fis = new FileInputStream(filePath);
			XMLDecoder decoder = new XMLDecoder(fis);
			T decodedSettings = (T) decoder.readObject();
			decoder.close();
			fis.close();
			return decodedSettings;
		} catch (IOException e) {
			throw new SerializationException("Failed to deserialize from XML", e);
		}
	}
}
