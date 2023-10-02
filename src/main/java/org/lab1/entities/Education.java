package org.lab1.entities;

import lombok.*;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Education {
	private UUID id;
	private Date startDate;
	private Date finishDate;
	private String universityName;
	private String specialisation;
	private double averageGrades;
	private String diplomaId;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Education education)) return false;
		return getId() == education.getId() && Objects.equals(getDiplomaId(), education.getDiplomaId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getDiplomaId());
	}
}
