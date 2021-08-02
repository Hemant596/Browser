package Browserr;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoSelenium {
	static  WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		launchBrowser();
		windowbtn();
	}

	public static void launchBrowser() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public static void switchtowindow() throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/window-popup-modal-demo.html");
		driver.findElement(By.xpath("(//*[@class='btn btn-primary followeasy'])[1]")).click();
		Set<String> noofwindow = driver.getWindowHandles();
		String mainwindow = driver.getWindowHandle();
		int i =1;
		for(String winName : noofwindow) {  
			if(i==2) {
				driver.switchTo().window(winName);
			}
			i=i+1;	
		}
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@name='session[username_or_email]']")).sendKeys("hemant@gmail.com");
		Thread.sleep(5000);
		driver.switchTo().window(mainwindow);
		driver.findElement(By.xpath("(//*[@class='btn btn-primary followeasy'])[2]")).click();
	}

	public static void datePicker() {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/bootstrap-date-picker-demo.html");
		driver.findElement(By.cssSelector(".input-group-addon>i")).click();
		List<WebElement> links = driver.findElements(By.cssSelector(".table-condensed>thead+tbody>tr"));
		System.out.println(links.size());
		for(int i =0;i<=links.size();i++) {
			System.out.println(links.get(i).getText());
			if(links.get(i).getText().contains("7")) {
				links.get(i).click();
			}
		}
	}

	public static void JqueryDatePicker() {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/jquery-date-picker-demo.html");
		driver.findElement(By.xpath("//*[@name='from']")).click();
	}

	public static void draganddrop() throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.seleniumeasy.com/test/drag-and-drop-demo.html");
		WebElement drag1 = driver.findElement(By.xpath("//*[contains(text(),'Draggable 1')]"));
		WebElement drag2 = driver.findElement(By.xpath("//*[contains(text(),'Draggable 2')]"));
		WebElement drag3 = driver.findElement(By.xpath("//*[contains(text(),'Draggable 3')]"));
		WebElement drag4 = driver.findElement(By.xpath("//*[contains(text(),'Draggable 4')]"));
		WebElement drop = driver.findElement(By.id("mydropzone"));
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		action.clickAndHold(drag1)
		.moveToElement(drop)
		.release()
		.build()
		.perform();

		driver.close();
		
	}

	public static void windowbtn() {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.navigate().to("https://www.amazon.com/");
		driver.navigate().back();
		
	}
	
	public static void gitcheck() {
		System.out.println("done added");
	}
}

