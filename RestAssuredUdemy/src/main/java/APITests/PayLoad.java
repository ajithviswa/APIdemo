package APITests;

public class PayLoad {
	
	public static String load() {
			
		
		return "{\r\n" + 
				"	\"location\":{\r\n" + 
				"		\"lat\":-38.383495,\r\n" + 
				"		\"lng\":33.427362\r\n" + 
				"	},\r\n" + 
				"	\"accuracy\":50,\r\n" + 
				"	\"name\":\"New_Person_4\",\r\n" + 
				"	\"phone_number\":\"(+91)1234567890\",\r\n" + 
				"	\"address\":\"29, side layout, cohen 09\",\r\n" + 
				"	\"types\":[\r\n" + 
				"		\"shoe park\",\r\n" + 
				"		\"shop\"\r\n" + 
				"		],\r\n" + 
				"	\"website\":\"http://google.com\",\r\n" + 
				"	\"language\":\"French-IN\"\r\n" + 
				"}";
	}
	public static String Addbook(String isbn,String aisle) {
		return "{\r\n" + 
				"\"name\":\"Learn Appium automation\",\r\n" + 
				"\"isbn\":\""+isbn+"\",\r\n" + 
				"\"aisle\":\""+aisle+"\",\r\n" + 
				"\"author\":\"John\"\r\n" + 
				"}";
	}

}
