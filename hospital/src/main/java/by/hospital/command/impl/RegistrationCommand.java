package by.hospital.command.impl;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import by.hospital.command.ICommand;
import by.hospital.domain.User;
import by.hospital.domain.type.Gender;
import by.hospital.domain.type.UserType;
import by.hospital.exception.ServiceException;
import by.hospital.service.UserService;

public class RegistrationCommand implements ICommand {
	private static final String FIRST_NAME = "first_name";
	private static final String LAST_NAME = "last_name";
	private static final String GENDER = "gender";
	private static final String PHONE = "phone";
	private static final String EMAIL = "email";
	private static final String TYPE = "user_type";
	private static final String USERNAME = "login";
	private static final String PASSWORD = "password";

	private BCryptPasswordEncoder passwordEncoder;
	private UserService userService;
	private static final Logger logger = LogManager.getLogger(RegistrationCommand.class);

	public RegistrationCommand() {
		super();
		passwordEncoder = new BCryptPasswordEncoder();
		userService = new UserService();
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		try {
			User user = new User();
			user.setFirstName(request.getParameter(FIRST_NAME));
			user.setLastName(request.getParameter(LAST_NAME));
			user.setGender(Gender.valueOf(request.getParameter(GENDER)));
			user.setPhone(request.getParameter(PHONE));
			user.setEmail(request.getParameter(EMAIL));
			user.setType(UserType.valueOf(request.getParameter(TYPE)));
			user.setUsername(request.getParameter(USERNAME));
			user.setPassword(passwordEncoder.encode(request.getParameter(PASSWORD)));
			userService.create(user);
			return "/pages/login.jsp";
		} catch (ServiceException e) {
			logger.error("There was an error during registration", e);
			request.setAttribute("errorMessage", "There was an error during registration");
			return "/pages/error-500.jsp";
		}
	}

	public void postRequestHandling(HttpServletRequest request, HttpServletResponse response, String page,
			ServletContext servletContext) throws ServletException, IOException {
		response.sendRedirect(request.getContextPath() + page);

	}

}
