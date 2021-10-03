package Test_Runner;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.pom.Base_Class_Team;
import com.pom.Login_Page_Team;

public class Runner_Class extends Base_Class_Team{
	
	@Test(dataProvider = "Login")
	public void login(String username, String pass) throws Throwable {
		Logger log = Logger.getLogger("Test Login_Page");
		BasicConfigurator.configure();
		ExtentSparkReporter report = new ExtentSparkReporter("TestNG.html");
		ExtentReports rep = new ExtentReports();
		rep.attachReporter(report);
		ExtentTest test = rep.createTest("TestNG_Report");

		Login_Page_Team lp = new Login_Page_Team(driver);
		log.info("Launch Url");
		driver.get(pro.getProperty("website"));
		log.info("Click on Signin Button");
		clickOnElement(lp.getSignin());
		log.info("Enter Username");
		entervalue(lp.getEmail(), username);
		log.info("Enter Password");
		entervalue(lp.getPassword(), pass);
		log.info("Click on Signin");
		clickOnElement(lp.getClicksignin());
		screenshots("Anbu");
		rep.flush();
	}

	@DataProvider(name = "Login")
	public Object[][] getData() throws Throwable {

		return excelreadData();

	}
}
