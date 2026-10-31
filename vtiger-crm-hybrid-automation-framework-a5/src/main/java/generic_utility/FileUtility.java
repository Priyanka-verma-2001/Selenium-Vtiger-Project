package generic_utility;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FileUtility {
	public static String getDataFromJsonFile(String key) throws IOException, ParseException {
		JSONParser parser = new JSONParser();
		FileReader reader = new FileReader("./src/test/resources/cd.json");
		Object obj = parser.parse(reader);
		JSONObject jsonObject = (JSONObject) obj;
		String value = (String) jsonObject.get(key);
		return value;
	}
	
	public static String getDataFromExcelFile(String sheetname, int rowindex, int cellIndex) throws IOException {
		FileInputStream fis = new FileInputStream("/Users/priyankaverma/Downloads/AdvanceselniumTestCase-2.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		Row rw = sh.getRow(rowindex);
		Cell cl = rw.getCell(cellIndex);
		String value = cl.getStringCellValue();
		wb.close();
		return value;
	}
}
