package by.hospital.command.impl;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.hospital.command.ICommand;
import by.hospital.domain.User;
import by.hospital.exception.ServiceException;
import by.hospital.service.UserService;

public class GoToMakeAppointment implements ICommand {

	private UserService userService;
	private static final Logger logger = LogManager.getLogger(GoToMakeAppointment.class);

	public GoToMakeAppointment() {
		super();
		userService = new UserService();
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		try {
			Long doctorId = Long.valueOf(request.getParameter("doctorId"));
			User doctor = userService.getById(doctorId);

			request.setAttribute("doctor", doctor);
			return "/pages/create-treatment.jsp";
		} catch (ServiceException e) {
			logger.error("There was an error during the appointment", e);
			request.setAttribute("errorMessage", "There was an error during the appointment");
			return "/pages/error-500.jsp";
		}
	}

}
