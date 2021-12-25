package by.hospital.dao;

import java.util.List;

import by.hospital.domain.Entity;
import by.hospital.exception.DAOException;

public interface IEntityDAO<T extends Entity> {

	public abstract Long create(T entity) throws DAOException;

	public abstract Long update(T entity) throws DAOException;

	public abstract Boolean delete(Long id) throws DAOException;

	public abstract T get(Long id) throws DAOException;

	public abstract List<T> getAll() throws DAOException;

}
