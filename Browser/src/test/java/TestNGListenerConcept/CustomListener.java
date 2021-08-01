package TestNGListenerConcept;

import java.io.IOException;

import org.testng.ITestNGListener;
import org.testng.ITestResult;

public class CustomListener extends Base implements ITestNGListener {
	
	
	public void onTestFailure(ITestResult result) throws IOException {
		
		System.out.println("Failed Test");
		screenShot();
	}

}
