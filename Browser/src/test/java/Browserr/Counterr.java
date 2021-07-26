package Browserr;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Counterr {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://magic-ce-projects.s3.amazonaws.com/Content_3001-HMH-Go-Math-iTools-Flash-to-HTML-Conversion/counters/2021-07-22_17-46-57/index.html");
		for ( int i=1;i<55;i++) {
		driver.findElement(By.cssSelector(".leftmenuItem.selected")).click();
		

	

		driver.findElement(By.cssSelector("#dropA")).click();
		driver.findElement(By.cssSelector(".drop-container-one.dropA>button")).click();
	}}

}
