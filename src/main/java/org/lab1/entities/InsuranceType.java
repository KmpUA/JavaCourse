package org.lab1.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
import java.util.UUID;

@Builder
@Getter
@Setter
public class InsuranceType {
	private UUID id;
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
		return getId() == that.getId() && Objects.equals(type, that.type) && Objects.equals(description, that.description);
	}

	@Override
	public int hashCode() {
		return Objects.hash(type, description);
	}

	public InsuranceType(UUID id, String type, String description, double monthPayment) {
		this.setId(id);
		this.type = type;
		this.description = description;
		this.monthPayment = monthPayment;
	}
}
