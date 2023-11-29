package org.lab1.entity;


import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import org.lab1.dao.annotation.Adult;
import org.lab1.dao.annotation.Column;
import org.lab1.dao.annotation.Table;
import org.lab1.enums.FamilyStatusENUM;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
@Getter
@Table("workers")
public class Worker implements Comparable<Worker>{
	@Column("id")
	private UUID id;
	@Size(min = 2, max = 20, message
			= "First name must be between 2 and 20 characters")
	@Column("first_name")
	private String firstName;
	@Size(min = 2, max = 20, message
			= "Last name must be between 4 and 20 characters")
	@Column("last_name")
	private String lastName;
	@Adult
	@Column("birthdate")
	private LocalDateTime birthdate;
	@Pattern(regexp = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$")
	@Column("phone_number")
	private String phoneNumber;
	@Column("family")
	private FamilyStatusENUM familyStatusENUM;

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

	public String getFullName(){
		return this.firstName + " " + this.lastName;
	}

	public static class Builder {

		private final String firstName;

		private final String lastName;
		private final LocalDateTime birthdate;

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
			validate();
			return new Worker(this);
		}
		private void validate() throws IllegalArgumentException{
			ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
			Validator validator = factory.getValidator();

			Worker worker = new Worker(this);
			Set<ConstraintViolation<Worker>> violations = validator.validate(worker);

			StringBuilder mb = new StringBuilder();

			for(ConstraintViolation<Worker> violation: violations){
				mb.append("Error for field ").append(violation.getPropertyPath()).append(": ").append(violation.getInvalidValue()).append(" ").append(violation.getMessage())
;			}

			if(!mb.isEmpty()){
				throw new IllegalArgumentException(mb.toString());
			}
		}
	}

	public Worker(Builder builder) {
		id = UUID.randomUUID();
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
