package by.hospital.command.impl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.hospital.command.ICommand;
import by.hospital.domain.Medicament;
import by.hospital.exception.ServiceException;
import by.hospital.service.MedicamentService;

public class GoToEditMedicamentCommand implements ICommand {

	private MedicamentService medicamentService;
	private static final Logger logger = LogManager.getLogger(GoToEditMedicamentCommand.class);

	public GoToEditMedicamentCommand() {
		super();
		medicamentService = new MedicamentService();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		try {
			Long medicamentId = Long.valueOf(request.getParameter("medicamentId"));
			Medicament medicament = medicamentService.getById(medicamentId);
			request.setAttribute("medicamentService", medicament);
			return "/pages/edit-medicaments-page.jsp";
		} catch (ServiceException e) {
			logger.error("An error occurred during the changeover of the medicament ", e);
			request.setAttribute("errorMessage", "An error occurred during the changeover of the medicament ");
			return "/pages/error-500.jsp";
		}
	}

}
