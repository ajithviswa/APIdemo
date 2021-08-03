package Basics;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class sumValidation {
	
	@Test
	public void sumOFCourses() {
		int sum=0;
		JsonPath js=new JsonPath(NewPayload.coursePath());
		int count=js.getInt("courses.size()");
		for(int i=0;i<count;i++) {
			int price=js.getInt("courses["+i+"].price");
			int copies=js.getInt("courses["+i+"].copies");
			int amount=price*copies;
			sum=sum+amount;
			System.out.println(amount);
		}
		System.out.println(sum);
		
	}

}
