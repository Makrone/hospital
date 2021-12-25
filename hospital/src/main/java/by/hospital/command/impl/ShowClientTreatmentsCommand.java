package by.hospital.command.impl;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.hospital.command.ICommand;
import by.hospital.dto.TreatmentDTO;
import by.hospital.exception.ServiceException;
import by.hospital.service.TreatmentService;

public class ShowClientTreatmentsCommand implements ICommand {

	private TreatmentService treatmentService;
	private static final Logger logger = LogManager.getLogger(ShowClientTreatmentsCommand.class);

	public ShowClientTreatmentsCommand() {
		super();
		treatmentService = new TreatmentService();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		try {
			Long clientId = Long.valueOf(request.getParameter("clientId"));
			List<TreatmentDTO> treatService = treatmentService.findByClientId(clientId);
			request.setAttribute("treatments", treatService);

			return "/pages/show-client-treatments.jsp";
		} catch (ServiceException e) {
			logger.error("An error occurred during the display of the client's treatment", e);
			request.setAttribute("errorMessage", "An error occurred during the display of the client's treatment");
			return "/pages/error-500.jsp";
		}
	}

}
