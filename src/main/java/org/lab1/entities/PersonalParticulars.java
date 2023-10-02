package org.lab1.entities;

import lombok.*;
import org.lab1.enums.WorkPositionsENUM;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
public class PersonalParticulars extends Education{
	private UUID id;
	public String email;
	public Date workingSince;
	public WorkPositionsENUM position;
	public double salary;

	public PersonalParticulars(UUID id, Date startDate, Date finishDate, String universityName, String specialisation, double averageGrades, String diplomaId, UUID id1, String email, Date workingSince, WorkPositionsENUM position, double salary) {
		super(id, startDate, finishDate, universityName, specialisation, averageGrades, diplomaId);
		this.setId(id1);
		this.email = email;
		this.workingSince = workingSince;
		this.position = position;
		this.salary = salary;
	}

	public PersonalParticulars() {
		super();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof PersonalParticulars that)) return false;
		return getId() == that.getId() && Objects.equals(email, that.email) && position == that.position;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, position);
	}

	@Override
	public String toString() {
		return "PersonalParticulars{" +
				"id=" + getId() +
				", email='" + email + '\'' +
				", workingSince=" + workingSince +
				", position=" + position +
				", salary=" + salary +
				'}';
	}


}
