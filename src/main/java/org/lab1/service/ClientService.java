package org.lab1.service;

import org.lab1.entity.Client;

import java.sql.ResultSet;
import java.util.UUID;

public interface ClientService {
	public int addClient(Client client) throws Exception;
	public ResultSet findAll() throws Exception;
	public int deleteClient(UUID id) throws Exception;
	public int updateClient(Client client, UUID id) throws Exception;
	public ResultSet findById(UUID id) throws Exception;
}
