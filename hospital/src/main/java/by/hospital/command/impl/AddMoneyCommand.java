package by.hospital.command.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import by.hospital.command.ICommand;
import by.hospital.domain.User;
import by.hospital.domain.type.Gender;
import by.hospital.domain.type.UserType;
import by.hospital.service.UserService;

public class AddMoneyCommand implements ICommand {
	private static final String MONEY = "money";

	private UserService userService;
	

	public AddMoneyCommand() {
		super();
		userService = new UserService();

	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		return "/pages/registration.jsp";
	}

}
