package StepDefinitionsMobile;

import Util.TestBase;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ServiceHooks {

	TestBase testBase;
	public Properties prop;
	

	@Before("not @Connection")
	public void initializeTest() throws IOException, InterruptedException {
		
		testBase = new TestBase();
		prop= new Properties();
		FileInputStream file= new FileInputStream("./src/property/browers.properties");
		prop.load(file);
		String browsers= prop.getProperty("browser");
		//String env= prop.getProperty("urlStaging");
		//String cloud= prop.getProperty("cloud");
		testBase.selectBrowser(browsers);
		
	}
	
	@Before("@Connection")
	public void disableLocationTest1() throws IOException, InterruptedException {
		testBase = new TestBase();
		prop= new Properties();
		FileInputStream file= new FileInputStream("./src/property/browers.properties");
		prop.load(file);
		String browsers= prop.getProperty("browser");
		//String env= prop.getProperty("urlStaging");
		//String cloud= prop.getProperty("cloud");
		testBase.selectBrowser(browsers);
	}


	@After("not @Connection")
	public void endTest(Scenario scenario) throws Exception {
		
		if (scenario.isFailed()) {
			
			System.out.println("Scenario failed");
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			System.out.println("Name of the scenario"+ " " + screenshotName);
			TakesScreenshot ts = (TakesScreenshot) TestBase.driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("./ScreenShot/" + screenshotName + ".png"));
			System.out.println("the Screenshot is taken");	 
		}
		
		 TestBase.driver.quit();
	}
	
	
	@After("@Connection")
	
	public void endTestConnection(Scenario scenario) throws Exception {
		
		if (scenario.isFailed()) {
			
			System.out.println("Scenario failed");
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			System.out.println("Name of the scenario"+ " " + screenshotName);
			TakesScreenshot ts = (TakesScreenshot) TestBase.driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("./ScreenShot/" + screenshotName + ".png"));
			System.out.println("the Screenshot is taken");	 
		}
		
		 TestBase.driver.quit();
		 
	}
	
}
