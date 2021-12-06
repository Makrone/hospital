package by.hospital.dao;

import java.util.List;

import by.hospital.domain.Entity;

public interface IEntityDAO<T extends Entity> {
	
	public abstract Long create(T entity);

	public abstract Long update(T entity);

	public abstract Boolean delete(Long id);

	public abstract T get(Long id);

	public abstract List<T> getAll();
	

}
