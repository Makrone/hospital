package by.hospital.command.impl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.hospital.command.ICommand;
import by.hospital.domain.User;

public class GoToPageCommand implements ICommand {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		String page = request.getParameter("page");
		if (page != null) {
			return page;
		}
		User user = (User) request.getSession().getAttribute("user");
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
		return "/index.jsp";
	}

}
