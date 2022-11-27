package com.esercizio.root;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.esercizio.utils.DatabaseConnectionRoot;
import com.prova.dao.DAOFactoryMethod;
import com.prova.domain.Player;
import com.prova.dto.PlayerDTO;
import com.prova.utils.DatabaseConnection;

public class Main {

	public static void main(String[] args) throws SQLException {
		DAOFactoryMethod crud = DAOFactoryMethod.getInstance();
		// TODO Auto-generated method stub
		Connection conn = DatabaseConnectionRoot.getInstance().getConnection();
		
		//testGetAll
		List<PlayerDTO> listOfAll = crud.getPlayerDAO().getAll(conn);
		for(PlayerDTO player : listOfAll) {
		System.out.println(player.toString());
		}
		
		//testGetById
		PlayerDTO playerOne = crud.getPlayerDAO().getById(conn, 1);
		System.out.println(playerOne.toString());
		
		//testSave
		Player playerSave = new Player("Utente2", "Cognome", "email", "nickname", "password", LocalDate.parse("1999-06-22"));
		crud.getPlayerDAO().save(conn, playerSave);
		
		//testDelete
		crud.getPlayerDAO().delete(conn, 7);
		conn.close();
	}

}
