package by.hospital.command.impl;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.hospital.command.ICommand;
import by.hospital.domain.Medicament;
import by.hospital.service.MedicamentService;

public class ShowAllMedicamentsCommand implements ICommand {

	private MedicamentService medicamentService;

	public ShowAllMedicamentsCommand() {
		super();
		medicamentService = new MedicamentService();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		List<Medicament> meds = medicamentService.getAll();
		request.setAttribute("medicaments", meds);
		return "/pages/medicaments.jsp";
	}

}
