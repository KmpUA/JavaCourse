package org.lab1.entity;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;


@Getter
public class Education {
	private UUID id;
	@NotNull
	private Date startDate;
	@NotNull
	private Date finishDate;
	@NotNull
	private String universityName;
	@NotNull
	private String specialisation;
	@NotNull
	private double averageGrades;
	@NotNull
	private String diplomaId;

	public Education(UUID id, Date startDate, Date finishDate, String universityName, String specialisation, double averageGrades, String diplomaId) {
		this.id = id;
		this.startDate = startDate;
		this.finishDate = finishDate;
		this.universityName = universityName;
		this.specialisation = specialisation;
		this.averageGrades = averageGrades;
		this.diplomaId = diplomaId;
	}

	public Education() {
	}

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

	public void setId(UUID id) {
		this.id = id;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	public void setSpecialisation(String specialisation) {
		this.specialisation = specialisation;
	}

	public void setAverageGrades(double averageGrades) {
		this.averageGrades = averageGrades;
	}

	public void setDiplomaId(String diplomaId) {
		this.diplomaId = diplomaId;
	}

	public String toString() {
		return "Education(id=" + this.getId() + ", startDate=" + this.getStartDate() + ", finishDate=" + this.getFinishDate() + ", universityName=" + this.getUniversityName() + ", specialisation=" + this.getSpecialisation() + ", averageGrades=" + this.getAverageGrades() + ", diplomaId=" + this.getDiplomaId() + ")";
	}
}
