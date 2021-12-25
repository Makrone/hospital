package by.hospital.command.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.hospital.command.ICommand;
import by.hospital.domain.User;
import by.hospital.domain.type.Gender;
import by.hospital.domain.type.UserType;
import by.hospital.exception.ServiceException;
import by.hospital.service.UserService;

public class EditUserCommand implements ICommand {

	private static final String FIRST_NAME = "first_name";
	private static final String LAST_NAME = "last_name";
	private static final String GENDER = "gender";
	private static final String PHONE = "phone";
	private static final String EMAIL = "email";
	private static final String TYPE = "user_type";
	private static final String USERNAME = "username";
	private static final String MONEY = "money";
	private static final String ID = "id";
	private static final Logger logger = LogManager.getLogger(EditUserCommand.class);
	private UserService userService;

	public EditUserCommand() {
		super();
		userService = new UserService();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		try {
			User user = new User();
			user.setId(Long.valueOf(request.getParameter(ID)));
			user.setFirstName(request.getParameter(FIRST_NAME));
			user.setLastName(request.getParameter(LAST_NAME));
			user.setGender(
					Gender.valueOf(request.getParameter(GENDER)) != null ? Gender.valueOf(request.getParameter(GENDER))
							: null);
			user.setPhone(request.getParameter(PHONE));
			user.setEmail(request.getParameter(EMAIL));
			user.setType(request.getParameter(TYPE) != null ? UserType.valueOf(request.getParameter(TYPE)) : null);
			user.setUsername(request.getParameter(USERNAME));
			user.setMoney(new BigDecimal(request.getParameter(MONEY)));
			userService.update(user);

			List<User> users = userService.findByType(UserType.CLIENT);
			request.setAttribute("users", users);
			return "/pages/show-clients.jsp";
		} catch (ServiceException e) {
			logger.error("An error occurred during parameter changes", e);
			request.setAttribute("errorMessage", "An error occurred during parameter changes");
			return "/pages/error-500.jsp";
		}
	}
}
