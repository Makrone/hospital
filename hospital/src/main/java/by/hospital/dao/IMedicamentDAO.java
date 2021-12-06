package by.hospital.dao;

import by.hospital.domain.Medicament;

public interface IMedicamentDAO extends IEntityDAO<Medicament>{
	
	Medicament findByName(String name);

}
