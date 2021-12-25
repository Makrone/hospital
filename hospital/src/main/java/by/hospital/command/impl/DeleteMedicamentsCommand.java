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

public class DeleteMedicamentsCommand implements ICommand {

	private MedicamentService medicamentService;
	private static final Logger logger = LogManager.getLogger(DeleteMedicamentsCommand.class);

	public DeleteMedicamentsCommand() {
		super();
		medicamentService = new MedicamentService();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		try {
			String serviceId = request.getParameter("medicamentId");
			if (serviceId == null) {
				request.setAttribute("ErrorMessage", "Medicament id missed");
			} else {
				medicamentService.delete(Long.valueOf(serviceId));

			}
			List<Medicament> medcicament = medicamentService.getAll();
			request.setAttribute("medicaments", medcicament);
			return "/pages/medicaments.jsp";
		} catch (ServiceException e) {
			logger.error("An error occurred while uninstalling a medicament service ", e);
			request.setAttribute("errorMessage", "An error occurred while uninstalling a medicament service ");
			return "/pages/error-500.jsp";
		}

	}

}
