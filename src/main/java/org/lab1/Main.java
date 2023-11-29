package org.lab1;

import org.lab1.dao.SecurePSQLConnection;
import org.lab1.entity.*;
import org.lab1.enums.FamilyStatusENUM;
import org.lab1.serializer.JsonSerializer;
import org.lab1.serializer.TxtSerializer;
import org.lab1.serializer.XmlSerializer;
import org.lab1.service.ClientService;
import org.lab1.service.impl.ClientServiceImplementation;
import org.lab1.servlet.ClientServlet;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.UUID;

public class Main {
	public static void main(String[] args) throws Exception {
		LocalDateTime localDateTime = LocalDateTime.of(2005, 7, 10, 0, 0, 0);
		LocalDateTime localDateTime2 = LocalDateTime.of(1991, 12, 30, 0, 0, 0);
		Client client1 = new Client.Builder("Denzel", "Washington", localDateTime2)
				.setPhoneNumber("+380958194039")
				.setEmail("delamakcima1@gmail.com")
				.build();


		Client client2 = new Client.Builder("Maxym", "Maraniuk", localDateTime)
				.setPhoneNumber("+380958194039")
				.setEmail("delamakcima1@gmail.com")
				.build();

		Worker worker = new Worker.Builder("Maxym", "Paraniuk", LocalDateTime.now().minusDays(36500))
				.setStatus(FamilyStatusENUM.MARRIED)
				.setPhoneNumber("+380958194039")
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
		ClientService clientService = new ClientServiceImplementation();
	}
	static void printResultSet(ResultSet resultSet) throws SQLException {
		var result = resultSet.getMetaData();
		int columnsNumber = result.getColumnCount();
		for (int i = 1; i <= columnsNumber; i++) {
			if (i > 1)
				System.out.print(" | ");
			System.out.print(result.getColumnName(i) + " ");
		}
		System.out.println();
		while (resultSet.next()) {
			for(int i = 1; i < columnsNumber; i++){
				String columnValue = resultSet.getString(i);
				if (i > 1)
					System.out.print(" | ");
				System.out.print(columnValue + " ");
			}
			System.out.println();
		}

	}
}
