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

public class ShowAllClientDoctorsCommand implements ICommand {

	private UserService userService;
	private static final Logger logger = LogManager.getLogger(ShowAllClientDoctorsCommand.class);

	public ShowAllClientDoctorsCommand() {
		super();
		userService = new UserService();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		try {
			List<User> user = userService.findByType(UserType.DOCTOR);
			request.setAttribute("users", user);
			return "/pages/show-client-doctors.jsp";
		} catch (ServiceException e) {
			logger.error("An error occurred during the display of all doctors", e);
			request.setAttribute("errorMessage", "An error occurred during the display of all doctors");
			return "/pages/error-500.jsp";
		}
	}
}
