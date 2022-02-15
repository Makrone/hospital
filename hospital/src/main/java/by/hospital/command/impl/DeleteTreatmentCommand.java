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
import by.hospital.domain.Treatment;
import by.hospital.exception.ServiceException;
import by.hospital.service.TreatmentService;

public class DeleteTreatmentCommand implements ICommand {
	private TreatmentService treatmentService;
	private static final Logger logger = LogManager.getLogger(DeleteTreatmentCommand.class);

	public DeleteTreatmentCommand() {
		super();
		treatmentService = new TreatmentService();
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		try {
			String treatmentId = request.getParameter("treatmentId");
			if (treatmentId == null) {
				request.setAttribute("ErrorMessage", "Treatment id missed");
			} else {
				treatmentService.delete(Long.valueOf(treatmentId));

			}
			List<Treatment> treatment = treatmentService.getAll();
			request.setAttribute("treatments", treatment);
			return "/pages/medicaments.jsp";
		} catch (ServiceException e) {
			logger.error("An error occurred while uninstalling a treatment service ", e);
			request.setAttribute("errorMessage", "An error occurred while uninstalling a treatment service ");
			return "/pages/error-500.jsp";
		}

	}

}
