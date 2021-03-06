package by.hospital.command.impl;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.hospital.command.ICommand;

public class LogoutCommand implements ICommand {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		HttpSession session = request.getSession();
		Cookie cookie = new Cookie("JSESSIONID", "");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		session.removeAttribute("user");
		session.invalidate();
		return "/index.jsp";
	}

	public void postRequestHandling(HttpServletRequest request, HttpServletResponse response, String page,
			ServletContext servletContext) throws ServletException, IOException {
		response.sendRedirect(request.getContextPath() + page);

	}

}
