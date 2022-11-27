package com.prova.servlets;


import java.io.IOException;

import java.sql.Connection;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.prova.dao.DAOFactoryMethod;
import com.prova.domain.Player;
import com.prova.utils.Conversion;
import com.prova.utils.DatabaseConnection;

public class SaveServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		try {
			conn = DatabaseConnection.getInstance().getConnection();
			Player player = Conversion.playerConversion(request);
			DAOFactoryMethod.getInstance().getPlayerDAO().save(conn, player);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			DatabaseConnection.getInstance().close();

		}

	}

}
