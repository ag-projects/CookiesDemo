package com.agharibi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Preview")
public class Preview extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html";

    public Preview() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType(CONTENT_TYPE);
		
		String email = request.getParameter("email");
		Cookie[] cookies = request.getCookies();
		String guestName = cookies[0].getValue();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Preview page</title>");
		out.println("</head>");
		out.println("<body>");
		
		out.println("<h3>Please confirm your information:</h3>");
		out.println("<p>Guest name:" + guestName + "</p>");
		out.println("<p>Email address:" + email + "</p>");
		
		Cookie cookie = new Cookie("email", email);
		response.addCookie(cookie);
		
		out.println("<form name='frm' action='SaveData' method='post'>");
		out.println("<p><input type='submit' value='Save' name='btnSave' /></p>");
		out.println("</form>");
		
		out.println("</body>");
		out.println("</html>");
	}

}
