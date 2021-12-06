package by.hospital.service;

import java.util.List;

import by.hospital.dao.ITreatmentDAO;
import by.hospital.dao.impl.TreatmentDAOImpl;
import by.hospital.domain.Medicament;
import by.hospital.domain.Treatment;

public class TreatmentService {

	private ITreatmentDAO repository;

	public TreatmentService() {
		super();
		repository = new TreatmentDAOImpl();
	}

	public void create(Treatment treatment) {
		repository.create(treatment);
	}

	public List<Treatment> getAll() {
		return repository.getAll();
	}

	public Boolean delete(Long id) {
		return repository.delete(id);
	}
}
