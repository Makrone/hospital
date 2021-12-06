package by.hospital.command.impl;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.hospital.command.ICommand;
import by.hospital.domain.Medicament;
import by.hospital.service.MedicamentService;

	public class DeleteMedicamentsCommand implements ICommand {

		private MedicamentService medicamentService;

		public DeleteMedicamentsCommand() {
			super();
			medicamentService = new MedicamentService();
		}

		@Override
		public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
			String serviceId = request.getParameter("medicamentId");
			if (serviceId == null) {
				request.setAttribute("ErrorMessage", "Medicament id missed");
			} else {
				medicamentService.delete(Long.valueOf(serviceId));
				
			}
			List<Medicament> medcicament = medicamentService.getAll();
			request.setAttribute("medicaments", medcicament);
			return "/pages/medicaments.jsp";
		}

}
