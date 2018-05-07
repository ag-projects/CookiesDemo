package com.agharibi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SaveData")
public class SaveData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html";

    public SaveData() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {


	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			Cookie[] cookies = request.getCookies();
			String guestName = cookies[0].getValue();
			String email = cookies[1].getValue();
			
			response.setContentType(CONTENT_TYPE);
			PrintWriter out = response.getWriter();
			
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Welcome page</title>");
			out.println("</head>");
			out.println("<body>");
			
			out.println("<h3>Guset details:</h3>");
			out.println("<p>Guest name is: " + guestName + "</p>");
			out.println("<p>Email address is: " + email + "</p>");
			
			out.println("</body>");
			out.println("</html>");
		
	}

}
