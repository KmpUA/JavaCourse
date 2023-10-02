package org.lab1.serializers;

import org.lab1.entities.Client;

import java.io.*;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TxtSerializer {

	public void serialize(Client entity, String filePath) {
		try (FileOutputStream fos = new FileOutputStream(filePath);
		     ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeUTF(entity.toString());
			oos.flush();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public Client deserialize(String filePath) {
		try (FileInputStream fis = new FileInputStream(filePath);
		     ObjectInputStream ois = new ObjectInputStream(fis)) {
			String personString = ois.readUTF();
			return parseStringToObject(personString);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static Client parseStringToObject(String string) {
		Client client = new Client();
		String regex = "Client\\{id=(.+), firstName='(.+)', lastName='(.+)', birthdate=(.+), address='(.+)', phoneNumber='(.+)', email='(.+)'\\}";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(string);
		if (matcher.matches()) {
			client.setId(UUID.fromString(matcher.group(1)));
			client.setFirstName(matcher.group(2));
			client.setLastName(matcher.group(3));
			client.setBirthdate(LocalDateTime.parse(matcher.group(4)));
			client.setAddress(matcher.group(5));
			client.setPhoneNumber(matcher.group(6));
			client.setEmail(matcher.group(7));
		}
		return client;
	}
}
