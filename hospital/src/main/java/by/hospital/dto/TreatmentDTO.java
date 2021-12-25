package by.hospital.dto;

import by.hospital.domain.User;

public class TreatmentDTO {

	private Long id;
	private User client;
	private User doctor;
	private String medicalConclusion;
	private String dateTime;

	public TreatmentDTO() {
		super();
	}

	public TreatmentDTO(Long id, User client, User doctor, String medicalConclusion, String dateTime) {
		super();
		this.id = id;
		this.client = client;
		this.doctor = doctor;
		this.medicalConclusion = medicalConclusion;
		this.dateTime = dateTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

	public User getDoctor() {
		return doctor;
	}

	public void setDoctor(User doctor) {
		this.doctor = doctor;
	}

	public String getMedicalConclusion() {
		return medicalConclusion;
	}

	public void setMedicalConclusion(String medicalConclusion) {
		this.medicalConclusion = medicalConclusion;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result + ((dateTime == null) ? 0 : dateTime.hashCode());
		result = prime * result + ((doctor == null) ? 0 : doctor.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((medicalConclusion == null) ? 0 : medicalConclusion.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TreatmentDTO other = (TreatmentDTO) obj;
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		if (dateTime == null) {
			if (other.dateTime != null)
				return false;
		} else if (!dateTime.equals(other.dateTime))
			return false;
		if (doctor == null) {
			if (other.doctor != null)
				return false;
		} else if (!doctor.equals(other.doctor))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (medicalConclusion == null) {
			if (other.medicalConclusion != null)
				return false;
		} else if (!medicalConclusion.equals(other.medicalConclusion))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TreatmentDTO [id=" + id + ", client=" + client + ", doctor=" + doctor + ", medicalConclusion="
				+ medicalConclusion + ", dateTime=" + dateTime + "]";
	}

}
