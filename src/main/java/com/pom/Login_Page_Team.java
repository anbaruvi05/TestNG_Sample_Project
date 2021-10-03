package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page_Team {

	public WebDriver driver;

	public Login_Page_Team(WebDriver name) {
		driver = name;
		PageFactory.initElements(driver, this);

	}

	// Home Page Signin
	@FindBy(xpath = "//*[@title='Log in to your customer account']")
	private WebElement signin;
	
	public WebElement getSignin() {
		return signin;
	}
	public WebElement getEmail() {
		return email;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getClicksignin() {
		return clicksignin;
	}

	// Enter User_Name
	@FindBy(id = "email")
	private WebElement email;
	// Enter Password
	@FindBy(id = "passwd")
	private WebElement password;
	// Click on Signin Button
	@FindBy(id = "SubmitLogin")
	private WebElement clicksignin;

}
