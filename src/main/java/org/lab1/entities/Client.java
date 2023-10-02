package org.lab1.entities;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Respresents a Client class, which have classic fields like full name, birthdate, email etc.
 * Also, it has working builder, which make us able to create new objects of this class
 * more comfortable
 */
public class Client implements Comparable<Client>{
	private UUID id;
	private String firstName;
	private String lastName;
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime birthdate;
	private String address;
	private String phoneNumber;
	private String email;

	@Override
	public int compareTo(Client client) {
		if(this.firstName.charAt(0) != client.firstName.charAt(0))return this.firstName.charAt(0) - client.firstName.charAt(0);
		else return this.lastName.charAt(0) - client.lastName.charAt(0);
	}

	public static class Builder{
		private final String firstName;
		private final String lastName;
		private final LocalDateTime birthdate;
		private String address = "Homeless";
		private String phoneNumber = "";
		private String email = "";

		public Builder(String firstName, String lastName, LocalDateTime birthdate){
			if(firstName == null || lastName == null || birthdate == null) throw new IllegalArgumentException("Null arguments");
			else if (ChronoUnit.YEARS.between(birthdate, LocalDateTime.now()) < 18) {
				throw new IllegalArgumentException("Age under 18: " + ChronoUnit.YEARS.between(birthdate, LocalDateTime.now()));
			} else{
				this.firstName = firstName;
				this.lastName = lastName;
				this.birthdate = birthdate;
			}
		}

		public Builder setAddress(String value){
			if(address == null) throw new IllegalArgumentException("Null argument");
			else address = value;
			return this;
		}

		public Builder setPhoneNumber(String value){
			Pattern pattern = Pattern.compile("^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$");
			Matcher matcher = pattern.matcher(value);
			if(!matcher.matches()) throw new IllegalArgumentException("Wrong phone number: " + value);
			else phoneNumber = value;
			return this;
		}

		public Builder setEmail(String value){
			Pattern regexPattern = Pattern.compile("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
					+ "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");
			Matcher matcher = regexPattern.matcher(value);
			if(!matcher.matches()) throw new IllegalArgumentException("Wrong email format :" + value);
			else email = value;
			return this;
		}

		public Client build(){
			return new Client(this);
		}

	}

	public Client(Builder builder){
		id = UUID.randomUUID();
		firstName = builder.firstName;
		lastName = builder.lastName;
		birthdate = builder.birthdate;
		address = builder.address;
		phoneNumber = builder.phoneNumber;
		email = builder.email;
	}

	public  Client(){}

	/**
	 * @return String format of given object
	 */
	@Override
	public String toString() {
		return "Client{" +
				"id=" + getId() +
				", firstName='" + getFirstName() + '\'' +
				", lastName='" + getLastName() + '\'' +
				", birthdate=" + getBirthdate() +
				", address='" + getAddress() + '\'' +
				", phoneNumber='" + getPhoneNumber() + '\'' +
				", email='" + getEmail() + '\'' +
				'}';
	}

	/**
	 * @param o is a given object of current class
	 * @return result of comparison of THIS object and the one which was given as a param
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Client client)) return false;
		return Objects.equals(getId(), client.getId()) && Objects.equals(getFirstName(), client.getFirstName()) && Objects.equals(getLastName(), client.getLastName()) && Objects.equals(getBirthdate(), client.getBirthdate());
	}

	/**
	 * @return hash representation of this object
	 */
	@Override
	public int hashCode() {
		return Objects.hash(getFirstName(), getLastName(), getBirthdate());
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDateTime getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDateTime birthdate) {
		this.birthdate = birthdate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
