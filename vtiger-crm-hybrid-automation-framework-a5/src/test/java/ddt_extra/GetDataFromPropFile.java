package ddt_extra;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetDataFromPropFile {

	public static void main(String[] args) throws IOException {
		
		// step: 1 Create a java representation object of the physical file
		FileInputStream fis = new FileInputStream("./src/test/resources/cd.properties");
		
		// Step:2 load all the keys by using load(fis)
		Properties pObj = new Properties();
		pObj.load(fis);
		
		// Step:3 get the value by passing key in get Property(key)
		String browser = pObj.getProperty("bro");
		String url = pObj.getProperty("url");
		String username = pObj.getProperty("Username");
		String password = pObj.getProperty("Password");
		
		fis.close();

	}

}
