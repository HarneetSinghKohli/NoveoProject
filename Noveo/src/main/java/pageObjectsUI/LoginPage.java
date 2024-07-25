package pageObjectsUI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseTest.BaseTest;
import utilities.UICommonFunctions;

public class LoginPage {

	UICommonFunctions uiCommonFunctions = new UICommonFunctions(BaseTest.driver);
	

	public  WebElement getUserName() {
		return BaseTest.driver.findElement(By.cssSelector("#userName"));
	}
	
	public  WebElement getPassword() {
		return BaseTest.driver.findElement(By.cssSelector("#password"));
	}
	
	public  WebElement getLoginBtn() {
		return BaseTest.driver.findElement(By.cssSelector("#login"));
	}
	
	public  WebElement getNewUserBtn() {
		return BaseTest.driver.findElement(By.cssSelector("#newUser"));
	}
	
	
	
	public  void login(String uName,String pwd) {
		
		getUserName().sendKeys(uName);
		getPassword().sendKeys(pwd);
		
		uiCommonFunctions.getElementInView(getLoginBtn());
		getLoginBtn().click();
		
	}
	
}
