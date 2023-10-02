package org.lab1.repos;

import org.lab1.entities.Client;

import java.util.*;
import java.util.stream.Collectors;

public class ClientRepository{
	private final List<Client> clients;

	public ClientRepository(List<Client> clients) {
		this.clients = clients;
	}

	public ClientRepository() {
		this.clients = new ArrayList<>();
	}

	public List<Client> sortByName(){
		List<Client> result = new ArrayList<>();
		Collections.copy(result, clients);
		result.sort((o1, o2) -> {
			var firstNameCompare = o1.getFirstName().compareTo(o2.getFirstName());
			var lastNameCompare = o1.getLastName().compareTo(o2.getLastName());
			return firstNameCompare == 0 ? lastNameCompare : firstNameCompare;
		});
		return result;
	}

	public List<Client> sortByBirthdate(){
		List<Client> result = new ArrayList<>();
		Collections.copy(result, clients);
		result = result.stream()
				.sorted(Comparator.comparing(Client::getBirthdate)).collect(Collectors.toList());
		return result;
	}
}
