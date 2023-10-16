package org.lab1.entities;


import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.lab1.enums.FamilyStatusENUM;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Worker extends PersonalParticulars implements Comparable<Worker>{
	private UUID id;
	private String firstName;
	private String lastName;
	private LocalDateTime birthdate;
	private String phoneNumber;
	private FamilyStatusENUM familyStatusENUM;

	public UUID getId() {
		return this.id;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public LocalDateTime getBirthdate() {
		return this.birthdate;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public FamilyStatusENUM getFamilyStatusENUM() {
		return this.familyStatusENUM;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setBirthdate(LocalDateTime birthdate) {
		this.birthdate = birthdate;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setFamilyStatusENUM(FamilyStatusENUM familyStatusENUM) {
		this.familyStatusENUM = familyStatusENUM;
	}

	@Override
	public int compareTo(Worker o) {
		if (this.firstName.charAt(0) != o.firstName.charAt(0))
			return this.firstName.charAt(0) - o.firstName.charAt(0);
		else return this.lastName.charAt(0) - o.lastName.charAt(0);
	}

	public static class Builder {
		@Size(min = 4, max = 20, message
				= "About Me must be between 4 and 20 characters")
		private final String firstName;
		@Size(min = 4, max = 20, message
				= "About Me must be between 4 and 20 characters")
		private final String lastName;
		private final LocalDateTime birthdate;
		@Pattern(regexp = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$")
		private String phoneNumber = "";
		private FamilyStatusENUM familyStatusENUM = FamilyStatusENUM.NOT_MARRIED;

		public Builder(String firstName, String lastName, LocalDateTime birthdate) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.birthdate = birthdate;
		}

		public Worker.Builder setStatus(FamilyStatusENUM value) {
			familyStatusENUM = value;
			return this;
		}

		public Worker.Builder setPhoneNumber(String value) {
			phoneNumber = value;
			return this;
		}

		public Worker build() {
			return new Worker(this);
		}
	}

	public Worker(Builder builder) {
		firstName = builder.firstName;
		lastName = builder.lastName;
		birthdate = builder.birthdate;
		familyStatusENUM = builder.familyStatusENUM;
		phoneNumber = builder.phoneNumber;
	}


	@Override
	public String toString() {
		return "Worker{" +
				"id=" + getId() +
				", firstName='" + getFirstName() + '\'' +
				", lastName='" + getLastName() + '\'' +
				", birthdate=" + getBirthdate() +
				", phoneNumber='" + getPhoneNumber() + '\'' +
				", familyStatus=" + getFamilyStatusENUM() +
				", email='" + email + '\'' +
				", workingSince=" + workingSince +
				", position=" + position +
				", salary=" + salary +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Worker worker)) return false;
		if (!super.equals(o)) return false;
		return getId() == worker.getId() && Objects.equals(getFirstName(), worker.getFirstName()) && Objects.equals(getLastName(), worker.getLastName()) && Objects.equals(getBirthdate(), worker.getBirthdate());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getFirstName(), getLastName(), getBirthdate());
	}
}
