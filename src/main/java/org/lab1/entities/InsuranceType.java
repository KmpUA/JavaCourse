package org.lab1.entities;

import java.util.Objects;
import java.util.UUID;

public class InsuranceType {
	private UUID id;
	public String type;
	public String description;
	public double monthPayment;

	public static InsuranceTypeBuilder builder() {
		return new InsuranceTypeBuilder();
	}

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

	public UUID getId() {
		return this.id;
	}

	public String getType() {
		return this.type;
	}

	public String getDescription() {
		return this.description;
	}

	public double getMonthPayment() {
		return this.monthPayment;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setMonthPayment(double monthPayment) {
		this.monthPayment = monthPayment;
	}

	public static class InsuranceTypeBuilder {
		private UUID id;
		private String type;
		private String description;
		private double monthPayment;

		InsuranceTypeBuilder() {
		}

		public InsuranceTypeBuilder id(UUID id) {
			this.id = id;
			return this;
		}

		public InsuranceTypeBuilder type(String type) {
			this.type = type;
			return this;
		}

		public InsuranceTypeBuilder description(String description) {
			this.description = description;
			return this;
		}

		public InsuranceTypeBuilder monthPayment(double monthPayment) {
			this.monthPayment = monthPayment;
			return this;
		}

		public InsuranceType build() {
			return new InsuranceType(this.id, this.type, this.description, this.monthPayment);
		}

		public String toString() {
			return "InsuranceType.InsuranceTypeBuilder(id=" + this.id + ", type=" + this.type + ", description=" + this.description + ", monthPayment=" + this.monthPayment + ")";
		}
	}
}
