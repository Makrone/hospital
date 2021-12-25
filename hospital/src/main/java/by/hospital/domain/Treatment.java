package by.hospital.domain;

import java.sql.Timestamp;

public class Treatment extends Entity {

	private Long id;
	private Long clientId;
	private Long doctorId;
	private String medicalConclusion;
	private Timestamp dateTime;

	public Treatment(Long id, Long clientId, Long doctorId, String medicalConclusion, Timestamp dateTime) {
		super();
		this.id = id;
		this.clientId = clientId;
		this.doctorId = doctorId;
		this.medicalConclusion = medicalConclusion;
		this.dateTime = dateTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(long doctorId) {
		this.doctorId = doctorId;
	}

	public String getMedicalConclusion() {
		return medicalConclusion;
	}

	public void setMedicalConclusion(String medicalConclusion) {
		this.medicalConclusion = medicalConclusion;
	}

	public Timestamp getDateTime() {
		return dateTime;
	}

	public void setDateTime(Timestamp dateTime) {
		this.dateTime = dateTime;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	public Treatment() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clientId == null) ? 0 : clientId.hashCode());
		result = prime * result + ((dateTime == null) ? 0 : dateTime.hashCode());
		result = prime * result + ((doctorId == null) ? 0 : doctorId.hashCode());
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
		Treatment other = (Treatment) obj;
		if (clientId == null) {
			if (other.clientId != null)
				return false;
		} else if (!clientId.equals(other.clientId))
			return false;
		if (dateTime == null) {
			if (other.dateTime != null)
				return false;
		} else if (!dateTime.equals(other.dateTime))
			return false;
		if (doctorId == null) {
			if (other.doctorId != null)
				return false;
		} else if (!doctorId.equals(other.doctorId))
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
		return "Treatment [id=" + id + ", clientId=" + clientId + ", doctorId=" + doctorId + ", medicalConclusion="
				+ medicalConclusion + ", dateTime=" + dateTime + "]";
	}

}