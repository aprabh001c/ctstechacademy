package utils;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverUtils {

	private static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();
	public static void setDriver(RemoteWebDriver dr) {
		driver.set(dr);
	}

	public static RemoteWebDriver getDriver() {
		if (driver.get() == null) {
			RemoteWebDriver dr = createWebDriver("firefox");
			setDriver(dr);
			return dr;
		} else {
			return driver.get();
		}
	}

	public static void closeDriver() {
		if (driver.get() != null) {
			driver.get().quit();
			driver.remove(); 
		}
	}

	private static RemoteWebDriver createWebDriver(String browser) {
		RemoteWebDriver dr = null;
		if (browser.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", "./resource/chromedriver.exe");//
			dr = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			dr = new FirefoxDriver(options);

		}
		return (dr);
	}

}
