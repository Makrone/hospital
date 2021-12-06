package by.hospital.command.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import by.hospital.command.ICommand;
import by.hospital.domain.User;
import by.hospital.domain.type.Gender;
import by.hospital.domain.type.UserType;
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
	

	public RegistrationCommand() {
		super();
		passwordEncoder = new BCryptPasswordEncoder();
		userService = new UserService();

	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
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
	}

}