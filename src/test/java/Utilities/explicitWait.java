package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class explicitWait {

public WebDriver driver;

public explicitWait(WebDriver driver) {
	this.driver = driver;
}

public void waitForElement(WebElement element, long timeInSeconds) {
	
	WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
	wait.until(ExpectedConditions.visibilityOf(element));
}
}
