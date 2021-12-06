package by.hospital.service;

import java.util.List;

import by.hospital.dao.IMedicalServiceDAO;
import by.hospital.dao.impl.MedicalServiceDAOImpl;
import by.hospital.domain.MedicalService;

public class MedicalServiceService {
	private IMedicalServiceDAO repository;

	public MedicalServiceService() {
		super();
		repository = new MedicalServiceDAOImpl();
	}

	public void create(MedicalService medicalService) {
		repository.create(medicalService);
	}
	public void update (MedicalService medicalService) {
		repository.update(medicalService);
	}

	public List<MedicalService> getAll() {
		return repository.getAll();
	}

	public Boolean delete(Long id) {
		return repository.delete(id);
	}

	public MedicalService getById(Long id) {
		return repository.get(id);
	}

}
