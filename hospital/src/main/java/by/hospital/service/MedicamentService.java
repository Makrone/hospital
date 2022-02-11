package by.hospital.service;

import java.math.BigDecimal;
import java.util.List;

import by.hospital.dao.IMedicamentDAO;
import by.hospital.dao.impl.MedicamentDAOImpl;
import by.hospital.domain.Medicament;
import by.hospital.exception.DAOException;
import by.hospital.exception.ServiceException;

public class MedicamentService {
	private IMedicamentDAO repository;

	public MedicamentService() {
		super();
		repository = new MedicamentDAOImpl();
	}

	public void create(Medicament medicament) throws ServiceException {
		try {
			repository.create(medicament);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public Medicament findByName(String name) throws ServiceException {
		try {
			return repository.findByName(name);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public Boolean delete(Long id) throws ServiceException {
		try {
			return repository.delete(id);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public List<Medicament> getAll() throws ServiceException {
		try {
			return repository.getAll();
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public Medicament getById(Long id) throws ServiceException {
		try {
			return repository.get(id);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public Medicament getCost(Long cost) throws ServiceException {
		try {
			return repository.get(cost);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public Medicament get(Long id) throws ServiceException {
		try {
			return repository.get(id);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void update(Medicament medicamentService) throws ServiceException {
		try {
			repository.update(medicamentService);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

}
