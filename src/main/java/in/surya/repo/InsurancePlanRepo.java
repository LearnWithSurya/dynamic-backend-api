package in.surya.repo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.surya.entity.InsurancePlanEntity;

public interface InsurancePlanRepo extends JpaRepository<InsurancePlanEntity, Serializable>{
	//give unique plan name
	@Query("select distinct planName from InsurancePlanEntity")
	public List<String> getPlanNames();
	
	//give unique plan status
	@Query("select distinct planStatus from InsurancePlanEntity")
	public List<String> getPlanStatus();

}
