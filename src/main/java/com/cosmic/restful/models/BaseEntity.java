package com.cosmic.restful.models;

import javax.persistence.*;

@MappedSuperclass
public abstract class BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private String uuid;

	protected BaseEntity() {
	}

	public BaseEntity(String uuid) {
		if(uuid == null) {
			throw new IllegalArgumentException("uuid cannot be null");
		}
		this.uuid = uuid;
	}

	public Long getId() {
		return id;
	}

	public String getUuid() {
		return uuid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + uuid.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof BaseEntity)) {
			return false;
		}
		BaseEntity other = (BaseEntity) obj;
		return uuid.equals(other.getUuid());
	}
}
