package testCases;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseTest.BaseTest;
import io.restassured.response.Response;
import pageClasses.RegisterPage;
import pageObjectsUI.BooksPage;
import pageObjectsUI.LoginPage;
import pageObjectsUI.ProfilePage;
import utilities.APICommonFunctions;

import utilities.PropFileReader;
import utilities.UICommonFunctions;

public class RegisterLoginAndFindBook extends BaseTest {
	String currentDirectory = System.getProperty("user.dir");

	String configPropertiesAPI = "config/APIProperties.properties";
	String jsonRequestBody = currentDirectory.concat("\\src\\test\\resources\\jsonTestData\\userCreation.json");

	 APICommonFunctions apiCF = new APICommonFunctions();
	 UICommonFunctions uiCF;
	 RegisterPage regPage = new RegisterPage();
	 LoginPage logPage = new LoginPage();
	 BooksPage bookPage=new BooksPage();
	 PropFileReader propRead = new PropFileReader();
		/*
		 * APICommonFunctions apiCF; UICommonFunctions uiCF; RegisterPage regPage;
		 * LoginPage logPage; BooksPage bookPage; ProfilePage profPage; PropFileReader
		 * propRead;
		 */

	Properties prop;
	Response resp;
	int userNameLength;
	String user;
	String pwd;
	String baseURL;
	String endPoint;
	String bookNameToSearch = "Learning JavaScript Design Pattern";
	String urlForBookPageOpened = "https://demoqa.com/books?book=9781449331818";

	@BeforeTest(enabled = true)
	public void createUser() throws IOException {
		


		 uiCF=new UICommonFunctions(BaseTest.driver);

		prop = propRead.PropFileRead(configPropertiesAPI);
		baseURL = prop.getProperty("baseURI");
		endPoint = prop.getProperty("userCreateEndPoint");
		userNameLength = 7;
		user = apiCF.generateRandomString(userNameLength, "userName");

		String bodyContent = apiCF.getPostRequestJsonBody(jsonRequestBody);
		bodyContent = bodyContent.replaceAll("userNameToReplace", user);

		System.out.println("Json Body in Post Requeat " + bodyContent);

		regPage = apiCF.getPostRequestResponse(baseURL, endPoint, bodyContent).as(RegisterPage.class);
		String userNameCreated = regPage.getUsername();

		Assert.assertEquals(userNameCreated, user, "Username with which account is created is not correct");

		pwd = apiCF.readJsonValueOfAKey(jsonRequestBody, "password");

	}

	@Test(enabled = true)
	public void TestCase1() {

		logPage.login(user, pwd);
		bookPage.searchBookAndClick(bookNameToSearch);
		Assert.assertEquals(BaseTest.driver.getCurrentUrl(), urlForBookPageOpened);

	}

}
