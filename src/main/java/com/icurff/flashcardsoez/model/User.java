package com.icurff.flashcardsoez.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String username;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private String avtPath;
	@Column
	private String email;
	@Column
	private String password;

	@Column(name = "created_at")
	private LocalDateTime createdAt;

	public User() {
		this.avtPath = "/images/defaultAvt.png";
		this.createdAt  = LocalDateTime.now();
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAvtPath() {
		return avtPath;
	}

	public void setAvtPath(String avtPath) {
		this.avtPath = avtPath;
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

	public LocalDateTime getCreated_at() {
		return createdAt;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.createdAt = created_at;
	}

}
