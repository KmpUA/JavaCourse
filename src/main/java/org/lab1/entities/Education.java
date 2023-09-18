package org.lab1.entities;

import lombok.*;

import java.util.Date;


@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Education {
	private int id;
	private Date startDate;
	private Date finishDate;
	private String universityName;
	private String specialisation;
	private double averageGrades;
	private String diplomaId;
}
