package Basics;

import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         JsonPath js=new JsonPath(NewPayload.coursePath());
         int count=js.getInt("courses.size()");
         System.out.println(count);
         int count_PURCHASE=js.getInt("dashboard.purchaseAmount");
         System.out.println(count_PURCHASE);
         String title_first=js.getString("courses[0].title");
         System.out.println(title_first);
         for(int i=0;i<count;i++) {
        	 System.out.println(js.get("courses["+i+"].price"));
         }
	}

}
