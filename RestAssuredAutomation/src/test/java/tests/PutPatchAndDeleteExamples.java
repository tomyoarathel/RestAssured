package tests;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutPatchAndDeleteExamples {

	String baseURI = "https://reqres.in";
	
	@Test
	public void testPUT() {
		 JSONObject request = new JSONObject();
		 request.put("name", "Student1");
		 request.put("job", "TeamLead"); 
		 System.out.println(request.toJSONString());
		 
		 given().
		 	//header("Content-Type", "application/json").
		 	contentType(ContentType.JSON).
		 	accept(ContentType.JSON).
		 	body(request.toJSONString()).
		 when().
		 	put(baseURI + "/api/users/2").
		 then().statusCode(200).
		 	log().all();
	}
	
	@Test
	public void testPATCH() {
		 JSONObject request = new JSONObject();
		 request.put("name", "Student1");
		 request.put("job", "TeamLead"); 
		 System.out.println(request.toJSONString());
		 
		 given().
		 	contentType(ContentType.JSON).
		 	accept(ContentType.JSON).
		 	body(request.toJSONString()).
		 when().
		 	patch(baseURI + "/api/users/2").
		 then().statusCode(200).
		 	log().all();
	}
	
	@Test
	public void testDELETE() {
		 
		 when().
		 	delete(baseURI + "/api/users/2").
		 then().statusCode(204).
		 	log().all();
	}
}
