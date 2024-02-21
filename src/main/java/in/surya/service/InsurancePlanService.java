package in.surya.service;

import java.util.List;

import org.springframework.stereotype.Service;

import in.surya.reponse.binding.InsuranceResponse;
import in.surya.request.binding.InsuranceSearchRequest;

@Service
public interface InsurancePlanService {
	public List<InsuranceResponse> searchPlan(InsuranceSearchRequest request);
	
	public List<String> getUniquePlanName();
	
	public List<String> getUniquePlanStatus();

}
