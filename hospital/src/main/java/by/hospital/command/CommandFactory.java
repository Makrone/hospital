package by.hospital.command;

import java.util.HashMap;
import java.util.Map;

import by.hospital.command.impl.AddMedicalServiceCommand;
import by.hospital.command.impl.AddMedicamentCommand;
import by.hospital.command.impl.AddTreatmentCommand;
import by.hospital.command.impl.DeleteMedicalServiceCommand;
import by.hospital.command.impl.DeleteMedicamentsCommand;
import by.hospital.command.impl.GoToEditServiceCommand;
import by.hospital.command.impl.GoToPageCommand;
import by.hospital.command.impl.LoginCommand;
import by.hospital.command.impl.LogoutCommand;
import by.hospital.command.impl.RegistrationCommand;
import by.hospital.command.impl.ShowAllClientsCommand;
import by.hospital.command.impl.ShowAllMedicamentsCommand;
import by.hospital.command.impl.ShowAllServicesCommand;
import by.hospital.command.impl.ShowAllTreatmentsCommand;
import by.hospital.command.impl.UpdateMedicalServiceCommand;

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
		commands.put("show-all-clients", new ShowAllClientsCommand());
		commands.put("add-medical-service",new AddMedicalServiceCommand());
		commands.put("add-medicament", new AddMedicamentCommand());
		commands.put("add-treatment", new AddTreatmentCommand());
		commands.put("go-to-page", new GoToPageCommand());
		commands.put("go-to-edit-service", new GoToEditServiceCommand());
		commands.put("delete-medicaments", new DeleteMedicamentsCommand());
		commands.put("delete-service", new DeleteMedicalServiceCommand());
		commands.put("update-medical-service", new UpdateMedicalServiceCommand());
	}
	public static ICommand getCommand(String action) {
		return commands.get(action);

	}

}
