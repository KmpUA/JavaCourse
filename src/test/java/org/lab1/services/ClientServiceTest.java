package org.lab1.services;

import org.lab1.entities.Client;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class ClientServiceTest {
	private List<Client> clientsTest;
	private Client client1, client2;
	private ClientService clientService;

	@BeforeMethod
	public void setUp() {
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

		clientsTest = new ArrayList<>();
		clientsTest.add(client1);
		clientsTest.add(client2);

		clientService = new ClientService(clientsTest);
	}

	@Test
	public void testSortClientsWithStream() {
		List<Client> sortedClients = clientService.sortClientsWithStream();
		assertEquals(sortedClients.get(1), client1);
		assertEquals(sortedClients.get(0), client2);
	}

	@Test
	public void testSortClients() {
		List<Client> sortedClients = clientService.sortClients();
		assertEquals(sortedClients.get(1), client1);
		assertEquals(sortedClients.get(0), client2);
	}

	@Test
	public void testSortClientsByAgeWithStream() {
		List<Client> sortedClients = clientService.sortClientsByAgeWithStream();
		assertEquals(sortedClients.get(0), client1);
		assertEquals(sortedClients.get(1), client2);
	}

	@Test
	public void testSortClientsByAge() {
		List<Client> sortedClients = clientService.sortClientsByAge();
		assertEquals(sortedClients.get(0), client1);
		assertEquals(sortedClients.get(1), client2);
	}
}
