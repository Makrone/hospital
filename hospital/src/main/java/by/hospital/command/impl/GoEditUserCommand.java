package by.hospital.command.impl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.hospital.command.ICommand;
import by.hospital.domain.User;
import by.hospital.exception.ServiceException;
import by.hospital.service.UserService;

public class GoEditUserCommand implements ICommand {

	private UserService userService;
	private static final Logger logger = LogManager.getLogger(GoEditUserCommand.class);

	public GoEditUserCommand() {
		super();
		userService = new UserService();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		try {
			Long userId = Long.valueOf(request.getParameter("id"));
			User user = userService.getById(userId);
			request.setAttribute("user", user);
			return "/pages/edit-user.jsp";
		} catch (ServiceException e) {
			logger.error("An error occurred during the changeover of the user ", e);
			request.setAttribute("errorMessage", "An error occurred during the changeover of the user ");
			return "/pages/error-500.jsp";
		}
	}
}
