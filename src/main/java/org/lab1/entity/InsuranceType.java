package org.lab1.entity;

import lombok.Getter;
import org.lab1.dao.annotation.Column;
import org.lab1.dao.annotation.Table;

import java.util.Objects;
import java.util.UUID;
@Getter
@Table("insurance_type")
public class InsuranceType {
	@Column("id")
	private UUID id;
	@Column("type")
	public String type;
	@Column("description")
	public String description;
	@Column("month_payment")
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

	public InsuranceType(String type, String description, double monthPayment) {
		this.setId(UUID.randomUUID());
		this.type = type;
		this.description = description;
		this.monthPayment = monthPayment;
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
			return new InsuranceType(this.type, this.description, this.monthPayment);
		}

		public String toString() {
			return "InsuranceType.InsuranceTypeBuilder(id=" + this.id + ", type=" + this.type + ", description=" + this.description + ", monthPayment=" + this.monthPayment + ")";
		}
	}
}
