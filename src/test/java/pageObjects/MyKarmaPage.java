package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyKarmaPage extends BasePage
{
	public MyKarmaPage(WebDriver driver)
	{
		super(driver);
	}
	
	// Finding web elements
	
	@FindBy(xpath="//div[@class='fw-700']") WebElement lbl_Mykarma;
	@FindBy(xpath="//button[normalize-space()='Create Event']") WebElement btn_createEvent;
	
	
	// Actions
	
	public boolean isMyKarmaPage()
	{
		boolean stat = lbl_Mykarma.isDisplayed();
		return stat;
	}
	
	public void clickOnCreateEvent()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(btn_createEvent));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", btn_createEvent);
	}
}
