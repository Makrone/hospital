package by.hospital.domain;

public class Treatment extends Entity {

	private Long id;
	private Long clientId;
	private long doctorId;
	private String medicalConclusion;

	public Treatment() {
		super();
	}

	public Treatment(Long id, Long clientId, long doctorId, String medicalConclusion) {
		super();
		this.id = id;
		this.clientId = clientId;
		this.doctorId = doctorId;
		this.medicalConclusion = medicalConclusion;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clientId == null) ? 0 : clientId.hashCode());
		result = prime * result + (int) (doctorId ^ (doctorId >>> 32));
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
		if (doctorId != other.doctorId)
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
		StringBuilder builder = new StringBuilder();
		builder.append("Treatment [id=");
		builder.append(id);
		builder.append(", clientId=");
		builder.append(clientId);
		builder.append(", doctorId=");
		builder.append(doctorId);
		builder.append(", medicalConclusion=");
		builder.append(medicalConclusion);
		builder.append("]");
		return builder.toString();
	}

	
}