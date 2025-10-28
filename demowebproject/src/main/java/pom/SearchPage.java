package pom;

import static org.testng.Assert.assertFalse;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {
	RemoteWebDriver driver;

	public SearchPage(RemoteWebDriver driver) {
		this.driver = driver;
	}

	public void clickBookCategoryAndSelectBook(String category) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement firstItem = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='list']/li[1]/a")));
		By categories = By.xpath("//*[@class='list']/*[@class='inactive']/a");

		List<WebElement> elements = driver.findElements(categories);
		for (int i = 0; i < elements.size(); i++) {
			if (elements.get(i).getText().trim().toLowerCase().contains(category)) {
				driver.findElement(By.xpath("//ul[@class='list']/li[" + i + 1 + "]/a")).click();
//				((JavascriptExecutor) driver).executeScript("arguments[0].click();", e);
				break;
			}
		}

	}

	public void clickBook(String bookName) {
		By bookTitles = By.xpath("//*[@class='product-item']//*[@class='product-title']");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement firstItem = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@class='product-item']//*[@class='product-title'][1]")));
		List<WebElement> elements = driver
				.findElements(By.xpath("//*[@class='product-item']//*[@class='product-title']"));

		for (int i = 0; i < elements.size(); i++) {
			WebElement e = driver.findElements(By.xpath("//*[@class='product-item']//*[@class='product-title']"))
					.get(i);
			if (e.getText().trim().equalsIgnoreCase(bookName)) {
				driver.findElement(By.xpath("//*[@class='product-item']//*[@class='product-title']["+i+1+"]")).click();
				break;
			}
		}

	}
}
