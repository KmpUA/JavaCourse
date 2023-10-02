package org.lab1.services;

import lombok.Getter;
import lombok.Setter;
import org.lab1.entities.Client;

import java.util.*;
import java.util.stream.Collectors;

@Getter
@Setter
public class ClientService {
	private List<Client> clients;

	public ClientService(List<Client> clients) {
		this.clients = clients;
	}

	public List<Client> sortClientsWithStream(){
		return clients.stream()
				.sorted()
				.collect(Collectors.toList());
	}

	public List<Client> sortClients(){
		List<Client> result = new ArrayList<>(List.copyOf(clients));
		Collections.sort(result);
		return result;
	}

	public List<Client> sortClientsByAgeWithStream(){
		return clients.stream()
				.sorted((c1, c2) -> c2.getBirthdate().compareTo(c1.getBirthdate()))
				.collect(Collectors.toList());
	}

	public List<Client> sortClientsByAge(){
		List<Client> result = new ArrayList<>(List.copyOf(clients));
		result.sort(new Comparator<Client>() {
			@Override
			public int compare(Client o1, Client o2) {
				return o2.getBirthdate().compareTo(o1.getBirthdate());
			}
		});
		return result;
	}


}
