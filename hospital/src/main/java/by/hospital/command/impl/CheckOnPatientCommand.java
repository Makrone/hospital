package by.hospital.command.impl;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.hospital.command.ICommand;
import by.hospital.domain.MedicalService;
import by.hospital.domain.Medicament;
import by.hospital.exception.ServiceException;
import by.hospital.service.MedicalServiceService;
import by.hospital.service.MedicamentService;
import by.hospital.service.TreatmentService;

public class CheckOnPatientCommand implements ICommand {

	private TreatmentService treatmentService;
	private MedicalServiceService medicalService;
	private MedicamentService medicamentService;
	private static final Logger logger = LogManager.getLogger(CheckOnPatientCommand.class);


	public CheckOnPatientCommand() {
		super();
		treatmentService = new TreatmentService();
		medicalService = new MedicalServiceService();
		medicamentService = new MedicamentService();
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		try {
			String treatmentId = request.getParameter("treatmentId");

			List<MedicalService> services = medicalService.getAll();
			List<Medicament> medicaments = medicamentService.getAll();
			request.setAttribute("treatmentId", treatmentId);
			request.setAttribute("services", services);
			request.setAttribute("medicaments", medicaments);

			return "/pages/create-medical-conclusion.jsp";
		} catch (ServiceException e) {
			logger.error("An error occurred during the patient check", e);
			request.setAttribute("errorMessage", "An error occurred during the patient check");
			return "/pages/error-500.jsp";
		}
	}

}
