package Browserr;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class ScreenshotPractice {
	@Test
	public void screenshot() throws IOException {
		
		Date date = new Date();
		
		String screenBydate =date.toString().replace(" ", "-").replace(":", "-");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.google.com/");
		File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scr, new File(".//Screens//" + screenBydate + ".png"));
		//FileUtils.copyFile(screenshotFile, new File(".//screenshot//" + screenshot + ".png"));
		driver.close();
		

	}

}
