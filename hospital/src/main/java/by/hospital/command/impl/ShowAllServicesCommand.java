package by.hospital.command.impl;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.hospital.command.ICommand;
import by.hospital.domain.MedicalService;
import by.hospital.service.MedicalServiceService;

public class ShowAllServicesCommand implements ICommand {

	private MedicalServiceService medicalService;

	public ShowAllServicesCommand() {
		super();
		medicalService = new MedicalServiceService();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		List<MedicalService> service = medicalService.getAll();
		request.setAttribute("services", service);
		return "/pages/service.jsp";
	}

}
