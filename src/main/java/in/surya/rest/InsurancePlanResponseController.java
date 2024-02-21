package in.surya.rest;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.surya.reponse.binding.InsuranceResponse;
import in.surya.reports.ExcelReports;
import in.surya.reports.PdfGeneratorReport;
import in.surya.request.binding.InsuranceSearchRequest;
import in.surya.service.InsurancePlanService;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin
public class InsurancePlanResponseController {
	
	@Autowired
	private InsurancePlanService service;
	
	@PostMapping("/plans")
	public ResponseEntity<List<InsuranceResponse>> searchPlans(@RequestBody InsuranceSearchRequest request){
		List<InsuranceResponse> searchPlan = service.searchPlan(request);
		return new ResponseEntity<>(searchPlan,HttpStatus.OK);
		
	}
	@GetMapping("/plan-names")
	public ResponseEntity<List<String>> getPlanNames(){
		List<String> uniquePlanName = service.getUniquePlanName();
		return new ResponseEntity<>(uniquePlanName,HttpStatus.OK);
	}
	@GetMapping("/plan-status")
	public ResponseEntity<List<String>> getPlanStatus(){
		List<String> uniquePlanStatus = service.getUniquePlanStatus();
		return new ResponseEntity<>(uniquePlanStatus,HttpStatus.OK);
	}
	
	@GetMapping("/excel")
	public void generatedExcel(HttpServletResponse response) throws Exception{
		
		    response.setContentType("application/octet-stream");
	        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	        String currentDateTime = dateFormatter.format(new java.util.Date());
	         
	        String headerKey = "Content-Disposition";
	        String headerValue = "attachment; filename=plans_" + currentDateTime + ".xlsx";
	        response.setHeader(headerKey, headerValue);
	         
		
		    List<InsuranceResponse> plans = service.searchPlan(null);//if pass null exectue all value select* from insurance;
		    ExcelReports excelReports = new ExcelReports();
		    excelReports.export(plans, response);
	}
	@GetMapping("/pdf")
	public void generatedPdf(HttpServletResponse response) throws Exception{
		
		    response.setContentType("application/pdf");
	        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	        String currentDateTime = dateFormatter.format(new java.util.Date());
	         
	        String headerKey = "Content-Disposition";
	        String headerValue = "attachment; filename=plans_" + currentDateTime + ".pdf";
	        response.setHeader(headerKey, headerValue);
	         
		
		    List<InsuranceResponse> plans = service.searchPlan(null);//if pass null exectue all value select* from insurance;
		    PdfGeneratorReport pdfGeneratorReport = new PdfGeneratorReport();
		    pdfGeneratorReport.exportPdf(plans, response);
	}

}
