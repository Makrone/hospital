package by.hospital.command.impl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.hospital.command.ICommand;
import by.hospital.domain.User;

public class ShowClientOrderCommand implements ICommand {

	private static final String INFO_USER = "user";
	private static final String FIND_DOCTOR = "DOCTOR";

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		String page = null;
		User user = (User) request.getSession().getAttribute(INFO_USER);

		return null;
	}

}
