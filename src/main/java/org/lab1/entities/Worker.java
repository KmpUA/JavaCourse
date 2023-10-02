package org.lab1.entities;


import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.lab1.enums.FamilyStatusENUM;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
public class Worker extends PersonalParticulars implements Comparator<Worker> {
	private UUID id;
	private String firstName;
	private String lastName;
	private LocalDateTime birthdate;
	private String phoneNumber;
	private FamilyStatusENUM familyStatusENUM;

	public static class Builder{
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
		public Builder(String firstName, String lastName, LocalDateTime birthdate){
			this.firstName = firstName;
			this.lastName = lastName;
			this.birthdate = birthdate;
		}

		public Worker.Builder setStatus(FamilyStatusENUM value){
			familyStatusENUM = value;
			return this;
		}

		public Worker.Builder setPhoneNumber(String value){
			phoneNumber = value;
			return this;
		}

		public Worker build(){
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
	public int compare(Worker o1, Worker o2) {
		return o1.firstName.compareTo(o2.firstName);
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
