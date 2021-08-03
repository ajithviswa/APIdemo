package APITests;

import io.restassured.path.json.JsonPath;

public class ReusableCode {
	
	public static JsonPath rawToJson(String response) {
		
		JsonPath jsi=new JsonPath(response);
		return jsi;
		
	}

}
