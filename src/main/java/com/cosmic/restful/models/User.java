package com.cosmic.restful.models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User extends BaseEntity {

	private String email;
	private String password;
	
	public User(){
	}
	
	public User(String uuid) {
		super(uuid);
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
