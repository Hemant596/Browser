package Browserr;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {

	@Test
	public void breaklink() {

		WebDriverManager.chromedriver().setup();
		ChromeOptions head = new ChromeOptions();
		head.setHeadless(true);
		ChromeDriver driver = new ChromeDriver(head);

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get("https://www.amazon.com/");

		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("NO of links :"+links.size());

		List<String> lin = new ArrayList<String>();
		for(WebElement e : links) {
			String urll =e.getAttribute("href");
			lin.add(urll);
			//brokenlinks(urll);
		}
		long st =System.currentTimeMillis();
		lin.parallelStream().forEach(e -> brokenlinks(e));
		long en = System.currentTimeMillis();
		System.out.println("total time taken :"+(st-en));
		driver.quit();
	}
	public static void brokenlinks(String linkUrl) {
		try {
			
			URL url = new URL(linkUrl);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setConnectTimeout(5000);
			con.connect();
			if(con.getResponseCode()>=400) {
				System.out.println(linkUrl +"--->"+con.getResponseMessage()+ "is a broken links");
			}else {
				
				System.out.println(linkUrl +"--->"+con.getResponseMessage());
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}