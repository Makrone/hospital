package by.hospital.command.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.hospital.command.ICommand;
import by.hospital.domain.MedicalService;
import by.hospital.domain.MedicalServiceAssignment;
import by.hospital.domain.Medicament;
import by.hospital.domain.Recipe;
import by.hospital.dto.TreatmentDTO;
import by.hospital.exception.ServiceException;
import by.hospital.service.MedicalAssignmentService;
import by.hospital.service.MedicalServiceService;
import by.hospital.service.MedicamentService;
import by.hospital.service.RecipeService;
import by.hospital.service.TreatmentService;

public class ShowClientConclusionCommand implements ICommand {
	private TreatmentService treatmentService;
	private RecipeService recepiService;
	private MedicalAssignmentService medicalAsignmentService;
	private MedicamentService medicamentService;
	private MedicalServiceService medicalService;
	private static final Logger logger = LogManager.getLogger(ShowClientConclusionCommand.class);

	public ShowClientConclusionCommand() {
		super();
		treatmentService = new TreatmentService();
		recepiService = new RecipeService();
		medicalAsignmentService = new MedicalAssignmentService();
		medicamentService = new MedicamentService();
		medicalService = new MedicalServiceService();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		try {
			Long treatmentId = Long.valueOf(request.getParameter("treatmentId"));
			Recipe recipe = recepiService.findByTreatmentId(treatmentId);
			TreatmentDTO treatment = treatmentService.getDtoById(treatmentId);
			MedicalServiceAssignment medAssignment = medicalAsignmentService.findByAssignmentId(treatmentId);
			Medicament medicament = medicamentService.getById(recipe.getMedicamentId());
			MedicalService medService = medicalService.getById(medAssignment.getMedicalServiceId());

			BigDecimal total1 = medicament.getCost();
			BigDecimal total2 = medService.getCost();
			List<BigDecimal> numbers = new ArrayList<>();
			numbers.add(total1);
			numbers.add(total2);
			BigDecimal total = numbers.stream().reduce(BigDecimal.ZERO, BigDecimal::add);

			request.setAttribute("treatment", treatment);
			request.setAttribute("medicament", medicament);
			request.setAttribute("medicalService", medService);
			request.setAttribute("total", total);
			return "/pages/show-conclusion.jsp";
		} catch (ServiceException e) {
			logger.error("Произошла ошибка во время отображения заключения ", e);
			request.setAttribute("errorMessage", "Произошла ошибка во время отображения заключения ");
			return "/pages/error-500.jsp";
		}
	}
}
