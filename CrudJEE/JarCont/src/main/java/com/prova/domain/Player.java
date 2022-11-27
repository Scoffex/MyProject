package com.prova.domain;

import java.time.LocalDate;

public class Player {
	int id;
	String nome;
	String cognome;
	String email;
	String username;
	String password;
	LocalDate birth;
	
	
	public Player(String nome, String cognome, String email, String username, String password, LocalDate birth) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.username = username;
		this.password = password;
		this.birth = birth;
	}
	public String getId() {
		return nome;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LocalDate getBirth() {
		return birth;
	}
	public void setBirth(LocalDate birth) {
		this.birth = birth;
	}
	
	
}
