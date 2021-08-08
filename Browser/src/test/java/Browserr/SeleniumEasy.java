package Browserr;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumEasy {

	@Test
	public void managewindow() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("https://www.seleniumeasy.com/test/window-popup-modal-demo.html");
		driver.findElement(By.xpath("//*[contains(text(),'Follow On Twitter')] ")).click();
		Set<String> win =driver.getWindowHandles();
		String man =driver.getWindowHandle();
		//System.out.println(win);
		int i=1;
		for(String po :win) {
			
			if(i==2) {
				WebDriver nam =driver.switchTo().window(po);
				
			}
		i++;
		}
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@name='session[username_or_email]']")).sendKeys("hemant@gmail.com");
		driver.switchTo().window(man);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[contains(text(),'  Like us On Facebook ')] ")).click();
	}
}
