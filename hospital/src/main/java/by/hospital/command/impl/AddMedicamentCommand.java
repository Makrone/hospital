package by.hospital.command.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.hospital.command.ICommand;
import by.hospital.domain.Medicament;
import by.hospital.service.MedicamentService;

public class AddMedicamentCommand implements ICommand {

	private static final String NAME = "name";
	private static final String DESCRIPTION = "description";
	private static final String COST = "cost";

	public MedicamentService medicamentService;

	public AddMedicamentCommand() {
		super();
		medicamentService = new MedicamentService();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		Medicament medicament = new Medicament();
		medicament.setName(request.getParameter(NAME));
		medicament.setDescription(request.getParameter(DESCRIPTION));
		medicament.setCost(new BigDecimal(request.getParameter(COST)));
		medicamentService.create(medicament);

		List<Medicament> medicaments = medicamentService.getAll();
		request.setAttribute("medicaments", medicaments);
		return "/pages/medicaments.jsp";

	}

}
