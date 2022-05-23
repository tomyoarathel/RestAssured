package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

import io.restassured.http.ContentType;
import io.restassured.internal.path.json.mapping.JsonObjectDeserializer;
import io.restassured.response.Response;

public class TestExample {

	String baseURI = "https://reqres.in/api";
	
	
	@Test
	public void test_1() {
		//Response response =  get("https://catfact.ninja/fact");
		Response response = get("https://reqres.in/api/users?page=2");
		System.out.println(response);
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getBody().asString());
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}
	
	@Test
	public void test_2() {
		given().
			get(baseURI + "/users?page=2").
		then().
			statusCode(200).
			body("data[4].first_name",equalTo("George")).
			body("data.first_name",hasItems("George", "Lindsay"));
			
		
	}
	
	@Test
	public void testPost() {
		
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
		 	post(baseURI + "/uses").
		 then().statusCode(201).
		 	log().all();
	}
	
}
