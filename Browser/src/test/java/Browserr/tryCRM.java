package Browserr;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class tryCRM {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://ui.cogmento.com/");
		driver.findElement(By.cssSelector("#ui > div > div > form > div > div:nth-child(1) > div > input[type=text]")).sendKeys("hemant.hs828@gmail.com");
		driver.findElement(By.cssSelector("#ui > div > div > form > div > div:nth-child(2) > div > input[type=password]")).sendKeys("2@Discus2@");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#ui > div > div > form > div > div.ui.fluid.large.blue.submit.button")).click();
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.cssSelector("#main-nav"))).build().perform();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("#main-nav > div:nth-child(3) > button")).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("#top-header-menu > div.right.menu > div.ui.inverted.transparent.left.icon.input > input[type=text]")).click();
		driver.findElement(By.cssSelector("#main-content > div > div.ui.fluid.container.main-content > form > div:nth-child(1) > div:nth-child(1) > div > div > input[type=text]")).sendKeys("head");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//*[@name='category'])[1]")).click();
		List<WebElement> links =driver.findElements(By.cssSelector(".visible.menu.transition>div"));
		String con =links.toString();
		System.out.println(links.size());
		
		for (int i=0;i<=links.size();i++) {
			System.out.println(links.get(i).getText());
			if(links.get(i).getText().contains("Contact")) {
				links.get(i).click();
				break;
			}
		}

	}

}
