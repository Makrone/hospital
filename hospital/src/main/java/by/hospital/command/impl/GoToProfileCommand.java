package by.hospital.command.impl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.hospital.command.ICommand;
import by.hospital.domain.User;

public class GoToProfileCommand implements ICommand {

	public GoToProfileCommand() {
		super();
	}

	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			return handleLoginError(request, "Error");
		}

		return handleLoginSuccess(request, user);
	}

	private String handleLoginError(HttpServletRequest request, String errorMessage) {
		request.setAttribute("errorMessage", errorMessage);
		return "/pages/error-500.jsp";
	}

	private String handleLoginSuccess(HttpServletRequest request, User user) {
		if (user.getType() != null) {
			switch (user.getType()) {
			case CLIENT:
				return "/pages/client-view.jsp";
			case DOCTOR:
				return "/pages/doctor-view.jsp";
			case ADMIN:
				return "/pages/admin-view.jsp";
			}
		}
		return handleLoginError(request, "User don't have any roles");
	}
}