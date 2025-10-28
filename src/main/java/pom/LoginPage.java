package pom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {
	private RemoteWebDriver driver;

	public LoginPage(RemoteWebDriver driver) {
		this.driver = driver;
	}

	public void loginwait() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("Email"))));
	}

	public void login(String userName, String pwd) {
		loginwait();
		By uN = By.id("Email");
		By password = By.id("Password");
		By login = By.xpath("//*[contains(@class,'login-button')]");

		driver.findElement(uN).sendKeys(userName);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(login).click();

	}

	public void verifyLogin(String userName) {
		By emailid = By.xpath("//*[@class='account']");
		String loginEmail = driver.findElement(emailid).getText();
		Assert.assertEquals(loginEmail, userName);
	}
}
