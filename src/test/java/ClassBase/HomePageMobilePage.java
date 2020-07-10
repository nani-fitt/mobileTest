package ClassBase;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class HomePageMobilePage {

    AppiumDriver<MobileElement> driver;
    SoftAssert softAssert=new SoftAssert();

	@FindBy(css = "svg[class='object-contain']")
    WebElement logoSupremeGolf;

    @FindBy(css = "button[class='w-8 h-8 flex flex-col justify-between focus:outline-none']")
     WebElement menuButtonHeader;

    @FindBy(css = "a[class='active']")
    List<WebElement> menuOptions;

	@FindBy(css = "div[class='py-2']")
    List<WebElement> explore;

    @FindBy(css = "p[data-qa-file='SearchAutocomplete']")
    WebElement menuSearch;

    @FindBy(css = "div[class='pt-2 pb-6']")
    WebElement giftcard;

    @FindBy(css = "p[data-qa-file='SearchDatePicker']")
     WebElement menuSearchDate;

    @FindBy(css = "p[data-qa-file='SearchDropDown']")
    List<WebElement> menuDrowpdown;

    @FindBy(css = "button[data-qa-file='StandardButton']")
    List<WebElement> button;

    @FindBy(css = "button[class='w-full bg-orangey-red block text-white h-10 rounded-lg text-sm focus:outline-none']")
    WebElement cookieButton;

	public HomePageMobilePage(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

    public void ClickOnCookie() throws InterruptedException {
        Thread.sleep(5000);
        cookieButton.click();
        Thread.sleep(3000);
    }

	public void VerifyLogoSupremeGolf() throws InterruptedException {
	    Thread.sleep(5000);
	    Assert.assertTrue(logoSupremeGolf.isDisplayed());
        Thread.sleep(2000);
    }
    public void VerifyMenuHeader() throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertTrue(menuButtonHeader.isDisplayed());
        Thread.sleep(5000);
    }

    public void SearchFiedlHeader() throws InterruptedException {
       Thread.sleep(5000);
        Assert.assertEquals(menuSearch.getText(), "Location");
        Assert.assertEquals(menuSearchDate.getText(), "Date");
        Assert.assertEquals(menuDrowpdown.get(0).getText(), "Players");
        Assert.assertEquals(menuDrowpdown.get(1).getText(), "Any");
        Assert.assertEquals(menuDrowpdown.get(2).getText(), "Holes");
        Assert.assertEquals(menuDrowpdown.get(3).getText(), "Any");
        Assert.assertEquals(button.get(0).getText(), "Search");
    }

    public void ClickOnMenuHeader() throws InterruptedException {
        Thread.sleep(5000);
        menuButtonHeader.click();
        Thread.sleep(3000);
    }

    public void VerifyOptionsMenu() throws InterruptedException {
        Thread.sleep(10000);
        softAssert.assertEquals(menuOptions.get(2).getText(), "Home");
        softAssert.assertEquals(explore.get(1).getText(), "Explore >");
        softAssert.assertEquals(giftcard.getText(), "Gift Cards");
        softAssert.assertEquals(menuOptions.get(5).getText(), "Help");
        softAssert.assertEquals(explore.get(2).getText(), "Sign In");
        softAssert.assertEquals(explore.get(3).getText(), "Create Account");
        softAssert.assertEquals(menuOptions.get(3).getText(), "Near Me");
        softAssert.assertEquals(menuOptions.get(4).getText(), "Deals");
        Thread.sleep(5000);


    }


}
