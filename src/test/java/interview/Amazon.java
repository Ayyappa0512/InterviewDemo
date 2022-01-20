package interview;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Amazon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "G://Selenium//Drivers//geckodriver-v0.29.1-win64//geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.amazon.in/");
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Ball");
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(1000 ,0)");
		
		driver.findElement(By.xpath("//div[@class='a-section aok-relative s-image-square-aspect']")).click();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		Set<String> windhandle= driver.getWindowHandles();
		
		Iterator it = windhandle.iterator();
		
		String parent =(String) it.next();
		String child =(String) it.next();
		
		driver.switchTo().window(child);
		driver.findElement(By.id("add-to-cart-button")).click();
	}
	 

}
