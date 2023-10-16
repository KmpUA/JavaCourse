package org.lab1.serializers;

import org.lab1.entities.Client;
import org.testng.annotations.Test;

import java.time.LocalDateTime;

import static org.testng.Assert.*;

public class TxtSerializerTest {

	private final Client client;

	public TxtSerializerTest() {
		LocalDateTime date = LocalDateTime.of(2004, 7, 10, 0, 0 ,0);
		this.client = new Client.Builder("Maxym", "Paraniuk", date)
				.setPhoneNumber("+380958194039")
				.setAddress("Holovna str")
				.setEmail("delaamakcima1@gmail.com")
				.build();
	}

	@Test
	public void testTxtSerialize() throws SerializationException {
		TxtSerializer<Client> txtSerializer = new TxtSerializer<Client>();
		txtSerializer.serialize(client, "test.txt");
		assertEquals(client, txtSerializer.deserialize("test.txt"));
	}
}