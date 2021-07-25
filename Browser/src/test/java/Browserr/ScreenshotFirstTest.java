package Browserr;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotFirstTest {
	@Test
	public void signup() throws InterruptedException, IOException {
		
		Date date = new Date();
		
		String screenshot = date.toString().replace(" ", "-").replace(":", "-");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.amazon.com/");	
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(".//screenshot//" + screenshot + ".png"));
//		<dependency>
//		<groupId>commons-io</groupId>
//		<artifactId>commons-io</artifactId>
//		<version>2.10.0</version>
//	</dependency>
		

	}

}
