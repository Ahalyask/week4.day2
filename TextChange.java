package week4.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TextChange {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/TextChange.html ");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement btn = driver.findElement(By.id("btn"));
		String text = driver.findElement(By.id("btn")).getText();
		System.out.println(text);
		wait.until(ExpectedConditions.textToBePresentInElement(btn, "Click ME!"));
		btn.click();
		String text2 = driver.switchTo().alert().getText();
		System.out.println(text2);
		driver.switchTo().alert().accept();

	}

}
