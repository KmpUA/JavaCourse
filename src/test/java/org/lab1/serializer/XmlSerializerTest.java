package org.lab1.serializer;

import org.lab1.entity.Client;
import org.testng.annotations.Test;

import java.time.LocalDateTime;

import static org.testng.Assert.assertEquals;

public class XmlSerializerTest {
	private final Client client;

	public XmlSerializerTest() {
		LocalDateTime date = LocalDateTime.of(2004, 7, 10, 0, 0 ,0);
		this.client = new Client.Builder("Maxym", "Paraniuk", date)
				.setPhoneNumber("+380958194039")
				.setAddress("Holovna str")
				.setEmail("delaamakcima1@gmail.com")
				.build();
	}

	@Test
	public void testXMLSerialize() throws SerializationException {
		XmlSerializer<Client> xmlSerializer = new XmlSerializer<>();
		xmlSerializer.serialize(client, "test.xml");
		assertEquals(client, xmlSerializer.deserialize(Client.class, "test.xml"));
	}
}