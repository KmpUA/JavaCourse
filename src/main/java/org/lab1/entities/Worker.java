package org.lab1.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.lab1.enums.FamilyStatusENUM;
import org.lab1.enums.WorkPositionsENUM;

import java.util.Date;
import java.util.Objects;
@Getter
@Setter
public class Worker extends PersonalParticulars{
	private int id;
	private String firstName;
	private String lastName;
	private Date birthdate;
	private String phoneNumber;
	private FamilyStatusENUM familyStatusENUM;

//	public static class Builder{
//		private final String firstName;
//		private final String lastName;
//		private final Date birthdate;
//		private String phoneNumber = "";
//		private FamilyStatusENUM familyStatusENUM = FamilyStatusENUM.NOT_MARRIED;
//		public Builder(String firstName, String lastName, Date birthdate){
//			this.firstName = firstName;
//			this.lastName = lastName;
//			this.birthdate = birthdate;
//		}
//
//		public Worker.Builder setStatus(FamilyStatusENUM value){
//			familyStatusENUM = value;
//			return this;
//		}
//
//		public Worker.Builder setPhoneNumber(String value){
//			phoneNumber = value;
//			return this;
//		}
//
//		public Worker build(){
//			return new Worker(this);
//		}
//	}
//
//	public Worker(Builder builder) {
//		firstName = builder.firstName;
//		lastName = builder.lastName;
//		birthdate = builder.birthdate;
//		familyStatusENUM = builder.familyStatusENUM;
//		phoneNumber = builder.phoneNumber;
//	}

	@Builder
	public Worker(int id, Date startDate, Date finishDate, String universityName, String specialisation, double averageGrades, String diplomaId, int id1, String email, Date workingSince, WorkPositionsENUM position, double salary, int id2, String firstName, String lastName, Date birthdate, String phoneNumber, FamilyStatusENUM familyStatusENUM) {
		super(id, startDate, finishDate, universityName, specialisation, averageGrades, diplomaId, id1, email, workingSince, position, salary);
		this.id = id2;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthdate = birthdate;
		this.phoneNumber = phoneNumber;
		this.familyStatusENUM = familyStatusENUM;
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
		return getId() == worker.getId() && Objects.equals(getFirstName(), worker.getFirstName()) && Objects.equals(getLastName(), worker.getLastName()) && Objects.equals(getBirthdate(), worker.getBirthdate()) && Objects.equals(getPhoneNumber(), worker.getPhoneNumber()) && getFamilyStatusENUM() == worker.getFamilyStatusENUM();
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), getId(), getFirstName(), getLastName(), getBirthdate(), getPhoneNumber(), getFamilyStatusENUM());
	}
}
