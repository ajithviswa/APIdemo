package APITests;

import static io.restassured.RestAssured.given;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class serilizationMapsApi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		List<String> type=new ArrayList<String>();
		serialLocpojo objloc=new serialLocpojo();
		type.add("new park");
		type.add("New garden");
		serialzationPojo obj=new serialzationPojo();
		obj.setAccuracy("50");
		obj.setLanguage("39,Lake view ,Hollywood");
		obj.setLanguage("English-IN");
		obj.setPhone_number("(+91) 984567423");
		obj.setWebsite("https://rahulshettyacademy.com");
		obj.setName("New Person name");
		obj.setTypes(type);
		objloc.setLng("48.56249");
		objloc.setLat("-24.894537");
		
		obj.setLocation(objloc);
		RequestSpecification req=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").
		addQueryParam("key", "qaclick123").setContentType(ContentType.JSON)
		.build();
		
		ResponseSpecification resp=new ResponseSpecBuilder().expectStatusCode(200)
				.expectContentType(ContentType.JSON).build();
	     
		RequestSpecification res=given().spec(req).	
	       body(obj);
	       
	       Response response=res.when().post("maps/api/place/add/json").then().
	             spec(resp).extract().response();
	       
	       
	       System.out.println(response.asString());
	}

}
