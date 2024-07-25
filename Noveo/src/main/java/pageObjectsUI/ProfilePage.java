package pageObjectsUI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import baseTest.BaseTest;

public class ProfilePage {

	private WebDriver driver;

	public static  WebElement getGoToStoreButton() {
		return BaseTest.driver.findElement(By.xpath("//li[@id='item-2']//span[contains(text(),'Book Store')]"));
	}
	
	
}
