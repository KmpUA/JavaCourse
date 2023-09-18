package org.lab1.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Builder
@Getter
@Setter
public class InsuranceType {
	private int id;
	public String type;
	public String description;
	public double monthPayment;

	@Override
	public String toString() {
		return "InsuranceType{" +
				"id=" + getId() +
				", type='" + type + '\'' +
				", description='" + description + '\'' +
				", monthPayment=" + monthPayment +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof InsuranceType that)) return false;
		return getId() == that.getId() && Double.compare(monthPayment, that.monthPayment) == 0 && Objects.equals(type, that.type) && Objects.equals(description, that.description);
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), type, description, monthPayment);
	}

	public InsuranceType(int id, String type, String description, double monthPayment) {
		this.setId(id);
		this.type = type;
		this.description = description;
		this.monthPayment = monthPayment;
	}
}
