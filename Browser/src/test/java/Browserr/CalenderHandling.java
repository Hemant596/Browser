package Browserr;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderHandling {
	static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver  = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.goibibo.com/");
		driver.findElement(By.id("departureCalendar")).click();
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("DayPicker-wrapper")));
		dateselect("32","May","2022");
	}


	public static String[] getMonthYear(String curmonthyear) {
		return curmonthyear.split(" ");
	}


	public static void dateselect(String exdate, String exmonth, String exyear) {

		if(exmonth.equals("February")&& Integer.parseInt(exdate)>29) {

			System.out.println("wrong date :"+ exmonth + " - "+ exdate);
			return;
		}

		if(Integer.parseInt(exdate)>31) {
			System.out.println("wrong date :"+ exmonth + " - "+ exdate);
			return;
		}

		String curmonthyear = driver.findElement(By.xpath("//*[@class='DayPicker-Caption']")).getText();
		while(!(getMonthYear(curmonthyear)[0].equals(exmonth) 
				&&
				getMonthYear(curmonthyear)[1].equals(exyear))){
			driver.findElement(By.xpath("//*[@aria-label='Next Month']")).click();
			curmonthyear = driver.findElement(By.xpath("//*[@class='DayPicker-Caption']")).getText();
		}

		driver.findElement(By.xpath("//*[text()='"+exdate+"']")).click();
	}

}
