package com.prova.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.prova.dao.DAOFactoryMethod;
import com.prova.utils.Conversion;
import com.prova.utils.DatabaseConnection;

public class DeleteServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Connection conn = null;
	
		try {
			conn = DatabaseConnection.getInstance().getConnection();
			DAOFactoryMethod.getInstance().getPlayerDAO().delete(conn, Integer.parseInt(request.getParameter("id")));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseConnection.getInstance().close();
		}
	}
		
	
	
}
