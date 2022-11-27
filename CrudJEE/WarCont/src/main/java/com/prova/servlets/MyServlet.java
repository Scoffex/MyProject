package com.prova.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prova.dao.DAOFactoryMethod;
import com.prova.dao.IPlayerDao;
import com.prova.daoimpl.PlayerDao;
import com.prova.utils.DatabaseConnection;

public class MyServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		try {
			
			conn = DatabaseConnection.getInstance().getConnection();
			IPlayerDao pd = DAOFactoryMethod.getInstance().getPlayerDAO();
			pd.creatingPlayer(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
