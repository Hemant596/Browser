package Browserr;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.swing.text.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utility.propertiesUtility;
import io.github.bonigarcia.wdm.WebDriverManager;


public class ExplicitWait extends LaunchBrowser {
	WebDriver driver;
	Utilities propertiesUtility;


	@BeforeMethod
	public void launchBrowser() throws IOException {
		//WebDriverManager.chromedriver().setup();
		
		
//		driver = new ChromeDriver();
//		propertiesUtility = new Utilities();
		
		
//		Properties prop= new Properties();
//		FileInputStream ip = new FileInputStream("C:\\Users\\sharma.hemant\\git\\Browser\\Browser\\config.properties");
//		prop.load(ip);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://ui.cogmento.com/");

	}
	
//	@Test(dataProvider = "create")
//	public void loginFree(String username, String password) throws InterruptedException {
//		driver.findElement(By.name("email")).sendKeys(username);
//		driver.findElement(By.name("password")).sendKeys(password);
//		Thread.sleep(3000);
//		WebElement login = driver.findElement(By.xpath("//*[contains(text(),'Login') and @class='ui fluid large blue submit button']"));
//		login.click();
//		
//		
//	}
	
	@Test
	public void propertiesFile() throws IOException, InterruptedException {
		Properties prop= new Properties();
		FileInputStream ip = new FileInputStream("C:\\Users\\sharma.hemant\\git\\Browser\\Browser\\config.properties");
		prop.load(ip);
//		propertiesUtility = new Utilities();
		driver.findElement(By.name("email")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.name("password")).sendKeys(prop.getProperty("password"));
		Thread.sleep(3000);
		WebElement login = driver.findElement(By.xpath("//*[contains(text(),'Login') and @class='ui fluid large blue submit button']"));
		login.click();
		WebDriverWait wait =new WebDriverWait(driver, 10);
		WebElement sizee = driver.findElement(By.xpath("(//*[@id='nav-cart'])[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@id='nav-cart'])[1]")));
	}

	
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
	
	
//	@Test(expectedExceptions = ArithmeticException.class)
//
//	public void Test1() {
//
//		System.out.println("First test case is passed");
//	
//		
//		int i = 9/0;
//
//	}
	
//	@Test(timeOut = 5)
//	public void loopHole() {
//		int i=1;
//		int j=1;
//		
//		for ( i=1;i>=j;i++) {
//			System.out.println("he");
//		}
//	}
//	@Test()
//	public void Test2() {
//
//		System.out.println("Second test case is passed");
//
//	}
//
//	@Test()
//	public void Test3() {
//
//		System.out.println("Third test case is passed");
//
//	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
