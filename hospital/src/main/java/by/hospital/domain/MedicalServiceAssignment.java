package by.hospital.domain;

public class MedicalServiceAssignment extends Entity {

	private Long id;
	private Long treatmentId;
	private Long medicalServiceId;
	private Integer quantity;

	public MedicalServiceAssignment() {
		super();
	}

	public MedicalServiceAssignment(Long id, Long treatmentId, Long medicalServiceId, Integer quantity) {
		super();
		this.id = id;
		this.treatmentId = treatmentId;
		this.medicalServiceId = medicalServiceId;
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTreatmentId() {
		return treatmentId;
	}

	public void setTreatmentId(Long treatmentId) {
		this.treatmentId = treatmentId;
	}

	public Long getMedicalServiceId() {
		return medicalServiceId;
	}

	public void setMedicalServiceId(Long medicalServiceId) {
		this.medicalServiceId = medicalServiceId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((medicalServiceId == null) ? 0 : medicalServiceId.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		result = prime * result + ((treatmentId == null) ? 0 : treatmentId.hashCode());
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
		MedicalServiceAssignment other = (MedicalServiceAssignment) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (medicalServiceId == null) {
			if (other.medicalServiceId != null)
				return false;
		} else if (!medicalServiceId.equals(other.medicalServiceId))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		if (treatmentId == null) {
			if (other.treatmentId != null)
				return false;
		} else if (!treatmentId.equals(other.treatmentId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MedicalServiceAssignment [id=");
		builder.append(id);
		builder.append(", treatmentId=");
		builder.append(treatmentId);
		builder.append(", medicalServiceId=");
		builder.append(medicalServiceId);
		builder.append(", quantity=");
		builder.append(quantity);
		builder.append("]");
		return builder.toString();
	}

}
