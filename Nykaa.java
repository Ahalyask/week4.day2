package week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		
		Actions builder = new Actions(driver);
		
		WebElement brand = driver.findElement(By.xpath("//li/a[text()='brands']"));
		builder.moveToElement(brand).perform();
		WebElement lorealParis = driver.findElement(By.xpath("//ul[@class='l-vertical-list']/li[5]"));
		builder.click(lorealParis).perform();
		
		String title = driver.getTitle();
		System.out.println(title);
		driver.findElement(By.xpath("//button[@class=' css-p2rfnw']")).click();
		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
		driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
		String shampootext = driver.findElement(By.xpath("//span[text()='Shampoo']")).getText();
		if(shampootext.contains("Shampoo")) {
			System.out.println("correct filter applied");
		}else {
			System.out.println("wrong filter applied");
		}
		driver.findElement(By.xpath("//div[text()=\"L'Oreal Paris Colour Protect Shampoo\"]")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> wlist = new ArrayList<String>(windowHandles);
		
		driver.switchTo().window(wlist.get(1));
		
		WebElement size = driver.findElement(By.xpath("//select[@class='css-1c1c89s']"));
		Select select = new Select(size);
		select.selectByVisibleText("175ml");
		
		String price = driver.findElement(By.xpath("//span[@class='css-12x6n3h']")).getText();
		System.out.println("price of shampoo is -"+price);
		driver.findElement(By.xpath("//span[text()='ADD TO BAG']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@class='css-5s18zx eoh7kvv0']")).click();
		Thread.sleep(5000);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='css-acpm4k']")));
		Thread.sleep(3000);
		String grandTotal = driver.findElement(By.xpath("//div[@class='value medium-strong']")).getText();
		System.out.println("grand total is -"+grandTotal);
		driver.findElement(By.xpath("//span[text()='PROCEED']")).click();
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//button[text()='CONTINUE AS GUEST']")).click();
		String grandtotal2 = driver.findElement(By.xpath("//div[@class='payment-details-tbl grand-total-cell prl20']//span")).getText();
		System.out.println("grand total 2 is -"+grandtotal2);
		if(grandTotal.contains(grandtotal2)) {
			System.out.println("price is same");
		}else {
			System.out.println("pricr is  different");
		}
		driver.quit();

	}

}
