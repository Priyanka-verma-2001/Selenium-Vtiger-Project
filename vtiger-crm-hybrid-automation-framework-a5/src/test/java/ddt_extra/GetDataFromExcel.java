package ddt_extra;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetDataFromExcel {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
//		step 1 > get access of workbook
		FileInputStream fis = new FileInputStream("");
		Workbook wb = WorkbookFactory.create(fis);

//		step 2> get access of sheet
//		Sheet sh = wb.getSheet("Sheet2");
//		
//		step 3> get access of row
//		Row row = sh.getRow(1);
//		
//		step 4> get the access of cell
//		Cell cell = row.getCell(0);
//		
//		step 5> get the data
//		String orgName = cell.getStringCellValue();
		
//		System.out.println(orgName);
		
		String lastName = wb.getSheet("contact").getRow(1).getCell(0).getStringCellValue();
		System.out.println(lastName);
	}

}
