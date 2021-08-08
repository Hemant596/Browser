package Browserr;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderPract {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get("https://www.goibibo.com/");
		By dcal =By.cssSelector("#departureCalendar");
		By rcal =By.cssSelector("#returnCalendar");
		By curdate =By.cssSelector(".DayPicker-Caption>div");
		locator(dcal).click();

		dateselect("25", "December", "2022");
		Thread.sleep(3000);

		locator(rcal).click();

		dateselect("25", "April", "2023");

	}

	public static WebElement locator(By locator) {
		return driver.findElement(locator);

	}

	public static String[] curdate(String curdate) {
		return curdate.split(" ");
	}


	public static void dateselect(String exdate, String exmonth, String exyear) {

		if(exmonth.equals("Feburary") && Integer.parseInt(exdate)>29) {
			System.out.println("Wrong month and date"+exmonth+ "-"+ exdate);
		}
		if(Integer.parseInt(exdate)>31) {
			System.out.println("wrong date :"+exdate);
		}



		String curdate = driver.findElement(By.cssSelector(".DayPicker-Caption>div")).getText();
		while(!(curdate(curdate)[0].equals(exmonth) && curdate(curdate)[1].equals(exyear))){
			driver.findElement(By.xpath("//*[@aria-label='Next Month']")).click();
			curdate = driver.findElement(By.cssSelector(".DayPicker-Caption>div")).getText();
		}
		driver.findElement(By.xpath("//*[text()='"+exdate+"']")).click();

	}

}
