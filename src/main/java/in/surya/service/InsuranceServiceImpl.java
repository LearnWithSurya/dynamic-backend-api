package in.surya.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import in.surya.entity.InsurancePlanEntity;
import in.surya.repo.InsurancePlanRepo;
import in.surya.reponse.binding.InsuranceResponse;
import in.surya.request.binding.InsuranceSearchRequest;
@Service
public class InsuranceServiceImpl implements InsurancePlanService {
	
	@Autowired
	private InsurancePlanRepo irepo;

	@Override
	public List<InsuranceResponse> searchPlan(InsuranceSearchRequest request) {
		
		InsurancePlanEntity entity = new InsurancePlanEntity();
		
		//select * from insurance_pln where insurance_Pln_Name='';
		if(request!=null &&request.getPlanName()!=null && !request.getPlanName().equals("")) {
			entity.setPlanName(request.getPlanName());
		}
		
		//select * from insurance_pln where insurance_Pln_status='';
		if(request!=null && request.getPlanStatus()!=null && !request.getPlanStatus().equals("")) {
			entity.setPlanStatus(request.getPlanStatus());
		}
		
		//select * from insurance_pln;
		Example<InsurancePlanEntity> of = Example.of(entity);
		List<InsurancePlanEntity> findAll = irepo.findAll(of);
		
		List<InsuranceResponse> plans = new ArrayList<>();
		
		for(InsurancePlanEntity plan:findAll) {
			InsuranceResponse presp = new InsuranceResponse();
			BeanUtils.copyProperties(plan, presp);
			plans.add(presp);
		}
		
		return plans;
		
	}

	@Override
	public List<String> getUniquePlanName() {
		return irepo.getPlanNames();
	}

	@Override
	public List<String> getUniquePlanStatus() {
		// TODO Auto-generated method stub
		return irepo.getPlanStatus();
	}

}
