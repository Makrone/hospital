package by.hospital.dao;

import by.hospital.domain.Medicament;
import by.hospital.exception.DAOException;

public interface IMedicamentDAO extends IEntityDAO<Medicament>{
	
	Medicament findByName(String name) throws DAOException;

}
