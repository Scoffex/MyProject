package com.prova.utils;

public class Query {

	public static final String GET_BY_ID = "SELECT name, surname, email, nickname, password, birth FROM Player where id = ?";
	public static final String GET_ALL = "SELECT * FROM Player";
	public static final String SAVE = "INSERT INTO Player (name, surname, email, nickname, password, birth) VALUES  (?, ?, ?, ?, ?, ?)";
	public static final String DELETE = "DELETE FROM Player WHERE id = ?";

}
