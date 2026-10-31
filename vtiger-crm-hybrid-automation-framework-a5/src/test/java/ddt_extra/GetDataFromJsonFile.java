package ddt_extra;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class GetDataFromJsonFile {
	public static void main(String[] args) throws IOException, ParseException {
		
		// Step:1 create a JSONParser object
		JSONParser parser = new JSONParser();
		
		// Step:2 Pass JSON file path
		FileReader fr = new FileReader("./src/test/resources/cd.json");

		// Step:3 Parse JSON file
		Object obj = parser.parse(fr);

		// Step:4 Convert object into JSON Object
		JSONObject jobj = (JSONObject) obj;

		// Step:5 Read Data using key
		String url = jobj.get("bro").toString();
		String username = jobj.get("username").toString();
		String password = jobj.get("password").toString();

		// Step:6 Print data
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
	}

}
