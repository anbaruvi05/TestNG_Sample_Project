package com.pom;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

public class Base_Class_Team {

	public static Properties pro;

	public static WebDriver driver;

	@Parameters("browser")
	@BeforeMethod
	public WebDriver getsetup(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\ANBARUVI\\eclipse-workspace\\TestNG_Sample_Project\\Drivers\\newchromed.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\ANBARUVI\\eclipse-workspace\\TestNG_Sample_Project\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver",
					"C:\\Users\\ANBARUVI\\eclipse-workspace\\TestNG_Sample_Project\\Drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}else if(browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\Users\\ANBARUVI\\eclipse-workspace\\TestNG_Sample_Project\\Drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		return driver;

	}

	public void clickOnElement(WebElement element) {

		element.click();
	}

	public void entervalue(WebElement element, String value) {
		element.sendKeys(value);
	}

	public void screenshots(String name) throws Throwable {

		TakesScreenshot t = (TakesScreenshot) driver;
		File scr = t.getScreenshotAs(OutputType.FILE);
		File des = new File(
				"C:\\Users\\ANBARUVI\\eclipse-workspace\\TestNG_Sample_Project\\Screenshots\\" + name + ".png");
		FileUtils.copyFile(scr, des);

	}

	public Properties proFile() throws Exception {
		FileInputStream input = new FileInputStream(
				"C:\\Users\\ANBARUVI\\eclipse-workspace\\TestNG_Sample_Project\\User.properties");
		pro = new Properties();
		pro.load(input);

		return pro;

	}
	public static void threadSleep(long value) {
		threadSleep(value);
		
	}
	
	
	
	public Sheet excelfile(String filename, String sheetname) throws Throwable {
		FileInputStream excelinput = new FileInputStream(pro.getProperty("Excel"));
		Workbook workbook = new XSSFWorkbook(excelinput);
		Sheet sheet = workbook.getSheet("Sheet3");

		return sheet;
	}

	public Object[][] excelreadData() throws Throwable {

		pro = proFile();
		Sheet excelsheet = excelfile(pro.getProperty("Excel"), pro.getProperty("Sheet3"));
		Object[][] exceldata = new Object[excelsheet.getPhysicalNumberOfRows()][excelsheet.getRow(0)
				.getPhysicalNumberOfCells()];
		for (int i = 0; i < excelsheet.getPhysicalNumberOfRows(); i++) {
			Row row = excelsheet.getRow(i);
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				Cell cell = row.getCell(j);
				CellType type = cell.getCellType();

				if (type.equals(CellType.STRING)) {
					exceldata[i][j] = cell.getStringCellValue();
				} else if (type.equals(CellType.NUMERIC)) {
					exceldata[i][j] = cell.getNumericCellValue();
				}
			}
		}
		return exceldata;

	}
	
	@AfterMethod
	public void close() {

		driver.quit();
	}

}
