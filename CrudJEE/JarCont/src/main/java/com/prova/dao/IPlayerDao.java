package com.prova.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.prova.domain.Player;
import com.prova.dto.PlayerDTO;

public interface IPlayerDao {

	public void save(Connection conn, Player player) throws SQLException ;
	public void creatingPlayer(Connection conn) throws SQLException ;
	public PlayerDTO getById(Connection conn, int id) throws SQLException;
	public List<PlayerDTO> getAll(Connection conn) throws SQLException;
	public void delete(Connection conn, int id) throws SQLException;
}
