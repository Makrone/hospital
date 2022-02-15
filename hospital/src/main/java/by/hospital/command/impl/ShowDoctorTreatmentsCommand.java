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

public class ShowDoctorTreatmentsCommand implements ICommand {
	private TreatmentService treatmentService;
	private static final Logger logger = LogManager.getLogger(ShowDoctorTreatmentsCommand.class);

	public ShowDoctorTreatmentsCommand() {
		super();
		treatmentService = new TreatmentService();
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		try {
			Long doctorId = Long.valueOf(request.getParameter("doctorId"));
			List<TreatmentDTO> treatService = treatmentService.findByDoctorId(doctorId);
			request.setAttribute("treatments", treatService);

			return "/pages/doctor-treatments.jsp";
		} catch (ServiceException e) {
			logger.error("An error occurred during the display of the doctor's treatment", e);
			request.setAttribute("errorMessage", "An error occurred during the display of the doctor's treatment");
			return "/pages/error-500.jsp";
		}
	}
}
