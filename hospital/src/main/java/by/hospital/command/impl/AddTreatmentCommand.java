package by.hospital.command.impl;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.hospital.command.ICommand;
import by.hospital.domain.Treatment;
import by.hospital.service.TreatmentService;

public class AddTreatmentCommand implements ICommand {

	private static final String CLIENT_ID = "client_id";
	private static final String DOCTOR_ID = "doctor_id";
	private static final String MEDICAL_CONCLUSION = "medical_conclusion";

	private TreatmentService treatmentService;

	public AddTreatmentCommand() {
		super();
		treatmentService = new TreatmentService();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		if (request.getParameter(CLIENT_ID) == null || request.getParameter(DOCTOR_ID) == null
				|| request.getParameter(MEDICAL_CONCLUSION) == null) {
			request.setAttribute("ErrorMessage", "Fields cannot be empty");
		} else {
			Treatment treatSer = new Treatment();
			treatSer.setClientId(Long.valueOf(request.getParameter(CLIENT_ID)));
			treatSer.setDoctorId(Long.valueOf(request.getParameter(DOCTOR_ID)));
			treatSer.setMedicalConclusion(request.getParameter(MEDICAL_CONCLUSION));
			treatmentService.create(treatSer);

		}
		List<Treatment> treatment = treatmentService.getAll();
		request.setAttribute("treatments", treatment);
		return "/pages/treatment.jsp";
	}

}
