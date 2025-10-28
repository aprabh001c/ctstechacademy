package pom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class RegistrationPage {
	private RemoteWebDriver driver;

	public RegistrationPage(RemoteWebDriver driver) {
		this.driver = driver;
	}

	public void waitRegistration() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("FirstName"))));

	}

	public void CompleteRegistration(String gender, String fName, String lName, String emailId, String password,
			String confPassword) {
		By male = By.id("gender-male");
		By female = By.id("gender-female");

		By fN = By.id("FirstName");
		By lN = By.id("LastName");
		By email = By.id("Email");
		By pwd = By.id("Password");
		By cPwd = By.id("ConfirmPassword");
		By register = By.id("register-button");

		if (gender.equalsIgnoreCase("male"))
			driver.findElement(male).click();
		else {
			driver.findElement(female).click();
		}
		driver.findElement(fN).sendKeys(fName);
		driver.findElement(lN).sendKeys(lName);
		driver.findElement(email).sendKeys(emailId);
		driver.findElement(pwd).sendKeys(password);
		driver.findElement(cPwd).sendKeys(confPassword);

		driver.findElement(register).click();

	}

	public void verifyRegistration() {
		By regSuccess = By.xpath("//*[@class='result']");
//		System.out.println(driver.findElement(regSuccess).getText());
		String successText = "Your registration completed";
		Assert.assertEquals(driver.findElement(regSuccess).getText(), successText);

	}

}
