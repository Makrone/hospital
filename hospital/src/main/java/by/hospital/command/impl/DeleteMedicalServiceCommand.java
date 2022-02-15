package by.hospital.command.impl;

import java.io.IOException;
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

public class DeleteMedicalServiceCommand implements ICommand {

	private MedicalServiceService medicalService;
	private static final Logger logger = LogManager.getLogger(DeleteMedicalServiceCommand.class);

	public DeleteMedicalServiceCommand() {
		super();
		medicalService = new MedicalServiceService();
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		try {
			String serviceId = request.getParameter("serviceId");
			if (serviceId == null) {
				request.setAttribute("ErrorMessage", "Service id missed");
			} else {
				medicalService.delete(Long.valueOf(serviceId));

			}
			List<MedicalService> service = medicalService.getAll();
			request.setAttribute("services", service);
			request.setAttribute("errorMessage", "Deleted");
			return "/pages/service.jsp";
		} catch (ServiceException e) {
			logger.error("An error occurred while uninstalling a medical service ", e);
			request.setAttribute("errorMessage", "An error occurred while uninstalling a medical service ");
			return "/pages/error-500.jsp";
		}

	}
}
