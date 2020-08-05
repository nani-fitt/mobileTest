package ClassBase;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomePageMobilePage {

    AppiumDriver<WebElement> driver;
    SoftAssert softAssert=new SoftAssert();

	@FindBy(css = "svg[class='object-contain']")
    WebElement logoSupremeGolf;

    @FindBy(css = "svg[data-qa-file='ContestBanner']")
    List<WebElement> contentBarner;

    @FindBy(css = "h6[class='mb-3 md:font-bold pt-4 text-navy']")
    List<WebElement> footer;

    @FindBy(css = "div[class='flex flex-col flex-2'] a")
    List<WebElement> signIn;

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
    List<WebElement> cookieButton;

	public HomePageMobilePage(AppiumDriver<WebElement> driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

    public void clickOnCookie() throws InterruptedException {
        Thread.sleep(5000);
        if(cookieButton.size() >0)
        {
            cookieButton.get(0).click();
        }
      /*  Thread.sleep(3000);
        if(contentBarner.size() >0)
        {
            Thread.sleep(4000);
            contentBarner.get(0).click();
        }*/
    }

	public void verifyLogoSupremeGolf() throws InterruptedException {
	    Thread.sleep(5000);
	    Assert.assertTrue(logoSupremeGolf.isDisplayed());
        Thread.sleep(2000);
    }
    public void verifyMenuHeader() throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertTrue(menuButtonHeader.isDisplayed());
        Thread.sleep(5000);
    }

    public void searchFiedlHeader() throws InterruptedException {
       Thread.sleep(5000);
        softAssert.assertEquals(menuSearch.getText(), "Location");
        softAssert.assertEquals(menuSearchDate.getText(), "Date");
        softAssert.assertEquals(menuDrowpdown.get(0).getText(), "Players");
        softAssert.assertEquals(menuDrowpdown.get(1).getText(), "Any");
        softAssert.assertEquals(menuDrowpdown.get(2).getText(), "Holes");
        softAssert.assertEquals(menuDrowpdown.get(3).getText(), "Any");
        softAssert.assertEquals(button.get(0).getText(), "Search");
    }

    public void clickOnMenuHeader() throws InterruptedException {
        Thread.sleep(5000);
        menuButtonHeader.click();
        Thread.sleep(3000);
    }

    public void verifyOptionsMenu() throws InterruptedException {
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

    public void selectMyAccount() throws InterruptedException {
        Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        footer.get(2).click();
        Thread.sleep(3000);
    }

    public void selectSignIn() throws InterruptedException {
        Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        signIn.get(6).click();
        Thread.sleep(3000);
    }


}
