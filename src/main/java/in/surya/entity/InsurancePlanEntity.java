package in.surya.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Table(name="Insurance_Plan")
@Data
public class InsurancePlanEntity {
	@Id
	@GeneratedValue
	@Column(name="Insurance_Pln_Id")
	private Integer planId;
	@Column(name="Insurance_Pln_Name")
	private String planName;
	@Column(name="Insurance_Pln_Hol_Name")
	private String planHoldername;
	@Column(name="Insurance_hol_ssn")
	private Long planHolderssn;
	@Column(name="pln_status")
	private String planStatus;

}
