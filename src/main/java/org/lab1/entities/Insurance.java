package org.lab1.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Builder
@Getter
@Setter
public class Insurance {
	private int id;
	private Client client;
	private List<InsuredObject> objects;
	private List<InsuranceType> types;
	private Worker worker;
	private Date term;
	private double size;

	@Override
	public String toString() {
		return "Insurance{" +
				"id=" + getId() +
				", client=" + getClient() +
				", objects=" + getObjects() +
				", types=" + getTypes() +
				", worker=" + getWorker() +
				", term=" + getTerm() +
				", size=" + getSize() +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Insurance insurance)) return false;
		return getId() == insurance.getId() && Double.compare(getSize(), insurance.getSize()) == 0 && Objects.equals(getClient(), insurance.getClient()) && Objects.equals(getObjects(), insurance.getObjects()) && Objects.equals(getTypes(), insurance.getTypes()) && Objects.equals(getWorker(), insurance.getWorker()) && Objects.equals(getTerm(), insurance.getTerm());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getClient(), getObjects(), getTypes(), getWorker(), getTerm(), getSize());
	}

	public Insurance(int id, Client client, List<InsuredObject> objects, List<InsuranceType> types, Worker worker, Date term, double size) {
		this.setId(id);
		this.setClient(client);
		this.setObjects(objects);
		this.setTypes(types);
		this.setWorker(worker);
		this.setTerm(term);
		this.setSize(size);
	}
}
