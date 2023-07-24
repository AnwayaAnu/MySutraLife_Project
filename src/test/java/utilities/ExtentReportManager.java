package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManager implements ITestListener
{
	public ExtentSparkReporter sparkreporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	
	
	public void onStart(ITestContext context)
	{
		sparkreporter = new ExtentSparkReporter("/Users/anwaya/eclipse-workspace/MySutra_Life/reports/reports.html");
		

		sparkreporter.config().setDocumentTitle("Automation log");
		sparkreporter.config().setReportName("Functional Testing");
		sparkreporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkreporter);
		
		extent.setSystemInfo("Computer name", "localhost");
		extent.setSystemInfo("Testset name", "Anwaya");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Os name", "Mac OS");
		extent.setSystemInfo("Browsers", "Firefox, Chrome");
		

		
	}
	public void onTestSuccess(ITestResult result)
	{
		test = extent.createTest(result.getName());
		test.log(Status.PASS, "The test passed is : "+result.getName());
	}
	
	public void onTestSkipped(ITestResult result)
	{
		test = extent.createTest(result.getName());
		test.log(Status.SKIP, result.getName()+" "+ result.getThrowable().getMessage());
	}
	
	public void onTestFailure(ITestResult result)
	{
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "test failed is: "+result.getName());
		test.log(Status.FAIL, "test failed because of: "+result.getThrowable().getMessage());
		
		try
		{
		
		String imgpath = new BaseClass().captureScreen(result.getName());
		
		test.addScreenCaptureFromPath(imgpath);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public void onFinish(ITestContext context)
	{
		extent.flush();
	}
}
