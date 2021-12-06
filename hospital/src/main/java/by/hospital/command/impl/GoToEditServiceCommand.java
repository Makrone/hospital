package by.hospital.command.impl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.hospital.command.ICommand;
import by.hospital.domain.MedicalService;
import by.hospital.service.MedicalServiceService;

public class GoToEditServiceCommand implements ICommand {

	private MedicalServiceService medicalService;

	public GoToEditServiceCommand() {
		super();
		medicalService = new MedicalServiceService();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		Long serviceId = Long.valueOf(request.getParameter("serviceId"));
		MedicalService medSer = medicalService.getById(serviceId);
		request.setAttribute("medicalService", medSer);
		return "/pages/edit-medical-service-page.jsp";
	}

}
