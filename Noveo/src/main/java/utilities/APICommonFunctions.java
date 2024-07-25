package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.WebDriver;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class APICommonFunctions {
	//private WebDriver driver;
	PropFileReader cfr = new PropFileReader();



	public String getPostRequestJsonBody(String filePath) throws FileNotFoundException {
		File f = new File(filePath);
		FileReader fileRead = new FileReader(f);
		JSONTokener jt = new JSONTokener(fileRead);
		JSONObject data = new JSONObject(jt);

		return data.toString();
	}

	public Response getPostRequestResponse(String baseURIValue,  String endPoint,String jsonBody) throws FileNotFoundException {
		
		Response resp = RestAssured.given().log().all().baseUri(baseURIValue).contentType("application/json").body(jsonBody).log().all()
				.when().post(endPoint);
		return resp;
	}

	public String generateRandomString(int length, String category) {
		String characters = null;
		if (category.equalsIgnoreCase("userName")) {
			characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		} 

		Random random = new Random();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < length; i++) {

			int randomIndex = random.nextInt(characters.length());
			sb.append(characters.charAt(randomIndex));
		}
		return sb.toString();
	}

	public String readJsonValueOfAKey(String FilePath,String key) throws IOException {
		File jsonFile = new File(FilePath);
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode = objectMapper.readTree(jsonFile);
		String value = jsonNode.get(key).asText();

		return value;
	}
}
