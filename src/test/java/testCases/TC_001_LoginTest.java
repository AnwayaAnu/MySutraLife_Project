package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.MyCorePage;
import testBase.BaseClass;

public class TC_001_LoginTest extends BaseClass
{
	@Test
	public void loginTest()
	{
		logger.info("Execution is starting......");
		
		LoginPage lp = new LoginPage(driver);
		
		logger.info("Providing the user credentials");
		
		lp.setUsername(rb.getString("email"));
		lp.setPassword(rb.getString("password"));
		
		logger.info("login to the account....");
		
		lp.clickLogin();
		
		MyCorePage mcp = new MyCorePage(driver);
		logger.info("Validating the user login.....");
		
		Assert.assertEquals(mcp.isProfileImagePresent(), true);
		
		logger.info("User logged into the my sutra application...");
		
	}
}
