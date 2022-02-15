package by.hospital.command.impl;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.hospital.command.ICommand;
import by.hospital.domain.Treatment;
import by.hospital.domain.User;
import by.hospital.dto.TreatmentDTO;
import by.hospital.exception.ServiceException;
import by.hospital.service.TreatmentService;

public class CreateTreatmentCommand implements ICommand {

	private TreatmentService treatmentService;
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
	private static final Logger logger = LogManager.getLogger(CreateTreatmentCommand.class);

	public CreateTreatmentCommand() {
		super();
		treatmentService = new TreatmentService();
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		try {
			Long doctorId = Long.valueOf(request.getParameter("doctor_id"));

			String dateTimeString = request.getParameter("date_time");
			Timestamp timestamp = null;
			try {
				Date parsedDate = dateFormat.parse(dateTimeString);
				timestamp = new java.sql.Timestamp(parsedDate.getTime());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			User client = (User) request.getSession().getAttribute("user");

			Treatment treatment = new Treatment();
			treatment.setClientId(client.getId());
			treatment.setDoctorId(doctorId);
			treatment.setDateTime(timestamp);

			treatmentService.create(treatment);
			List<TreatmentDTO> treatments = treatmentService.findByClientId(client.getId());
			request.setAttribute("treatments", treatments);
			return "/pages/show-client-treatments.jsp";
		} catch (ServiceException e) {
			logger.error("An error occurred during the creation of the treatment", e);
			request.setAttribute("errorMessage", "An error occurred during the creation of the treatment");
			return "/pages/error-500.jsp";
		}
	}

}
