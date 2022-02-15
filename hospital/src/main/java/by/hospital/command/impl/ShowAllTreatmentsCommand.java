package by.hospital.command.impl;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.hospital.command.ICommand;
import by.hospital.domain.Treatment;
import by.hospital.exception.ServiceException;
import by.hospital.service.TreatmentService;

public class ShowAllTreatmentsCommand implements ICommand {

	private TreatmentService treatmentService;
	private static final Logger logger = LogManager.getLogger(ShowAllTreatmentsCommand.class);

	public ShowAllTreatmentsCommand() {
		super();
		treatmentService = new TreatmentService();
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		try {
			List<Treatment> treatService = treatmentService.getAll();
			request.setAttribute("treatments", treatService);
			return "/pages/treatment.jsp";
		} catch (ServiceException e) {
			logger.error("An error occurred during the display of the treatments", e);
			request.setAttribute("errorMessage", "An error occurred during the display of the treatments");
			return "/pages/error-500.jsp";

		}
	}

}
