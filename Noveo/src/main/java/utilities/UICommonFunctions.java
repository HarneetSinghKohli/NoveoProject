package utilities;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import baseTest.BaseTest;

public class UICommonFunctions {

	private  WebDriver driver;
	private  WebDriverWait wait;

	public UICommonFunctions(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	}

	public void clickWithExplicitWait(WebElement e) {

		e=wait.until(ExpectedConditions.elementToBeClickable(e));
		e.click();
	}

	public   WebElement clickElementAfterWaitingForVisibility(WebElement e) {

		e = wait.until(ExpectedConditions.elementToBeClickable(e));
		getElementInView(e);
		e.click();

		return e;

	}
	
	public  WebElement clickElement(WebElement e) {

		e = wait.until(ExpectedConditions.elementToBeClickable(e));
		getElementInView(e);
		e.click();

		return e;

	}

	public   void getElementInView(WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) BaseTest.driver;
		js.executeScript("arguments[0].scrollIntoView(true);", e);

	}

}
