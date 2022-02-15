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
import by.hospital.domain.MedicalServiceAssignment;
import by.hospital.domain.Recipe;
import by.hospital.domain.Treatment;
import by.hospital.domain.User;
import by.hospital.dto.TreatmentDTO;
import by.hospital.exception.ServiceException;
import by.hospital.service.MedicalAssignmentService;
import by.hospital.service.RecipeService;
import by.hospital.service.TreatmentService;

public class SaveMedicalConclusionCommand implements ICommand {

	private TreatmentService treatmentService;
	private MedicalAssignmentService medicalAsignmentService;
	private RecipeService recepiService;
	private static final Logger logger = LogManager.getLogger(SaveMedicalConclusionCommand.class);

	public SaveMedicalConclusionCommand() {
		super();
		treatmentService = new TreatmentService();
		recepiService = new RecipeService();
		medicalAsignmentService = new MedicalAssignmentService();
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		try {
			Long treatmentId = Long.valueOf(request.getParameter("treatmentId"));
			Long medicalServiceId = Long.valueOf(request.getParameter("medical_service_id"));
			Long medicamentId = Long.valueOf(request.getParameter("medicament_id"));
			String medicalConclusion = request.getParameter("medical_conclusion");
			Treatment treat = treatmentService.getById(treatmentId);
			treat.setMedicalConclusion(medicalConclusion);
			treatmentService.update(treat);
			Recipe recipe = new Recipe();
			MedicalServiceAssignment medAssignment = new MedicalServiceAssignment();
			recipe.setMedicamentId(medicamentId);
			recipe.setTreatmentId(treatmentId);
			recipe.setQuantity(1);
			recepiService.create(recipe);
			medAssignment.setMedicalServiceId(medicalServiceId);
			medAssignment.setTreatmentId(treatmentId);
			medAssignment.setQuantity(1);
			medicalAsignmentService.create(medAssignment);
			User user = (User) request.getSession().getAttribute("user");
			List<TreatmentDTO> treatService = treatmentService.findByDoctorId(user.getId());
			request.setAttribute("treatments", treatService);
			return "/pages/doctor-treatments.jsp";
		} catch (ServiceException e) {
			logger.error("There was an error during the display of the medical report", e);
			request.setAttribute("errorMessage", "There was an error during the display of the medical report");
			return "/pages/error-500.jsp";
		}
	}

}
