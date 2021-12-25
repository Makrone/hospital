package by.hospital.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

import by.hospital.dao.ITreatmentDAO;
import by.hospital.dao.impl.TreatmentDAOImpl;
import by.hospital.domain.Treatment;
import by.hospital.domain.User;
import by.hospital.dto.TreatmentDTO;
import by.hospital.exception.DAOException;
import by.hospital.exception.ServiceException;

public class TreatmentService {

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

	private ITreatmentDAO repository;

	private UserService userService;

	public TreatmentService() {
		super();
		repository = new TreatmentDAOImpl();
		userService = new UserService();
	}

	public void create(Treatment treatment) throws ServiceException {
		try {
			repository.create(treatment);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public List<Treatment> getAll() throws ServiceException {
		try {
			return repository.getAll();
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

	public TreatmentDTO getDtoById(Long id) throws ServiceException {
		try {
			Treatment t = repository.get(id);
			User doctor = userService.getById(t.getDoctorId());
			User client = userService.getById(t.getClientId());
			String date = dateFormat.format(new Date(t.getDateTime().getTime()));
			TreatmentDTO dto = new TreatmentDTO(t.getId(), client, doctor, t.getMedicalConclusion(), date);
			return dto;
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void update(Treatment tret) throws ServiceException {
		try {
			repository.update(tret);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public Treatment getById(Long id) throws ServiceException {
		try {
			return repository.get(id);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public List<TreatmentDTO> findByDoctorId(Long doctorId) throws ServiceException {
		try {
			User doctor = userService.getById(doctorId);
			List<TreatmentDTO> treatments = repository.findByDoctorId(doctorId).stream().map(o -> {
				User client = null;
				try {
					client = userService.getById(o.getClientId());
				} catch (ServiceException e) {
					e.printStackTrace();
				}
				String date = dateFormat.format(new Date(o.getDateTime().getTime()));
				return new TreatmentDTO(o.getId(), client, doctor, o.getMedicalConclusion(), date);
			}).collect(Collectors.toList());

			return treatments;
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
			
		}

	}

	public List<TreatmentDTO> findByClientId(Long clientId) throws ServiceException {
		try {
			User client = userService.getById(clientId);
			List<TreatmentDTO> treatments = repository.findByClientId(clientId).stream().map(o -> {
				User doctor = null;
				try {
					doctor = userService.getById(o.getClientId());
				} catch (ServiceException e) {
					e.printStackTrace();
				}
				String date = dateFormat.format(new Date(o.getDateTime().getTime()));

				return new TreatmentDTO(o.getId(), client, doctor, o.getMedicalConclusion(), date);
			}).collect(Collectors.toList());

			return treatments;
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
}
