package oAuth_demo;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class OAuth_Test {
	
	

	public static void main(String[] args) throws InterruptedException {
		
		
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ACER\\eclipse-workspace\\RestAssuredUdemy\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://accounts.google.com/o/oauth2/v2/auth/oauthchooseaccount?scope=https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email&Auth_url=https%3A%2F%2Faccounts.google.com%2Fo%2Foauth2%2Fv2%2Fauth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https%3A%2F%2Frahulshettyacademy.com%2FgetCourse.php&state=verifyfjdss&flowName=GeneralOAuthFlow");
        
		Thread.sleep(4000);	
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("ajithviswanathan03");
        Thread.sleep(4000);
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys(Keys.ENTER);
		String accesstokenresponse=given().
        queryParam("code", "").
        queryParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com").
        queryParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W").
        queryParam("redirect_uri", "https://rahulshettyacademy.com/getCourse.php").
        queryParam("grant-type", "authorization_code")
        .when().log().all()
        .post("https://www.googleapis.com/oauth2/v4/token").asString();        
        JsonPath js=new JsonPath(accesstokenresponse);
        String accesstoken= js.getString("access_token");
		
		String response=given().queryParam("access-token",accesstoken).
		when().log().all().get("https://rahulshettyacademy.com/getCourse.php")
		.asString();
		System.out.println(response);
	}

}
