package by.hospital.service;

import java.util.List;

import by.hospital.dao.IMedicalServiceDAO;
import by.hospital.dao.impl.MedicalServiceDAOImpl;
import by.hospital.domain.MedicalService;
import by.hospital.exception.DAOException;
import by.hospital.exception.ServiceException;

public class MedicalServiceService {
	private IMedicalServiceDAO repository;

	public MedicalServiceService() {
		super();
		repository = new MedicalServiceDAOImpl();
	}

	public void create(MedicalService medicalService) throws ServiceException {
		try {
			repository.create(medicalService);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(),e);
		}
	}
	public void update (MedicalService medicalService)throws ServiceException{
		try {
			repository.update(medicalService);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(),e);
		}
	}

	public List<MedicalService> getAll() throws ServiceException{
		try {
			return repository.getAll();
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(),e);
		}
	}

	public Boolean delete(Long id) throws ServiceException{
		try {
			return repository.delete(id);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(),e);
		}
	}

	public MedicalService getById(Long id) throws ServiceException{
		try {
			return repository.get(id);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(),e);
		}
	}

}
