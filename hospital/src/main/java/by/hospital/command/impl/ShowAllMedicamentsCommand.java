package by.hospital.command.impl;

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

public class ShowAllMedicamentsCommand implements ICommand {

	private MedicamentService medicamentService;
	private static final Logger logger = LogManager.getLogger(ShowAllMedicamentsCommand.class);

	public ShowAllMedicamentsCommand() {
		super();
		medicamentService = new MedicamentService();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		try {
			List<Medicament> meds = medicamentService.getAll();
			request.setAttribute("medicaments", meds);
			return "/pages/medicaments.jsp";
		} catch (ServiceException e) {
			logger.error("An error occurred during the display of all medicaments", e);
			request.setAttribute("errorMessage", "An error occurred during the display of all medicaments");
			return "/pages/error-500.jsp";
		}
	}

}
