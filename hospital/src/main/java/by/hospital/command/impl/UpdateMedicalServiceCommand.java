package by.hospital.command.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.hospital.command.ICommand;
import by.hospital.domain.MedicalService;
import by.hospital.exception.ServiceException;
import by.hospital.service.MedicalServiceService;

public class UpdateMedicalServiceCommand implements ICommand {

	private static final String NAME = "name";
	private static final String DESCRIPTION = "description";
	private static final String COST = "cost";
	private static final String ID = "id";
	private static final Logger logger = LogManager.getLogger(UpdateMedicalServiceCommand.class);

	public MedicalServiceService medicalService;

	public UpdateMedicalServiceCommand() {
		super();
		medicalService = new MedicalServiceService();
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		try {
			MedicalService medicalSer = new MedicalService();
			medicalSer.setId(Long.valueOf(request.getParameter(ID)));
			medicalSer.setName(request.getParameter(NAME));
			medicalSer.setDescription(request.getParameter(DESCRIPTION));
			medicalSer.setCost(new BigDecimal(request.getParameter(COST)));
			medicalService.update(medicalSer);

			List<MedicalService> service = medicalService.getAll();
			request.setAttribute("services", service);
			request.setAttribute("errorMessage", "Changed");
			return "/pages/service.jsp";
		} catch (ServiceException e) {
			logger.error("There was an error during the update of the medical service", e);
			request.setAttribute("errorMessage", "There was an error during the update of the medical service");
			return "/pages/error-500.jsp";
		}
	}

}
