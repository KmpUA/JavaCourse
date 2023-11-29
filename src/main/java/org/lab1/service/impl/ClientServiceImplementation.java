package org.lab1.service.impl;

import org.lab1.dao.SecurePSQLConnection;
import org.lab1.entity.Client;
import org.lab1.service.ClientService;

import java.sql.ResultSet;
import java.util.UUID;

public class ClientServiceImplementation implements ClientService {
	private final SecurePSQLConnection psql;

	public ClientServiceImplementation() throws Exception {
		this.psql = new SecurePSQLConnection();

		var statement = psql.getStatement();
		statement.execute(
				"CREATE TABLE IF NOT EXISTS clients(id VARCHAR(50), first_name VARCHAR(50), last_name VARCHAR(50), birthdate DATE, address VARCHAR(50), phonenumber VARCHAR(50), email VARCHAR(50));");
	}
	@Override
	public int addClient(Client client) throws Exception {
		if(!psql.selectById(client.getId(), Client.class).next()) return psql.insert(client);
		else throw new Exception("Client already exists");
	}

	@Override
	public ResultSet findAll() throws Exception {
		return psql.selectAll(Client.class);
	}

	@Override
	public int deleteClient(UUID id) throws Exception {
		if(!psql.selectById(id, Client.class).wasNull()){
			return psql.delete(id, Client.class);
		}
		else{
			return -1;
		}
	}

	@Override
	public int updateClient(Client client, UUID id) throws Exception {
		return psql.update(client, id);
	}

	@Override
	public ResultSet findById(UUID id) throws Exception {
		return psql.selectById(id, Client.class);
	}
}

