package com.prova.dto;


public class PlayerDTO {

	String nome;
	String cognome;
	String email;
	String username;
	String password;
	String birth;
	
	
	public PlayerDTO(String nome, String cognome, String email, String username, String password, String birth) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.username = username;
		this.password = password;
		this.birth = birth;
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
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}

	@Override
	public String toString() {
		return "PlayerDTO [nome=" + nome + ", cognome=" + cognome + ", email=" + email + ", username=" + username
				+ ", password=" + password + ", birth=" + birth + "]";
	}
	
	
	
}
