package pageObjectsUI;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import baseTest.BaseTest;

import utilities.UICommonFunctions;

public class BooksPage {

	static WebElement e;
	UICommonFunctions uiCF=new UICommonFunctions(BaseTest.driver);
	
	public static  WebElement getSearchBox() {

		try {
			e = BaseTest.driver.findElement(By.cssSelector("#searchBox-wrapper #searchBox"));
		} catch (NoSuchElementException a) {
			System.out.println("No such element caught");
			e = BaseTest.driver.findElement(By.cssSelector("#searchBox-wrapper #searchBox"));
		}

		return e;
	}

	public  static WebElement getBookNameLink(String bookName) {
		return BaseTest.driver.findElement(By.xpath("//span[@class='mr-2']"));
	}

	public void searchBookAndClick(String bookName) {

		uiCF.clickElementAfterWaitingForVisibility(ProfilePage.getGoToStoreButton());
		
		BaseTest.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		e = uiCF.clickElementAfterWaitingForVisibility(BooksPage.getSearchBox());
		e.sendKeys(bookName);
		
		BooksPage.getBookNameLink(bookName).click();

	}

}
