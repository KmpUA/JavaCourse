package org.lab1.entities;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Insurance {
	private UUID id;
	private Client client;
	private List<InsuredObject> objects;
	private List<InsuranceType> types;
	private Worker worker;
	private Date term;
	private double size;

	public static InsuranceBuilder builder() {
		return new InsuranceBuilder();
	}

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
		return getId() == insurance.getId() && Objects.equals(getClient(), insurance.getClient()) && Objects.equals(getWorker(), insurance.getWorker());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getClient(), getWorker());
	}

	public Insurance(UUID id, Client client, List<InsuredObject> objects, List<InsuranceType> types, Worker worker, Date term, double size) {
		this.setId(id);
		this.setClient(client);
		this.setObjects(objects);
		this.setTypes(types);
		this.setWorker(worker);
		this.setTerm(term);
		this.setSize(size);
	}

	public UUID getId() {
		return this.id;
	}

	public Client getClient() {
		return this.client;
	}

	public List<InsuredObject> getObjects() {
		return this.objects;
	}

	public List<InsuranceType> getTypes() {
		return this.types;
	}

	public Worker getWorker() {
		return this.worker;
	}

	public Date getTerm() {
		return this.term;
	}

	public double getSize() {
		return this.size;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void setObjects(List<InsuredObject> objects) {
		this.objects = objects;
	}

	public void setTypes(List<InsuranceType> types) {
		this.types = types;
	}

	public void setWorker(Worker worker) {
		this.worker = worker;
	}

	public void setTerm(Date term) {
		this.term = term;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public static class InsuranceBuilder {
		private UUID id;
		private Client client;
		private List<InsuredObject> objects;
		private List<InsuranceType> types;
		private Worker worker;
		private Date term;
		private double size;

		InsuranceBuilder() {
		}

		public InsuranceBuilder id(UUID id) {
			this.id = id;
			return this;
		}

		public InsuranceBuilder client(Client client) {
			this.client = client;
			return this;
		}

		public InsuranceBuilder objects(List<InsuredObject> objects) {
			this.objects = objects;
			return this;
		}

		public InsuranceBuilder types(List<InsuranceType> types) {
			this.types = types;
			return this;
		}

		public InsuranceBuilder worker(Worker worker) {
			this.worker = worker;
			return this;
		}

		public InsuranceBuilder term(Date term) {
			this.term = term;
			return this;
		}

		public InsuranceBuilder size(double size) {
			this.size = size;
			return this;
		}

		public Insurance build() {
			return new Insurance(this.id, this.client, this.objects, this.types, this.worker, this.term, this.size);
		}

		public String toString() {
			return "Insurance.InsuranceBuilder(id=" + this.id + ", client=" + this.client + ", objects=" + this.objects + ", types=" + this.types + ", worker=" + this.worker + ", term=" + this.term + ", size=" + this.size + ")";
		}
	}
}
