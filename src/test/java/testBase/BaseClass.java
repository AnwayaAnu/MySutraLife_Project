package testBase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.*;
import org.testng.annotations.BeforeMethod;

import com.beust.jcommander.Parameter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;

public class BaseClass 
{
	public static WebDriver driver;
	public ResourceBundle rb;
	public Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String br)
	{
		logger = LogManager.getLogger(this.getClass());
		rb = ResourceBundle.getBundle("config");
		if(br.equals("chrome")) 
		{
		driver = new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else
		{
			driver = new SafariDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://nguat.mysutra.life/user/login");
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.close();
	}
	
	
	public String randmstring()
	{
		String randstr = RandomStringUtils.randomAlphabetic(6);
		return randstr;
	}
	
	public String randnos()
	{
		String randnos = RandomStringUtils.randomNumeric(6);
		return randnos;
	}
	
	public String captureScreen(String tname) throws IOException
	{
		Date dt = new Date();
		SimpleDateFormat sp = new SimpleDateFormat();
		String timestamp = sp.format(dt);
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		String destination = System.getProperty("user.dir")+"/screenshots/"+"_"+tname+"_"+timestamp+".png";
		
		File dest = new File(destination);
		
		FileUtils.copyFile(source, dest);
		
		return destination;
		
	}
}
