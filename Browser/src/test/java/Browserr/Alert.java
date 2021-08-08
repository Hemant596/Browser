package Browserr;

import java.awt.RenderingHints.Key;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alert {
	
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
//		By click = By.xpath("(//*[text()='Click me!'])[1]");
//		By clickdis = By.xpath("(//*[text()='Click me!'])[2]");
//		By clikk = By.xpath("//*[text()='Click for Prompt Box']");
//		locator(click).click();
//		Thread.sleep(3000);
//		org.openqa.selenium.Alert al = driver.switchTo().alert();
//		al.accept();
//		System.out.println(al.getText());
		
//		locator(clickdis).click();
//		Thread.sleep(3000);
//		org.openqa.selenium.Alert al = driver.switchTo().alert();
//		System.out.println(al.getText());
//		al.dismiss();
		
		
//		Actions act = new Actions(driver);
//		act.moveToElement(locator(clikk)).build().perform();
//		Thread.sleep(3000);
//		act.click();
		//driver.close();
		
		WebElement all = driver.findElement(By.cssSelector(".hm-icon.nav-sprite"));
		Actions act = new Actions(driver);
		act.moveToElement(all).build().perform();
		Thread.sleep(3000);
		act.contextClick().build().perform();
		//act.sendKeys(Keys.ENTER);
	}

	
	static WebElement locator(By locator) {
		return driver.findElement(locator);
	}
}
