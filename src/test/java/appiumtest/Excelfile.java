package appiumtest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;



public class Excelfile {
	
	public static void updateexcel(int row, int clmn,String msg)  {
		

		try {
		    FileInputStream file = new FileInputStream(new File("F:\\Book1.xls"));
		    HSSFWorkbook workbook = new HSSFWorkbook(file);
		    HSSFSheet sheet = workbook.getSheetAt(0);
		    Cell cell = null;
		    //Update the value of cell
		    cell = sheet.getRow(row).getCell(clmn);
		    cell.setCellValue(msg);
		    file.close();
		    FileOutputStream outFile = new FileOutputStream(new File("F:\\Book1.xls"));
		    workbook.write(outFile);
		    outFile.close();

		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
//	try   
//		{  
//		//declare file name to be create   
//		String filename = "F:\\Regression_check_list3.xls";  
//		//creating an instance of HSSFWorkbook class  
//		HSSFWorkbook workbook = new HSSFWorkbook();  
//		//invoking creatSheet() method and passing the name of the sheet to be created   
//		HSSFSheet sheet = workbook.createSheet("android_version51");   
//		//creating the 0th row using the createRow() method  
//		HSSFRow rowhead = sheet.createRow(0); 
//		
//		
//		rowhead.createCell(0).setCellValue("S.No.");  
//		rowhead.createCell(1).setCellValue("Screens");  
//		rowhead.createCell(2).setCellValue("Scenario");  
//		rowhead.createCell(3).setCellValue("Status(32 bit)"); 
//		rowhead.createCell(4).setCellValue("comments"); 
//		//creating the 1st row  
//		HSSFRow row = sheet.createRow(1);  
//		//inserting data in the first row  
//		row.createCell(0).setCellValue("1");  
//		row.createCell(1).setCellValue("John William");  
//		row.createCell(2).setCellValue("9999999");  
//		row.createCell(3).setCellValue("william.john@gmail.com");  
//		row.createCell(4).setCellValue("700000.00");  
//		//creating the 2nd row  
//		HSSFRow row1 = sheet.createRow(2);  
//		//inserting data in the second row  
//		row1.createCell(0).setCellValue("2");  
//		row1.createCell(1).setCellValue("Mathew Parker");  
//		row1.createCell(2).setCellValue("22222222");  
//		row1.createCell(3).setCellValue("parker.mathew@gmail.com");  
//		row1.createCell(4).setCellValue("200000.00");  
//		FileOutputStream fileOut = new FileOutputStream(filename);  
//		workbook.write(fileOut);  
//		//closing the Stream  
//		fileOut.close();  
//		//closing the workbook  
//		workbook.close();  
//		//prints the message on the console  
//		System.out.println("Excel file has been generated successfully.");  
//		}   
//		catch (Exception e)   
//		{  
//		e.printStackTrace();  
//		}    
	}
	
}
