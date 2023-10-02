package org.lab1.entities;

import org.testng.annotations.Test;

import java.time.LocalDateTime;

import static org.testng.Assert.*;

public class ClientTest {

	private final Client client1, client2;

	public ClientTest(){
		LocalDateTime localDateTime = LocalDateTime.of(2004, 7, 10, 0, 0, 0);
		client1 = new Client.Builder("Maxym", "Xaraniuk", localDateTime)
				.setPhoneNumber("+380958194039")
				.setAddress("Holovna str")
				.setEmail("delaamakcima1@gmail.com")
				.build();

		client2 = new Client.Builder("Maxym", "Aaraniuk", localDateTime)
				.setPhoneNumber("+380958194039")
				.setAddress("Holovna str")
				.setEmail("delaamakcima1@gmail.com")
				.build();
	}

	@Test
	public void testCompareTo() {
		assertEquals(23, client1.compareTo(client2));
		assertEquals(-23, client2.compareTo(client1));
		client1.setLastName("Aaraniuk");
		client1.setFirstName("Lexa");
		assertEquals(-1, client1.compareTo(client2));
		client1.setFirstName("Maxym");
		assertEquals(0, client1.compareTo(client2));
	}
}