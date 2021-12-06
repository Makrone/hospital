package by.hospital.command.impl;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.hospital.command.ICommand;
import by.hospital.domain.MedicalService;
import by.hospital.service.MedicalServiceService;

public class DeleteMedicalServiceCommand implements ICommand {

	private MedicalServiceService medicalService;

	public DeleteMedicalServiceCommand() {
		super();
		medicalService = new MedicalServiceService();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		String serviceId = request.getParameter("serviceId");
		if (serviceId == null) {
			request.setAttribute("ErrorMessage", "Service id missed");
		} else {
			medicalService.delete(Long.valueOf(serviceId));
			
		}
		List<MedicalService> service = medicalService.getAll();
		request.setAttribute("services", service);
		return "/pages/service.jsp";
	}

}
