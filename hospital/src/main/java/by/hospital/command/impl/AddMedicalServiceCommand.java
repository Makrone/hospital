package by.hospital.command.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.hospital.command.ICommand;
import by.hospital.domain.MedicalService;
import by.hospital.exception.ServiceException;
import by.hospital.service.MedicalServiceService;

public class AddMedicalServiceCommand implements ICommand {

	private static final String COST = "cost";
	private static final String DESCRIPTION = "description";
	private static final String NAME = "name";

	private MedicalServiceService medicalService;
	private static final Logger logger = LogManager.getLogger(AddMedicalServiceCommand.class);

	public AddMedicalServiceCommand() {
		super();
		medicalService = new MedicalServiceService();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		try {
			if (request.getParameter(NAME) == null || request.getParameter(DESCRIPTION) == null
					|| request.getParameter(COST) == null) {
				request.setAttribute("ErrorMessage", "fields cannot be empty");
			} else {
				MedicalService medSer = new MedicalService();
				medSer.setCost(new BigDecimal(request.getParameter(COST)));
				medSer.setDescription(request.getParameter(DESCRIPTION));
				medSer.setName(request.getParameter(NAME));
				medicalService.create(medSer);
			}

			List<MedicalService> service = medicalService.getAll();
			request.setAttribute("services", service);
			return "/pages/service.jsp";

		} catch (ServiceException e) {
			logger.error("An error occurred while adding a service ", e);
			request.setAttribute("errorMessage", "An error occurred while adding a service ");
			return "/pages/error-500.jsp";

		}
	}
}
