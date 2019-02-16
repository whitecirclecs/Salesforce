package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class DifferentBrowsers {
	
	@Test
	public void openBrowser() {
//		System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
//		WebDriver driver = new InternetExplorerDriver();
		
		System.setProperty("webdrver.edge.driver", "MicrosoftWebDriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://facebook.com");
	}

}
