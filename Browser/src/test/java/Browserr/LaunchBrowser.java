package Browserr;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;


public class LaunchBrowser {
	
	
WebDriver driver;
	public void boom() throws InterruptedException  {
		
		ChromeDriverManager.chromedriver().setup();
		ChromeOptions head= new ChromeOptions();
		head.setHeadless(true);
		driver = new ChromeDriver(head);
		Thread.sleep(3000);
		
	
	}}

