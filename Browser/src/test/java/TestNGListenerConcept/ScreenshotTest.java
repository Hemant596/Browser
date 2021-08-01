package TestNGListenerConcept;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListener.class)
public class ScreenshotTest extends Base{
	
	@BeforeMethod
	public void setUp() {
		launchDriver();
		
	}
	
	
	@Test
	
	public void Test() {
		Assert.assertEquals(false, false);
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}

}
