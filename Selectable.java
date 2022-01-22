package week4.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selectable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/selectable/");
		driver.manage().window().maximize();
		driver.switchTo().frame(0);
		WebElement ele1 = driver.findElement(By.xpath("//ol[@id='selectable']/li[1]"));
		WebElement ele3 = driver.findElement(By.xpath("//ol[@id='selectable']/li[3]"));
		WebElement ele4 = driver.findElement(By.xpath("//ol[@id='selectable']/li[4]"));
		WebElement ele5 = driver.findElement(By.xpath("//ol[@id='selectable']/li[5]"));
		Actions builder = new Actions(driver);
		builder.keyDown(Keys.CONTROL).click(ele1).click(ele3).click(ele4).click(ele5).perform();
		
	}

}
