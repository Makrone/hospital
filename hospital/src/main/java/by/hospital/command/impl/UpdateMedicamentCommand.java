package by.hospital.command.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.hospital.command.ICommand;
import by.hospital.domain.Medicament;
import by.hospital.exception.ServiceException;
import by.hospital.service.MedicamentService;

public class UpdateMedicamentCommand implements ICommand {

	private static final String NAME = "name";
	private static final String DESCRIPTION = "description";
	private static final String COST = "cost";
	private static final String ID = "id";
	private static final Logger logger = LogManager.getLogger(UpdateMedicamentCommand.class);
	public MedicamentService medicamentService;

	public UpdateMedicamentCommand() {
		super();
		medicamentService = new MedicamentService();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		try {
			Medicament medicament = new Medicament();
			medicament.setId(Long.valueOf(request.getParameter(ID)));
			medicament.setName(request.getParameter(NAME));
			medicament.setDescription(request.getParameter(DESCRIPTION));
			medicament.setCost(new BigDecimal(request.getParameter(COST)));
			medicamentService.update(medicament);

			List<Medicament> medicaments = medicamentService.getAll();
			request.setAttribute("medicaments", medicaments);
			request.setAttribute("errorMessage", "Changed");
			return "/pages/medicaments.jsp";

		} catch (ServiceException e) {
			logger.error("There was an error during the medication update", e);
			request.setAttribute("errorMessage", "There was an error during the medication update");
			return "/pages/error-500.jsp";
		}
	}

}
