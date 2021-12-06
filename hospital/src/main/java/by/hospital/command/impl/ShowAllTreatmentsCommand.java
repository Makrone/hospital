package by.hospital.command.impl;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.hospital.command.ICommand;
import by.hospital.domain.Treatment;
import by.hospital.service.TreatmentService;

public class ShowAllTreatmentsCommand implements ICommand{
	
	
	private TreatmentService treatmentService;

	public ShowAllTreatmentsCommand() {
		super();
		treatmentService = new TreatmentService();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		List<Treatment> treatService = treatmentService.getAll();
		request.setAttribute("treatments", treatService);
		return "/pages/treatment.jsp";
	}

}
