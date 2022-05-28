import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class Basics {

	public static void main(String[] args) {
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
		.body("{\r\n"
				+ "    \"location\": {\r\n"
				+ "        \"latitude\": \"-38.383494\",\r\n"
				+ "        \"longitude\": \"33.427362\"\r\n"
				+ "    },\r\n"
				+ "    \"accuracy\": \"50\",\r\n"
				+ "    \"name\": \"Frontline house\",\r\n"
				+ "    \"phone_number\": \"(+91) 983 893 3937\",\r\n"
				+ "    \"address\": \"123 ABC Street, USA\",\r\n"
				+ "    \"types\": \"shoe park,shop\",\r\n"
				+ "    \"website\": \"https://rahulshettyacademy.com/\",\r\n"
				+ "    \"language\": \"French-IN\"\r\n"
				+ "}").
		when().post("maps/api/place/add/json").
		then().log().all().assertThat().statusCode(200);
	}

}
