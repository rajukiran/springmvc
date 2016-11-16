package com.acknotech.core.dto.users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users {
	private int id;
	private String username;
	private String password;
	
	
	@GeneratedValue
    @Column(name = "username")
	public String getUsername() {
		return username;
	}
	
	@Column(name = "username")
	public void setUsername(String username) {
		this.username = username;
	}
	
	@GeneratedValue
    @Column(name = "password")
	public String getPassword() {
		return password;
	}
	
	@Column(name = "password")
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Id
    @GeneratedValue
    @Column(name = "id")
	public int getId() {
		return id;
	}
}
