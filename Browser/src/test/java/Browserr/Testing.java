package Browserr;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testing  {

	WebDriver driver;
	@BeforeMethod
	public void HomePage() throws InterruptedException {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		//	LaunchBrowser bro = new LaunchBrowser();
		//	bro.boom();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("https://www.amazon.com/");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement sizee = driver.findElement(By.xpath("(//*[@id='nav-cart'])[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@id='nav-cart'])[1]")));
	}

	@Test /* (priority=1,groups="Amazon",invocationCount = 5) */
	public void size() throws InterruptedException {

		driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("shoes");
		driver.findElement(By.cssSelector("#nav-search-submit-button")).click();
		driver.findElement(By.cssSelector("#search > div.s-desktop-width-max.s-desktop-content.s-opposite-dir.sg-row > div.s-matching-dir.sg-col-16-of-20.sg-col.sg-col-8-of-12.sg-col-12-of-16 > div > span:nth-child(4) > div.s-main-slot.s-result-list.s-search-results.sg-row > div:nth-child(3) > div > span > div > div > div > div > div > div:nth-child(1) > h2 > a")).click();
		WebElement size = driver.findElement(By.cssSelector("select[name='dropdown_selected_size_name']"));
		Select si = new Select(size);
		si.selectByValue("3,B07QJ5M2X6");
		Thread.sleep(2000); 

	}
}
