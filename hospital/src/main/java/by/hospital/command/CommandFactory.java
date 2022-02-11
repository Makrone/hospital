package by.hospital.command;

import java.util.HashMap;
import java.util.Map;

import by.hospital.command.impl.AddMedicalServiceCommand;
import by.hospital.command.impl.AddMedicamentCommand;
import by.hospital.command.impl.AddTreatmentCommand;
import by.hospital.command.impl.CancelTreatmentCommand;
import by.hospital.command.impl.CheckOnPatientCommand;
import by.hospital.command.impl.CreateTreatmentCommand;
import by.hospital.command.impl.DeleteClientCommand;
import by.hospital.command.impl.DeleteMedicalServiceCommand;
import by.hospital.command.impl.DeleteMedicamentsCommand;
import by.hospital.command.impl.EditUserCommand;
import by.hospital.command.impl.GoEditUserCommand;
import by.hospital.command.impl.GoToEditMedicamentCommand;
import by.hospital.command.impl.GoToEditServiceCommand;
import by.hospital.command.impl.GoToMakeAppointment;
import by.hospital.command.impl.GoToPageCommand;
import by.hospital.command.impl.GoToPaymentSuccessCommand;
import by.hospital.command.impl.GoToProfileCommand;
import by.hospital.command.impl.LoginCommand;
import by.hospital.command.impl.LogoutCommand;
import by.hospital.command.impl.RegistrationCommand;
import by.hospital.command.impl.SaveMedicalConclusionCommand;
import by.hospital.command.impl.ShowAllClientDoctorsCommand;
import by.hospital.command.impl.ShowAllClientsCommand;
import by.hospital.command.impl.ShowAllDoctorsCommand;
import by.hospital.command.impl.ShowAllMedicamentsCommand;
import by.hospital.command.impl.ShowAllServicesCommand;
import by.hospital.command.impl.ShowAllTreatmentsCommand;
import by.hospital.command.impl.ShowClientAllServicesCommand;
import by.hospital.command.impl.ShowClientConclusionCommand;
import by.hospital.command.impl.ShowClientTreatmentsCommand;
import by.hospital.command.impl.ShowDoctorTreatmentsCommand;
import by.hospital.command.impl.UpdateMedicalServiceCommand;
import by.hospital.command.impl.UpdateMedicamentCommand;

public class CommandFactory {

	private static Map<String, ICommand> commands = new HashMap<>();

	static {
		commands.put("registration", new RegistrationCommand());
		commands.put("login", new LoginCommand());
		commands.put("logout", new LogoutCommand());
		commands.put("show-all-medicaments", new ShowAllMedicamentsCommand());
		commands.put("show-all-medical-services", new ShowAllServicesCommand());
		commands.put("show-all-treatment", new ShowAllTreatmentsCommand());
		commands.put("show-all-medicaments", new ShowAllMedicamentsCommand());
		commands.put("show-client-conclusion", new ShowClientConclusionCommand());
		commands.put("show-all-clients", new ShowAllClientsCommand());
		commands.put("show-doctor-treatments", new ShowDoctorTreatmentsCommand());
		commands.put("show-client-treatments", new ShowClientTreatmentsCommand());
		commands.put("show-all-doctors", new ShowAllDoctorsCommand());
		
		commands.put("show-client-doctors", new ShowAllClientDoctorsCommand());
		
		commands.put("show-service-client", new ShowClientAllServicesCommand());

		commands.put("add-medical-service", new AddMedicalServiceCommand());
		commands.put("add-medicament", new AddMedicamentCommand());
		commands.put("add-treatment", new AddTreatmentCommand());

		commands.put("go-to-page", new GoToPageCommand());
		commands.put("go-to-edit-service", new GoToEditServiceCommand());
		commands.put("go-to-edit-medicament", new GoToEditMedicamentCommand());
		commands.put("go-to-edit-user", new GoEditUserCommand());

		commands.put("delete-medicaments", new DeleteMedicamentsCommand());
		commands.put("delete-service", new DeleteMedicalServiceCommand());
		commands.put("delete-client", new DeleteClientCommand());
		commands.put("cancel-treatment", new CancelTreatmentCommand());
		
		commands.put("update-medical-service", new UpdateMedicalServiceCommand());
		commands.put("update-medicament", new UpdateMedicamentCommand());
		commands.put("edit-user", new EditUserCommand());
		commands.put("go-to-make-appointment", new GoToMakeAppointment());
		commands.put("create-treatment", new CreateTreatmentCommand());
		commands.put("check-on-patient", new CheckOnPatientCommand());
		commands.put("save-medical-conclusion", new SaveMedicalConclusionCommand());
		
		commands.put("go-to-profile", new GoToProfileCommand());
		
		commands.put("payment-success", new GoToPaymentSuccessCommand());
	}

	public static ICommand getCommand(String action) {
		return commands.get(action);

	}

}
