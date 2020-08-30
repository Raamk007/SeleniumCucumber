  package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver pageDriver;
	
	public LoginPage(WebDriver ldriver) {
		
		pageDriver = ldriver;
		PageFactory.initElements(ldriver,this);
	}
	
	@FindBy(id="Email")
	@CacheLookup
	WebElement loginEmail;
	
	@FindBy(id="Password")
	@CacheLookup
	WebElement loginPassword;
	
	@FindBy(xpath ="//input[@value='Log in']")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(linkText ="Logout")
	@CacheLookup
	WebElement lnkLogout;
	
	public void setLoginEmail(String email) {
		loginEmail.clear();
		loginEmail.sendKeys(email);
	}
	
	public void setPassword(String password) {
		loginPassword.clear();
		loginPassword.sendKeys(password);
	}
	
	public void clickLoginBtn() {
		btnLogin.click();
	}
	
	public void clickLogout() {
		lnkLogout.click();
	}

}
