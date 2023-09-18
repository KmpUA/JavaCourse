package org.lab1.entities;

import java.util.Date;
import java.util.Objects;

/**
 * Respresents a Client class, which have classic fields like full name, birthdate, email etc.
 * Also, it has working builder, which make us able to create new objects of this class
 * more comfortable
 */
public class Client {
	private int id;
	private String firstName;
	private String lastName;
	private Date birthdate;
	private String address;
	private String phoneNumber;
	private String email;

	public static class Builder{
		private final String firstName;
		private final String lastName;
		private final Date birthdate;
		private String address = "Homeless";
		private String phoneNumber = "";
		private String email = "";

		public Builder(String firstName, String lastName, Date birthdate){
			this.firstName = firstName;
			this.lastName = lastName;
			this.birthdate = birthdate;
		}

		public Builder setAddress(String value){
			address = value;
			return this;
		}

		public Builder setPhoneNumber(String value){
			phoneNumber = value;
			return this;
		}

		public Builder setEmail(String value){
			email = value;
			return this;
		}

		public Client build(){
			return new Client(this);
		}

	}

	public Client(Builder builder){
		firstName = builder.firstName;
		lastName = builder.lastName;
		birthdate = builder.birthdate;
		address = builder.address;
		phoneNumber = builder.phoneNumber;
		email = builder.email;
	}

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
		return getId() == client.getId() && Objects.equals(getFirstName(), client.getFirstName()) && Objects.equals(getLastName(), client.getLastName()) && Objects.equals(getBirthdate(), client.getBirthdate()) && Objects.equals(getAddress(), client.getAddress()) && Objects.equals(getPhoneNumber(), client.getPhoneNumber()) && Objects.equals(getEmail(), client.getEmail());
	}

	/**
	 * @return hash representation of this object
	 */
	@Override
	public int hashCode() {
		return Objects.hash(getId(), getFirstName(), getLastName(), getBirthdate(), getAddress(), getPhoneNumber(), getEmail());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
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
