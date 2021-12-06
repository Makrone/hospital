package by.hospital.command.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.hospital.command.ICommand;
import by.hospital.domain.MedicalService;
import by.hospital.service.MedicalServiceService;

public class UpdateMedicalServiceCommand implements ICommand {

	private static final String NAME = "name";
	private static final String DESCRIPTION = "description";
	private static final String COST = "cost";
	private static final String ID = "id";

	public MedicalServiceService medicalService;

	public UpdateMedicalServiceCommand() {
		super();
		medicalService = new MedicalServiceService();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		
		MedicalService medicalSer = new MedicalService();
		medicalSer.setId(Long.valueOf(request.getParameter(ID)));
		medicalSer.setName(request.getParameter(NAME));
		medicalSer.setDescription(request.getParameter(DESCRIPTION));
		medicalSer.setCost(new BigDecimal(request.getParameter(COST)));
		medicalService.update(medicalSer);

		List<MedicalService> service = medicalService.getAll();
		request.setAttribute("services", service);
		return "/pages/service.jsp";

	}

}
