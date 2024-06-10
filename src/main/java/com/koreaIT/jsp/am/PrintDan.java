package com.koreaIT.jsp.am;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/printDan")
public class PrintDan extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html; charset=UTF-8");
		
		String Stdan = request.getParameter("dan");
		String Stlimit = request.getParameter("limit");
		String Stcolor = request.getParameter("color");
		
		if(Stdan == null) {
			Stdan = "1";
		}
		
		if(Stlimit == null) {
			Stlimit = "1";
		}
		
		if(Stcolor == null) {
			Stcolor = "black";
		}
		
		int dan = Integer.parseInt(Stdan);
		int limit = Integer.parseInt(Stlimit);
		
		response.getWriter().append(String.format("<div style='color: %s;'>== %d단 ==<br /></div>", Stcolor, dan));
		
		for(int i = 1; i <= limit; i++) {
			
			response.getWriter().append(String.format("<div style=\"color:%s;\">%d * %d = %d</div> <br />", Stcolor, dan, i, dan * i));
		}
		
	}


}
