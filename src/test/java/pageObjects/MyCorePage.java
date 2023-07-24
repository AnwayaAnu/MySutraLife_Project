package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyCorePage extends BasePage
{
	public MyCorePage(WebDriver driver)
	{
		super(driver);
	}
	
	// Finding webelements
	
	@FindBy(xpath="//img[@class='mw-100 lr-device-only el-device-only m-auto']") WebElement img_profile;
	@FindBy(xpath="//ul[@class='core menu-list']//li//a") List<WebElement> left_menuOptions;
	@FindBy(xpath="//img[@src='https://mslprodstorage.blob.core.windows.net/msl/icons/carat.png']") WebElement btn_profileArrow;
	@FindBy(xpath="//a[normalize-space()='Logout']") WebElement btn_logout;
	
	
	
	// Actions
	
	public boolean isProfileImagePresent()
	{
		boolean stat = img_profile.isDisplayed();
		return stat;
	}
	
	public void clickanyLeftMenu(String menu)
	{
		for(WebElement opt:left_menuOptions)
		{
			if(opt.getText().equals(menu))
			{
				opt.click();
			}
		}
	}
	
	public void clickPRofileArrow()
	{
		btn_profileArrow.click();
	}
	
	public void clickLogout()
	{
		btn_logout.click();
	}
}
