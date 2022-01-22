package week4.day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SortTable {
	

	public static void main(String[] args) throws InterruptedException {
		int flag=0;
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/sorttable.html");
		driver.manage().window().maximize();
		List<WebElement> nameList = driver.findElements(By.xpath("//table[@id='table_id']//td[2]"));
		int rowcount = nameList.size();
		System.out.println("count of names - "+rowcount);
		List<String> names = new ArrayList<String>();
		for (int i=1; i<rowcount+1; i++) {
			String text = driver.findElement(By.xpath("//table[@id='table_id']//tr["+i+"]/td[2]")).getText();
			names.add(text);
		}
		Collections.sort(names);
		System.out.println(names);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//th[text()='Name']")).click();
		Thread.sleep(3000);
		List<WebElement> nameList2 = driver.findElements(By.xpath("//table[@id='table_id']//td[2]"));
		int rowcount2 = nameList2.size();
		System.out.println("count of names 2- "+rowcount2);
		List<String> names2 = new LinkedList<String>();
		for (int i=1; i<rowcount2+1; i++) {
			String text2 = driver.findElement(By.xpath("//table[@id='table_id']//tr["+i+"]/td[2]")).getText();
			names2.add(text2);
		}
		System.out.println(names2);
		
				
		if(names.equals(names2) == true) {
			System.out.println("sorted successfully");
		}else {
			System.out.println("did not sort");
		}
	}

}
