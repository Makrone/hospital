package by.hospital.command.impl;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.hospital.command.ICommand;
import by.hospital.domain.User;
import by.hospital.domain.type.UserType;
import by.hospital.exception.ServiceException;
import by.hospital.service.UserService;

public class ShowAllClientsCommand implements ICommand {

	private UserService userService;
	private static final Logger logger = LogManager.getLogger(ShowAllClientsCommand.class);

	public ShowAllClientsCommand() {
		super();
		userService = new UserService();
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		try {
			List<User> user = userService.findByType(UserType.CLIENT);
			request.setAttribute("users", user);
			return "/pages/show-clients.jsp";
		} catch (ServiceException e) {
			logger.error("An error occurred during the display of all clients", e);
			request.setAttribute("errorMessage", "An error occurred during the display of all clients");
			return "/pages/error-500.jsp";
		}
	}

}
