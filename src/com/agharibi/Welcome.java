package com.agharibi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Welcome")
public class Welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html";

    public Welcome() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String guestName = request.getParameter("guestName");
		Cookie cookie = new Cookie("guestName", guestName);
		// cookie.setMaxAge(1800);
		response.addCookie(cookie);
		
		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Welcome page</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h3>Welcome " + guestName +  "</h3>");
		
		out.println("<form name='frm' action='Preview' method='Post'>");
		out.println("<p>Enter email address: </p>");		
		out.println("<p><input type='email' name='email'></p>");
		out.println("<p><input type='submit' value='Preview' name='btnPreview' /></p>");
		out.println("</form>");
		
		
		
		out.println("</body>");
		out.println("</html>");

	}

}
