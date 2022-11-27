package com.prova.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.prova.dao.DAOFactoryMethod;
import com.prova.domain.Player;
import com.prova.utils.Conversion;
import com.prova.utils.DatabaseConnection;

public class GetAllServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		Connection conn = null;
		PrintWriter printWriter = null;
		try {
			conn = DatabaseConnection.getInstance().getConnection();
//			Gson gson = new Gson();
//			String userJson = new Gson().toJson(DAOFactoryMethod.getInstance().getPlayerDAO().getAll(conn));
			printWriter = response.getWriter();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			printWriter.print(new Gson().toJson(DAOFactoryMethod.getInstance().getPlayerDAO().getAll(conn)));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			printWriter.close();
			DatabaseConnection.getInstance().close();
		}

	}
}
