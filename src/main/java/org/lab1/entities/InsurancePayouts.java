package org.lab1.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Objects;

@Builder
@Getter
@Setter
public class InsurancePayouts {
	private int id;
	private Date payoutDate;
	private double payoutSize;

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
		return Objects.hash(getId(), getPayoutDate(), getPayoutSize());
	}

	public InsurancePayouts(int id, Date payoutDate, double payoutSize) {
		this.setId(id);
		this.setPayoutDate(payoutDate);
		this.setPayoutSize(payoutSize);
	}
}
