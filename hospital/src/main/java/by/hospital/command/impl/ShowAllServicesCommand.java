package by.hospital.command.impl;

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

public class ShowAllServicesCommand implements ICommand {

	private MedicalServiceService medicalService;
	private static final Logger logger = LogManager.getLogger(ShowAllServicesCommand.class);

	public ShowAllServicesCommand() {
		super();
		medicalService = new MedicalServiceService();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		try {
			List<MedicalService> service = medicalService.getAll();
			request.setAttribute("services", service);
			return "/pages/service.jsp";
		} catch (ServiceException e) {
			logger.error("An error occurred during the display of the service", e);
			request.setAttribute("errorMessage", "An error occurred during the display of the service");
			return "/pages/error-500.jsp";

		}
	}
}
