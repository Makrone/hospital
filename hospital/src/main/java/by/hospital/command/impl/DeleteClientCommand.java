package by.hospital.command.impl;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.hospital.command.ICommand;
import by.hospital.domain.User;
import by.hospital.exception.ServiceException;
import by.hospital.service.UserService;

public class DeleteClientCommand implements ICommand {

	private UserService userService;
	private static final Logger logger = LogManager.getLogger(DeleteClientCommand.class);

	public DeleteClientCommand() {
		super();
		userService = new UserService();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		try {
			String serviceId = request.getParameter("id");
			if (serviceId == null) {
				request.setAttribute("ErrorMessage", "User id missed");
			} else {
				userService.delete(Long.valueOf(serviceId));
				request.setAttribute("errorMessage", "Deleted");
			}
			List<User> user = userService.getAll();
			request.setAttribute("users", user);
			return "/pages/show-clients.jsp";
		} catch (ServiceException e) {
			logger.error("An error occurred during client deletion ", e);
			request.setAttribute("errorMessage", "An error occurred during client deletion ");
			return "/pages/error-500.jsp";
		}
	}

}
