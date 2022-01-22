package week4.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Disapper {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/disapper.html");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement btn = driver.findElement(By.id("btn"));
		wait.until(ExpectedConditions.invisibilityOf(btn));
		
		String message = driver.findElement(By.xpath("//div[@class='disappear']//strong")).getText();
		System.out.println(message);

	}

}
