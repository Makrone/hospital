package by.hospital.command.impl;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.hospital.command.ICommand;
import by.hospital.domain.User;
import by.hospital.domain.type.UserType;
import by.hospital.service.UserService;

public class ShowAllClientsCommand implements ICommand {

	private UserService userService;

	public ShowAllClientsCommand() {
		super();
		userService = new UserService();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		List<User> user = userService.findByType(UserType.CLIENT);
		request.setAttribute("users", user);
		return "/pages/show-clients.jsp";
	}

}
