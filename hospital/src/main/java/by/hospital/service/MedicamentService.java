package by.hospital.service;

import java.util.List;

import by.hospital.dao.IMedicamentDAO;
import by.hospital.dao.impl.MedicamentDAOImpl;
import by.hospital.domain.Medicament;

public class MedicamentService {
	private IMedicamentDAO repository;

	public MedicamentService() {
		super();
		repository = new MedicamentDAOImpl();
	}

	public void create(Medicament medicament) {

		repository.create(medicament);
	}

	public Medicament findByName(String name) {
		return repository.findByName(name);
	}

	public Boolean delete(Long id) {
		return repository.delete(id);
	}

	public List<Medicament> getAll() {
		return repository.getAll();
	}

}
