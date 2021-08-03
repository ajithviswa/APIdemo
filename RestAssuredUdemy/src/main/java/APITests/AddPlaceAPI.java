package APITests;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;



public class AddPlaceAPI {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//given---url and input details
		//when---Subit the api -resource,http method
		//then---validate the response
       RestAssured.baseURI="https://rahulshettyacademy.com";
       String response=given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json").
       body(new String(Files.readAllBytes(Paths.get("C:\\Users\\ACER\\Documents\\addPlace.json")))).when().post("maps/api/place/add/json").then().
             assertThat().statusCode(200).body("scope",equalTo("APP")).
             header("server","Apache/2.4.18 (Ubuntu)").extract().response().asString();
       
       System.out.println(response);
       JsonPath js=new JsonPath(response);
       String placeid=js.getString("place_id");
       System.out.println(placeid);
       
       //update
       String new_address="70 Summer walk USA";
       
       given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json").
       body("{\r\n" + 
       		"	\"place_id\": \""+placeid+"\",\r\n" + 
       		"	\"address\":\""+new_address+"\",\r\n" + 
       		"	\"key\":\"qaclick123\"\r\n" + 
       		"}").when().put("maps/api/place/update/json").then().
       assertThat().log().all().statusCode(200).body("msg",equalTo("Address successfully updated"));
       
       //asserting 70 summer walk usa
       
       pojoClass obj=given().log().all().queryParam("key","qaclick123").queryParam("place_id", placeid)
    		   .expect().defaultParser(Parser.JSON).when().get("maps/api/place/get/json").then().
               assertThat().log().all().statusCode(200).extract().response().as(pojoClass.class);
       
       /*JsonPath newjs=ReusableCode.rawToJson(getPlaceResponse);
       String actualaddress=newjs.getString("address");
       System.out.println(actualaddress);
       Assert.assertEquals(actualaddress, new_address);
       */
       System.out.println(obj.getAddress());
       System.out.println(obj.getLanguage());
       System.out.println(obj.getName());
       System.out.println(obj.getLocation().getLatitude());
       System.out.println(obj.getTypes());
	}

}
