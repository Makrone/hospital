package by.hospital.command.impl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.hospital.command.ICommand;
import by.hospital.domain.MedicalService;
import by.hospital.exception.ServiceException;
import by.hospital.service.MedicalServiceService;

public class GoToEditServiceCommand implements ICommand {

	private MedicalServiceService medicalService;
	
	private static final Logger logger = LogManager.getLogger(GoToEditServiceCommand.class);

	public GoToEditServiceCommand() {
		super();
		medicalService = new MedicalServiceService();
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		try {
			Long serviceId = Long.valueOf(request.getParameter("serviceId"));
			MedicalService medSer = medicalService.getById(serviceId);
			request.setAttribute("medicalService", medSer);
			return "/pages/edit-medical-service-page.jsp";
		} catch (ServiceException e) {
			logger.error("An error occurred while changing the service", e);
			request.setAttribute("errorMessage", "An error occurred while changing the service");
			return "/pages/error-500.jsp";
		}

	}
}
