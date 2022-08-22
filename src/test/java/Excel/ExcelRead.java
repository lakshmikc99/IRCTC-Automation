package Excel;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelRead {
	

	String path = "C:\\Users\\LAKSHKC\\eclipse-workspace\\comm.irctc\\src\\test\\java\\Excel\\loginData.xlsx";
	
	public String getUsername() throws EncryptedDocumentException, IOException {
		Workbook wb = WorkbookFactory.create(new File(path)); 
		wb.close();
		DataFormatter dataFormatter = new DataFormatter();
		Sheet sheet = wb.getSheetAt(0);
		String username = dataFormatter.formatCellValue(sheet.getRow(1).getCell(0));
		return username;
	
	}
	
	public String getPassword() throws EncryptedDocumentException, IOException {
		Workbook wb = WorkbookFactory.create(new File(path));
		wb.close();
		DataFormatter dataFormatter = new DataFormatter();
		Sheet sheet = wb.getSheetAt(0);
		String password = dataFormatter.formatCellValue(sheet.getRow(1).getCell(1));
		return password;
		
	}

}
