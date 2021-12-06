package by.hospital.db.testConnection;

import by.hospital.dao.IRecipeDAO;
import by.hospital.dao.impl.RecipeDAOImpl;
import by.hospital.domain.Recipe;

public class RecipeConnection {

	public static void main(String[] args) {
		Recipe rp = new Recipe();
		rp.setMedicamentId(2L);
		rp.setQuantity(3);
		rp.setTreatmentId(4L);
		IRecipeDAO td = new RecipeDAOImpl();
		Long id = td.create(rp);
		System.out.println(id);

	}
}
