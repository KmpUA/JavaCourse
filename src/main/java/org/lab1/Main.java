package org.lab1;

import org.lab1.entities.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat smp = new SimpleDateFormat("dd/MM/yyyy");
		Date date = smp.parse("10/04/2004");
		Client client1 = new Client.Builder("Maxym", "Paraniuk", date)
				.setPhoneNumber("+380958194039")
				.setAddress("Holovna str")
				.setEmail("delaamakcima1@gmail.com")
				.build();
		Client client2 = new Client.Builder("Maxym", "Paraniuk", date)
				.setPhoneNumber("+380958194039")
				.setAddress("Holovna str")
				.setEmail("delaamakcima1@gmail.com")
				.build();
		InsuredObject insuredObject = InsuredObject
				.builder()
				.name("Door")
				.build();
		Worker worker = Worker.builder().specialisation("Idiot").build();
		System.out.println(worker.getSpecialisation());
		System.out.println(insuredObject.toString());
		System.out.println(client1.equals(client2));
	}
}
