package week4.day2;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ErailUnique {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://erail.in");
		driver.manage().window().maximize();
		
		WebElement from = driver.findElement(By.id("txtStationFrom"));
		from.clear();
		from.sendKeys("MS");
		from.sendKeys(Keys.TAB);	
		WebElement to = driver.findElement(By.id("txtStationTo"));
		to.clear();
		to.sendKeys("MDU");
		to.sendKeys(Keys.TAB);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='chkSelectDateOnly']")).click();
		
		Thread.sleep(5000);
		List<WebElement> namelist =driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr"));

		int rowcount = namelist.size();
		System.out.println("row count"+rowcount);
		
		List<String> trainnames = new ArrayList<String>();
		for(int i=1; i<rowcount;i++) {		
			String names = driver.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr["+i+"]/td[2]/a")).getText();
			trainnames.add(names);
							
			}
		System.out.println("number of names in list - "+namelist.size());
		
		Set<String> nameset = new LinkedHashSet<String>(trainnames);
		System.out.println("number os names in setlist-"+nameset.size());
		if(namelist.size() ==nameset.size()) {
			System.out.println("count is same");
		
		}else {
			System.out.println("count is different");
		}
		
		
		

	}

}
