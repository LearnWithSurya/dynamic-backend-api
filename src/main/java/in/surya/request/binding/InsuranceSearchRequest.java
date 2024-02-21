package in.surya.request.binding;

import lombok.Data;

@Data
public class InsuranceSearchRequest {
	private String planName;
	private String planStatus;

}
