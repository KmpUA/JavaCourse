package org.lab1.entities;

import java.util.Objects;
import java.util.UUID;

public class InsuredObject {
	private UUID id;
	private String name;
	private String description;

	public static InsuredObjectBuilder builder() {
		return new InsuredObjectBuilder();
	}

	@Override
	public String toString() {
		return "InsuredObject{" +
				"id=" + getId() +
				", name='" + getName() + '\'' +
				", description='" + getDescription() + '\'' +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof InsuredObject that)) return false;
		return getId() == that.getId() && Objects.equals(getName(), that.getName()) && Objects.equals(getDescription(), that.getDescription());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getName(), getDescription());
	}

	public InsuredObject(String name, String description) {
		this.setId(UUID.randomUUID());
		this.setName(name);
		this.setDescription(description);
	}

	public UUID getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static class InsuredObjectBuilder {
		private UUID id;
		private String name;
		private String description;

		InsuredObjectBuilder() {
		}

		public InsuredObjectBuilder id(UUID id) {
			this.id = id;
			return this;
		}

		public InsuredObjectBuilder name(String name) {
			this.name = name;
			return this;
		}

		public InsuredObjectBuilder description(String description) {
			this.description = description;
			return this;
		}

		public InsuredObject build() {
			return new InsuredObject(this.name, this.description);
		}

		public String toString() {
			return "InsuredObject.InsuredObjectBuilder(id=" + this.id + ", name=" + this.name + ", description=" + this.description + ")";
		}
	}
}
