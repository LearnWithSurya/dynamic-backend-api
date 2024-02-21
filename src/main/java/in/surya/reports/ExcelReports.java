package in.surya.reports;

import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import in.surya.reponse.binding.InsuranceResponse;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

public class ExcelReports {
	public void export(List<InsuranceResponse> plans,HttpServletResponse response) throws Exception{
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("List of Plans");
		
		XSSFRow headerRow = sheet.createRow(0);
		
		
		headerRow.createCell(0).setCellValue("Plan ID");//mthod chaining
		
		
		headerRow.createCell(1).setCellValue("Holder Name");;
		headerRow.createCell(2).setCellValue("Holder SSN");
		
		//fresher coding
		//XSSFCell headerCell2 = headerRow.createCell(2);
		
		//headerCell2.setCellValue("Holder SSN");
		
		headerRow.createCell(3).setCellValue("Plan Name");
	
		
		headerRow.createCell(4).setCellValue("Plan Status");
		
		
		for(int i=0;i<plans.size();i++) {
			InsuranceResponse plan = plans.get(i);
			
			XSSFRow dataRow = sheet.createRow(i+1);
			
			//fresher coding 
			dataRow.createCell(0).setCellValue(plan.getPlanId());
			//cell0.setCellValue(plan.getPlanId());
			
			dataRow.createCell(1).setCellValue(plan.getPlanHoldername());//method chaining exprence guy
			//cell1.setCellValue(plan.getPlanHoldername());
			
			dataRow.createCell(2).setCellValue(plan.getPlanHolderssn());
			//cell2.setCellValue(plan.getPlanHolderssn());
			
			 dataRow.createCell(3).setCellValue(plan.getPlanName());
			//cell3.setCellValue(plan.getPlanName());
			
			dataRow.createCell(4).setCellValue(plan.getPlanStatus());
			//cell4.setCellValue(plan.getPlanStatus());
		}
		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();
	}

}
