package by.hospital.command.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.hospital.command.ICommand;
import by.hospital.domain.Medicament;
import by.hospital.exception.ServiceException;
import by.hospital.service.MedicamentService;

public class AddMedicamentCommand implements ICommand {

	private static final String NAME = "name";
	private static final String DESCRIPTION = "description";
	private static final String COST = "cost";
	private static final Logger logger = LogManager.getLogger(AddMedicamentCommand.class);
	public MedicamentService medicamentService;

	public AddMedicamentCommand() {
		super();
		medicamentService = new MedicamentService();
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		try {
			Medicament medicament = new Medicament();
			medicament.setName(request.getParameter(NAME));
			medicament.setDescription(request.getParameter(DESCRIPTION));
			medicament.setCost(new BigDecimal(request.getParameter(COST)));
			medicamentService.create(medicament);

			List<Medicament> medicaments = medicamentService.getAll();
			request.setAttribute("medicaments", medicaments);
			return "/pages/medicaments.jsp";
			

		} catch (ServiceException e) {
			logger.error("An error occurred while adding a service ", e);
			request.setAttribute("errorMessage", "An error occurred while adding a service ");
			return "/pages/error-500.jsp";

		}
	}
}
