package by.hospital.command.impl;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.hospital.command.ICommand;
import by.hospital.domain.User;
import by.hospital.exception.ServiceException;
import by.hospital.service.UserService;

public class GoToPaymentSuccessCommand implements ICommand {
	private UserService userService;

	public GoToPaymentSuccessCommand() {
		super();
		userService = new UserService();

	}

	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		User sessionUser = (User) request.getSession().getAttribute("user");
		try {
			BigDecimal totalCost = new BigDecimal(request.getParameter("total"));
			BigDecimal total = userService.pay(sessionUser.getId(), totalCost);
			sessionUser = userService.getById(sessionUser.getId());

			request.setAttribute("total", total);
			request.getSession().setAttribute("user", sessionUser);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return "/pages/client-view.jsp";
	}
}
