package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenCart_Login_Page {

	
	public WebDriver driver;
	
	public OpenCart_Login_Page(WebDriver dname) {
		this.driver=dname;
	
	PageFactory.initElements(driver, this);
	
	}
	
	
	
	@FindBy(xpath = "//*[@name='email']")
	private WebElement useremail;
	
	
	public WebElement getUseremail() {
		return useremail;
	}

	public WebElement getUserpassword() {
		return userpassword;
	}

	public WebElement getSubmit() {
		return submit;
	}

	@FindBy(xpath = "//*[@name='password']")
	private WebElement userpassword;
	
	@FindBy(xpath = "(//*[@type='submit'])[1]")
	private WebElement submit;
	
	
}




