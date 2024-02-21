package in.surya.reponse.binding;

import lombok.Data;

@Data
public class InsuranceResponse {
	private Integer planId;
	private String planHoldername;
	private String planName;
	private Long planHolderssn;
	private String planStatus;

}
