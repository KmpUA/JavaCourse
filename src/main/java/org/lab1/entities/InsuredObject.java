package org.lab1.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@Builder
public class InsuredObject {
	private int id;
	private String name;
	private String description;

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
		return Objects.hash(getId(), getName(), getDescription());
	}

	public InsuredObject(int id, String name, String description) {
		this.setId(id);
		this.setName(name);
		this.setDescription(description);
	}
}