package Browserr;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownHandle {
	static WebDriver driver;
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver  = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.orangehrm.com/contact-sales/");
		By noofemp =By.xpath("//*[@name='NoOfEmployees']");
		By country = By.xpath("//*[@name='Country']");
		//selectmonth(open, "Wednesday");
		selectDropDownValue(noofemp, "value", "76 - 100");
		selectDropDownValue(country, "value", "India");
		
	}

	public static void  selectDropDownValue(By locator, String type, String value) {
		
		Select select = new Select(locate(locator));
		
		switch (type) {
		case "index":
			select.selectByIndex((Integer.parseInt(value)));
			break;
			
		case "value":
			select.selectByValue(value);
			break;
			
		case "visibletext":
			select.selectByVisibleText(value);
			break;

		default:
			System.out.println("Please pass correct criteria...");
			break;
		}
	}
	
	public static WebElement locate(By locator) {
		return driver.findElement(locator);
		
	}
	public static void selectmonth(By locator, String value) {
		Select select =new Select(locate(locator));
		select.selectByValue(value);
	}
}
