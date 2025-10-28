package testcases;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pom.LoginPage;
import pom.RegistrationPage;
import pom.SearchPage;
import utils.DriverUtils;

public class TestCases extends DriverUtils {
	private RemoteWebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		driver = getDriver();
	}

	@AfterMethod
	public void afterMethod() {
		closeDriver();
	}

//	@Test(testName = "Registration", priority = 1)
//	public void startRegistration(Method method) throws InterruptedException {
//		RegistrationPage rp = new RegistrationPage(driver);
//		driver.get("https://demowebshop.tricentis.com/");
//		driver.manage().window().maximize();
//		driver.findElement(By.xpath("//*[@class='ico-register']")).click();
//		rp.waitRegistration();
//		rp.CompleteRegistration("male", "217721Ashok", "217721Prabhu", "217721Ashok@gmail.com", "Ashok1", "Ashok1");
//		rp.verifyRegistration();
//		Thread.sleep(10000);
//	}

	@Test(testName = "Login", priority = 2, dataProvider = "loginData")
	public void login(String userName, String password) {
		System.out.println(userName);
		System.out.println(password);
		LoginPage lp = new LoginPage(driver);
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@class='ico-login']")).click();
		lp.login(userName, password);
		lp.verifyLogin(userName);
	}

	@Test(testName = "Login", priority = 3, dataProvider = "loginData")
	public void loginSearch(String userName, String password) throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		SearchPage sp = new SearchPage(driver);
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@class='ico-login']")).click();
		lp.login(userName, password);
		lp.verifyLogin(userName);

		sp.clickBookCategoryAndSelectBook("book");
		sp.clickBook("Computing and Internet");
	}

	@DataProvider(name = "loginData")
	public Object loginData() {
		return new Object[][] { { "Ashok217721@gmail.com", "Ashok1" }, };
	}

}
