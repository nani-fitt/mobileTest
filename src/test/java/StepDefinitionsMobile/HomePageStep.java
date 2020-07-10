package StepDefinitionsMobile;


import ClassBase.HomePageMobilePage;
import Util.Log;
import Util.TestBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageStep extends TestBase {

	HomePageMobilePage page= new HomePageMobilePage((AndroidDriver<MobileElement>) driver);

	@Then("Verify that Supreme Golf logo is displayed")
	public void verify_that_Supreme_Golf_logo_is_displayed() throws InterruptedException {

        Log.info("Verify logo supreme");
		page.VerifyLogoSupremeGolf();
	}

	@Then("Verify that Menu header is displayed")
	public void verifyThatMenuHeaderIsDisplayed() throws InterruptedException {
		Log.info("Verify menu");
	    page.VerifyMenuHeader();
	}

	@Then("Verify that Search component is displayed")
	public void verifyThatSearchComponentIsDisplayed() throws InterruptedException {
	    Log.info("Verify Search Fields");
		page.SearchFiedlHeader();
	}

	@When("Accept the cookies")
	public void acceptTheCookies() throws InterruptedException {
	    Log.info("Accept Cookies");
		page.ClickOnCookie();
	}

	@When("Click on menu header")
	public void clickOnMenuHeader() throws InterruptedException {
		Log.info("Click on menu header");
		page.ClickOnMenuHeader();

	}

	@Then("Verify the menu options are present")
	public void verifyTheMenuOptionsArePresent() throws InterruptedException {
		page.VerifyOptionsMenu();
	}
}
