package Browserr;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import javax.naming.TimeLimitExceededException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonPractice extends LaunchBrowser{
	ChromeDriver driver;

	@BeforeMethod
	public void HomePage() throws InterruptedException {
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
		LaunchBrowser bro = new LaunchBrowser();
		bro.boom();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("https://www.amazon.com/");
	}

	@Test /* (priority = 1, groups = "Amazon" ,invocationCount = 5 ) */
	public void size() throws InterruptedException {

		driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("shoes");
		driver.findElement(By.cssSelector("#nav-search-submit-button")).click();
		driver.findElement(By.cssSelector(
				"#search > div.s-desktop-width-max.s-desktop-content.s-opposite-dir.sg-row > div.s-matching-dir.sg-col-16-of-20.sg-col.sg-col-8-of-12.sg-col-12-of-16 > div > span:nth-child(4) > div.s-main-slot.s-result-list.s-search-results.sg-row > div:nth-child(3) > div > span > div > div > div > div > div > div:nth-child(1) > h2 > a"))
				.click();
		WebElement size = driver.findElement(By.cssSelector("select[name='dropdown_selected_size_name']"));
		Select si = new Select(size);
		si.selectByValue("3,B07QJ5M2X6");
		Thread.sleep(2000);

	}

	@Test(priority = 2, groups = "Amazon")
	public void qntt() throws InterruptedException {
		driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("shoes");
		driver.findElement(By.cssSelector("#nav-search-submit-button")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(
				"#search > div.s-desktop-width-max.s-desktop-content.s-opposite-dir.sg-row > div.s-matching-dir.sg-col-16-of-20.sg-col.sg-col-8-of-12.sg-col-12-of-16 > div > span:nth-child(4) > div.s-main-slot.s-result-list.s-search-results.sg-row > div:nth-child(3) > div > span > div > div > div > div > div > div:nth-child(1) > h2 > a"))
				.click();
		WebElement qnt = driver.findElement(By.cssSelector("select[name='quantity']"));
		Select sii = new Select(qnt);
		sii.selectByValue("7");
	}

	@Test(priority = 3, groups = "Product") /*
											 * ,dependsOnMethods = "qntt",expectedExceptions =
											 * NoSuchElemenException.class
											 */
	public void hoverImage() throws InterruptedException {
		driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("shoes");
		driver.findElement(By.cssSelector("#nav-search-submit-button")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(
				"#search > div.s-desktop-width-max.s-desktop-content.s-opposite-dir.sg-row > div.s-matching-dir.sg-col-16-of-20.sg-col.sg-col-8-of-12.sg-col-12-of-16 > div > span:nth-child(4) > div.s-main-slot.s-result-list.s-search-results.sg-row > div:nth-child(3) > div > span > div > div > div > div > div > div:nth-child(1) > h2 > a"))
				.click();
		Actions action = new Actions(driver);
		WebElement hover = driver.findElement(By.cssSelector("#imgTagWrapperId"));
		action.moveToElement(hover).build().perform();
	}

	@Test(priority = 4, groups = "Product")
	public void addToList() throws InterruptedException {
		driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("shoes");
		driver.findElement(By.cssSelector("#nav-search-submit-button")).click();
		Thread.sleep(4000);
		driver.findElement(By.cssSelector(
				"#search > div.s-desktop-width-max.s-desktop-content.s-opposite-dir.sg-row > div.s-matching-dir.sg-col-16-of-20.sg-col.sg-col-8-of-12.sg-col-12-of-16 > div > span:nth-child(4) > div.s-main-slot.s-result-list.s-search-results.sg-row > div:nth-child(3) > div > span > div > div > div > div > div > div:nth-child(1) > h2 > a"))
				.click();
		driver.findElement(By.cssSelector("#wishListMainButton>span>a")).click();
		driver.findElement(By.cssSelector("#ap_email")).sendKeys("hemant.hs828@gmail.com");
		driver.findElement(By.cssSelector(".a-section>[class='a-button a-button-span12 a-button-primary']")).click();
		driver.findElement(By.cssSelector("#ap_password")).sendKeys("2@discus2@");
		driver.findElement(By.cssSelector("#signInSubmit")).click();
	}

	@Test(priority = 5, groups = "Product")
	public void forgetPassword() throws InterruptedException {
		driver.findElement(By.cssSelector(
				"#nav-tools>a+a[class='nav-a nav-a-2   nav-progressive-attribute'][id='nav-link-accountList']"))
				.click();
		driver.findElement(By.cssSelector("#ap_email")).sendKeys("hemant.hs828@gmail.com");
		driver.findElement(By.cssSelector(".a-section>[class='a-button a-button-span12 a-button-primary']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#auth-fpp-link-bottom")).click();
		driver.findElement(By.cssSelector(".a-button-input")).click();
	}

//	@DataProvider(name="Username")
//	public Object[][] dataSet1(){
//		return new Object[][] {
//			{
//				
//			}
//		};
//	}

//	@DataProvider(name = "create")
//	public Object[][] dataSet1(){
//		return new Object[][] {
//			//{"yash@gmail.com", "jbjhsfd"},
//			{"bhawna@gmail.com", "jbjghsfd"},
//			{"hemant.hs828@gmail.com", "2@Discus2@"},
//			{"bhawnda@gmail.com", "jbdfjghsfd"},
//			{"hemant.hs828@gmail.com", "jbjghdsfd"},
//		};
//		
//	}

	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}

}
