package Browserr;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotFirstTest  {
	@Test
	public void signup() throws InterruptedException, IOException {
		
		Date date = new Date();
		
		String screenshot = date.toString().replace(" ", "-").replace(":", "-");
//		LaunchBrowser bro = new LaunchBrowser();
//		bro.boom();
		WebDriverManager.chromedriver().setup();
		
		
		ChromeOptions headless = new ChromeOptions();
		headless.setHeadless(true);
		ChromeDriver driver=new ChromeDriver(headless);
		
		//ChromeOptions headless = new ChromeOptions();
//		headless.addArguments("window-size=1400,800");
//		headless.addArguments("headless");
//		ChromeDriver driver=new ChromeDriver(headless);
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.amazon.com/");	
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(".//screenshot//" + screenshot + ".jpg"));
//		<dependency>
//		<groupId>commons-io</groupId>
//		<artifactId>commons-io</artifactId>
//		<version>2.10.0</version>
//	</dependency>
		

	}

	@Test
	public static void draganddrop() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		  ChromeDriver driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.get("https://www.seleniumeasy.com/test/drag-and-drop-demo.html");
		  WebElement drag1 = driver.findElement(By.xpath("//*[contains(text(),'Draggable 1')]"));
		  WebElement drag2 = driver.findElement(By.xpath("//*[contains(text(),'Draggable 2')]"));
		  WebElement drag3 = driver.findElement(By.xpath("//*[contains(text(),'Draggable 3')]"));
		  WebElement drag4 = driver.findElement(By.xpath("//*[contains(text(),'Draggable 4')]"));
		  WebElement drop = driver.findElement(By.id("mydropzone"));
		  Thread.sleep(3000);
		  Actions action = new Actions(driver);
		  action.clickAndHold(drag1)
		  .moveToElement(drop)
		  .release()
		  .build()
		  .perform();
		  
		  driver.close();
	  }
}
