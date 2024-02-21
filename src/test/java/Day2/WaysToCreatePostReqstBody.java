package Day2;

import org.json.JSONObject;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;



public class WaysToCreatePostReqstBody 
{
	
	//1.post request using Hash Map
	
	
//	@Test(priority = 1)
	public void testPostUsingHashMap()
	{
		HashMap data=new HashMap();
		data.put("name","smith");
		data.put("job","QA");
		
		given()
		  .contentType("application/json")
		      .body(data)
		
		.when()
		   .post("http://localhost:3000/Students")
		
		.then()
		   .statusCode(201)
		   .body("name", equalTo("smith"))
		   .log().all();
			
	}
	
	//2.post request using org.json
	
	@Test(priority = 1)
	public void testPostUsingJsonLibrary()
	{
		JSONObject data=new JSONObject();
		
		data.put("name", "scott");
		data.put("job", "BA");
		
		
		given()
		  .contentType("application/json")
		      .body(data.toString())
		
		.when()
		   .post("http://localhost:3000/Students")
		
		.then()
		   .statusCode(201)
		   .body("name", equalTo("scott"))
		   .log().all();
			
	}
	
	
	
	
	//Deleting student record
	@Test(priority = 2)
	public void testDelete() 
	{
		given()
		
		.when()
		  .delete("http://localhost:3000/Students/10")
		  
		  .then()
		  .statusCode(404);
	}

}
