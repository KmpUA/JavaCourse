package org.lab1.serializers;

import org.lab1.entities.Client;
import org.lab1.serializers.JsonSerializer;
import org.lab1.serializers.SerializationException;
import org.testng.annotations.Test;

import java.time.LocalDateTime;

import static org.testng.Assert.*;

public class JsonSerializerTest {
	private final Client client;
	public JsonSerializerTest(){
		LocalDateTime date = LocalDateTime.of(2004, 7, 10, 0, 0 ,0);
		this.client = new Client.Builder("Maxym", "Paraniuk", date)
				.setPhoneNumber("+380958194039")
				.setAddress("Holovna str")
				.setEmail("delaamakcima1@gmail.com")
				.build();
	}
	@Test
	public void testJSONSerialize() throws SerializationException {
		JsonSerializer<Client> jsonSerializer = new JsonSerializer<>();
		jsonSerializer.serialize(client, "test.json");
		assertEquals(client.toString(), jsonSerializer.deserialize(Client.class, "test.json").toString());
	}
}