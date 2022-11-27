package com.prova.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;

import com.prova.domain.Player;

public class Conversion {

	public static Player playerConversion(HttpServletRequest request) throws IOException {
		JSONObject jObj = null;
		LocalDate localDate = null;
		BufferedReader br = null;
		try {
			StringBuilder sb = new StringBuilder();
			br = request.getReader();
			
			String str = null;
			while ((str = br.readLine()) != null) {
				sb.append(str);
			}
			jObj = new JSONObject(sb.toString());
			localDate = LocalDate.parse(jObj.getString("birth"));

		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			br.close();
		}
		return new Player(jObj.getString("name"), jObj.getString("surname"), jObj.getString("email"),
				jObj.getString("username"), jObj.getString("password"), localDate);

	}
	
	
}
