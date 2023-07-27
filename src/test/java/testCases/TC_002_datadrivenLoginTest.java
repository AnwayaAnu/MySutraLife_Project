package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.MyCorePage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_002_datadrivenLoginTest extends BaseClass
{
	@Test(dataProvider="login", dataProviderClass=DataProviders.class)
	public void LoginTest(String email, String pw) throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		lp.clearUsername();
		lp.setUsername(email);
		lp.clearPassword();
		lp.setPassword(pw);
		lp.clickLogin();
		
		MyCorePage mcp = new MyCorePage(driver);
		
		Assert.assertEquals(mcp.isProfileImagePresent(), true);
		
		mcp.clickPRofileArrow();
		mcp.clickLogout();
		
		Thread.sleep(3000);
	}
}
