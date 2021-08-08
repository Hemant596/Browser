package Browserr;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProvid {

	//@Test(dataProvider = "create")
	@Test
	@Parameters({"username","password"})
	public void login(String username, String password) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver  = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://ui.cogmento.com/");
		driver.findElement(By.name("email")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
		Thread.sleep(3000);
		WebElement login = driver.findElement(By.xpath("//*[contains(text(),'Login') and @class='ui fluid large blue submit button']"));
		login.click();



	}
	@DataProvider(name= "create")
	public Object[][] set1(){
		return new Object[][] {
			{"yash@gmail.com", "jbjhsfd"},
			{"bhawna@gmail.com", "jbjghsfd"},
			{"hemant.hs828@gmail.com", "2@Discus2@"},
			{"bhawnda@gmail.com", "jbdfjghsfd"},
			{"hemant.hs828@gmail.com", "jbjghdsfd"},

		};
	}

}
