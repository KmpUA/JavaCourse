package org.lab1.entities;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class InsurancePayouts {
	private UUID id;
	private Date payoutDate;
	private double payoutSize;

	public static InsurancePayoutsBuilder builder() {
		return new InsurancePayoutsBuilder();
	}

	@Override
	public String toString() {
		return "InsurancePayouts{" +
				"id=" + getId() +
				", payoutDate=" + getPayoutDate() +
				", payoutSize=" + getPayoutSize() +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof InsurancePayouts that)) return false;
		return getId() == that.getId() && Double.compare(getPayoutSize(), that.getPayoutSize()) == 0 && Objects.equals(getPayoutDate(), that.getPayoutDate());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getPayoutDate(), getPayoutSize());
	}

	public InsurancePayouts(UUID id, Date payoutDate, double payoutSize) {
		this.setId(id);
		this.setPayoutDate(payoutDate);
		this.setPayoutSize(payoutSize);
	}

	public UUID getId() {
		return this.id;
	}

	public Date getPayoutDate() {
		return this.payoutDate;
	}

	public double getPayoutSize() {
		return this.payoutSize;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public void setPayoutDate(Date payoutDate) {
		this.payoutDate = payoutDate;
	}

	public void setPayoutSize(double payoutSize) {
		this.payoutSize = payoutSize;
	}

	public static class InsurancePayoutsBuilder {
		private UUID id;
		private Date payoutDate;
		private double payoutSize;

		InsurancePayoutsBuilder() {
		}

		public InsurancePayoutsBuilder id(UUID id) {
			this.id = id;
			return this;
		}

		public InsurancePayoutsBuilder payoutDate(Date payoutDate) {
			this.payoutDate = payoutDate;
			return this;
		}

		public InsurancePayoutsBuilder payoutSize(double payoutSize) {
			this.payoutSize = payoutSize;
			return this;
		}

		public InsurancePayouts build() {
			return new InsurancePayouts(this.id, this.payoutDate, this.payoutSize);
		}

		public String toString() {
			return "InsurancePayouts.InsurancePayoutsBuilder(id=" + this.id + ", payoutDate=" + this.payoutDate + ", payoutSize=" + this.payoutSize + ")";
		}
	}
}
