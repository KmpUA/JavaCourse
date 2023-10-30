package org.lab1;

import org.lab1.entities.*;
import org.lab1.serializers.JsonSerializer;
import org.lab1.serializers.SerializationException;
import org.lab1.serializers.TxtSerializer;
import org.lab1.serializers.XmlSerializer;

import java.time.LocalDateTime;

public class Main {
	public static void main(String[] args) throws SerializationException {
		LocalDateTime localDateTime = LocalDateTime.of(2005, 7, 10, 0, 0, 0);
		LocalDateTime localDateTime2 = LocalDateTime.of(1991, 12, 30, 0, 0, 0);
		Client client1 = new Client.Builder("Maxym", "Aaraniuk", localDateTime2)
				.setPhoneNumber("+380958194039")
				.setEmail("delamakcima1@gmail.com")
				.build();


		Client client2 = new Client.Builder("Maxym", "Maraniuk", localDateTime)
				.setPhoneNumber("+380958194039")
				.setEmail("delamakcima1@gmail.com")
				.build();

		TxtSerializer<Client> txtSerializer = new TxtSerializer<Client>();
		txtSerializer.serialize(client1, "test.txt");
		System.out.println("-------------TxtSerializer debug---------------");
		System.out.println(txtSerializer.deserialize("test.txt"));

		XmlSerializer<Client> xmlSerializer = new XmlSerializer<>();
		xmlSerializer.serialize(client1, "test.xml");
		System.out.println("-------------XmlSerializer debug---------------");
		System.out.println(xmlSerializer.deserialize(Client.class, "test.xml"));
		JsonSerializer<Client> jsonSerializer = new JsonSerializer<>();
		jsonSerializer.serialize(client1, "test.json");
		System.out.println("-------------JsonSerializer debug---------------");
		System.out.println(client1);
		Client client3 = xmlSerializer.deserialize(Client.class, "test.xml");
		Client client4 = txtSerializer.deserialize("test.txt");
		System.out.println(client3.equals(client4));
	}
}
