package by.hospital.command.impl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import by.hospital.command.ICommand;
import by.hospital.domain.User;
import by.hospital.exception.ServiceException;
import by.hospital.service.UserService;

public class LoginCommand implements ICommand {

	/**
	 * 
	 */
	private static final String USERNAME = "login";
	private static final String PASSWORD = "password";
	private BCryptPasswordEncoder passwordEncoder;
	private UserService userService;
	private static final Logger logger = LogManager.getLogger(LoginCommand.class);

	public LoginCommand() {
		super();
		passwordEncoder = new BCryptPasswordEncoder();
		userService = new UserService();
	}

	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		try {
			String login = (request.getParameter(USERNAME));
			String password = (request.getParameter(PASSWORD));
			if (login == null) {
				return handleLoginError(request, "Login is empty");
			}
			if (password == null) {
				return handleLoginError(request, "Password is empty");
			}
			User user = userService.findByUsername(login);
			if (user == null) {
				return handleLoginError(request, "User with provided username not found");
			}
			if (!passwordEncoder.matches(password, user.getPassword())) {
				return handleLoginError(request, "Login or password not found");
			}
			HttpSession session = request.getSession(true);
			session.setAttribute("user", user);
			session.setMaxInactiveInterval(300);
			return handleLoginSuccess(request, user);

		} catch (ServiceException e) {
			logger.error("An error occurred during login", e);
			request.setAttribute("errorMessage", "An error occurred during login");
			return "/pages/error-500.jsp";
		}
	}

	private String handleLoginError(HttpServletRequest request, String errorMessage) {
		request.setAttribute("errorMessage", errorMessage);
		return "/pages/login.jsp";
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
