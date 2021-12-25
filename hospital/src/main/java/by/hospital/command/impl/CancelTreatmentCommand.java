package by.hospital.command.impl;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.hospital.command.ICommand;
import by.hospital.domain.User;
import by.hospital.dto.TreatmentDTO;
import by.hospital.exception.ServiceException;
import by.hospital.service.TreatmentService;

public class CancelTreatmentCommand implements ICommand {

	private TreatmentService treatmentService;
	private static final Logger logger = LogManager.getLogger(CancelTreatmentCommand.class);

	public CancelTreatmentCommand() {
		super();
		treatmentService = new TreatmentService();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		try {
			String treatmentId = request.getParameter("treatmentId");
			if (treatmentId == null) {
				request.setAttribute("ErrorMessage", "Service id missed");
			} else {
				treatmentService.delete(Long.valueOf(treatmentId));

			}

			User user = (User) (request.getSession().getAttribute("user"));
			List<TreatmentDTO> treatService = treatmentService.findByClientId(user.getId());
			request.setAttribute("treatments", treatService);
			return "/pages/show-client-treatments.jsp";
		} catch (ServiceException e) {
			logger.error("An error occurred during the closing process", e);
			request.setAttribute("errorMessage", "An error occurred during the closing process");
			return "/pages/error-500.jsp";

		}
	}
}