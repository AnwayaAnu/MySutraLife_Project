package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage
{
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	// Finding webelements
	
	@FindBy(xpath="//input[@name='username']") WebElement txt_username;
	@FindBy(xpath="//input[@type='password']") WebElement txt_password;
	@FindBy(xpath="//button[normalize-space()='Login To Life']") WebElement btn_login;
	
	
	// Actions
	
	public void setUsername(String uname)
	{
		txt_username.sendKeys(uname);
	}
	
	public void setPassword(String pw)
	{
		txt_password.sendKeys(pw);
	}
	
	public void clickLogin()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", btn_login);
		
		
	}
	
	
}
