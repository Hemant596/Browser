package Browserr;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Counterr extends LaunchBrowser {

	public static void main(String[] args) throws InterruptedException  {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get("https://magic-ce-projects.s3.amazonaws.com/Content_3001-HMH-Go-Math-iTools-Flash-to-HTML-Conversion/counters/2021-08-03_10-27-15/index.html");
	
		
		
//		driver.findElement(By.cssSelector("#tab_0_3")).click();
//		Thread.sleep(3000);
//		WebElement th = driver.findElement(By.xpath("//*[contains(text(),'1,000')]"));
//		WebElement hn =driver.findElement(By.xpath("//*[contains(text(),'100')]"));
//		WebElement tn =driver.findElement(By.xpath("//*[contains(text(),'10')]"));
//		WebElement on =driver.findElement(By.xpath("//*[contains(text(),'1')]"));
//		WebElement thc = driver.findElement(By.xpath("(//*[@class='separator-wrapper']//div)[1]"));
//		WebElement hnc =driver.findElement(By.xpath("(//*[@class='separator-wrapper']//div)[2]"));
//		WebElement tnc =driver.findElement(By.xpath("(//*[@class='separator-wrapper']//div)[3]"));
//		WebElement onc =driver.findElement(By.xpath("//*[@class='separator-wrapper']"));
//		Thread.sleep(8000);
//		thc.click();
		
//		for(int i=0;i<10;i++) {
//			th.click();
//			Thread.sleep(2000);
//			thc.click();
//		}
//		Thread.sleep(3000);
//		
//		
//		for(int i=0;i<10;i++) {
//			hn.click();
//			Thread.sleep(2000);
//			hnc.click();
//		}
//		Thread.sleep(3000);
//		
//		for(int i=0;i<10;i++) {
//			tn.click();
//			Thread.sleep(2000);
//			tnc.click();
//		}
//		
		Thread.sleep(3000);
		WebElement work =driver.findElement(By.cssSelector(".wrapper.false>div[class='workmate-area main-play-area ui-droppable']"));
		work.click();
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		action.moveToElement(work, 5, 5).build().perform();
		
		Thread.sleep(3000);
		action.click();
		
		
	}

}
