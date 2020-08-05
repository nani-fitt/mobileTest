package ClassBase;


import Util.UtilityWebMobile;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class CheckoutPage {

    AppiumDriver<WebElement> driver;

    @FindBy( css = "div[class='inline-flex text-5 font-black text-navy -tracking-0-33 tee-time']")
    List<WebElement> timeList;

    @FindBy( css = "div[class='font-black text-lg mr-2 mb-2 text-navy truncate']")
    List<WebElement> rateList;

    @FindBy( css = "div[data-qa-file='TeeTimeList']")
    List<WebElement> providerList;

    @FindBy( css = "h2[data-qa-file='SelectProvider']")
    List<WebElement> providerScreen;

    @FindBy( css = "span[data-qa-file='TitledContainer']")
    List<WebElement> checkoutScreen;

    @FindBy( css = "span[data-qa-file='TitledContainer']")
    WebElement confirmationScreenHeader;

    @FindBy( css = "p[data-qa-file='RateTypes']")
    WebElement rateListHeader;

    @FindBy( css = "div[class='total-amount']")
    WebElement totalAmount;

    @FindBy( css = "div[class='flex inline-block']")
    List<WebElement>  bookNow;

    @FindBy(name = "fullName")
    WebElement fullName;

    @FindBy(css = "button[data-qa-file='CreditCardSelector']")
    WebElement cardSelecction;

    @FindBy(css = "p[class='pl-4 pt-1 error-text text-xxs text-red font-normal leading-relaxed']")
    WebElement creditCardIncorrect;

    @FindBy(css = "span[data-qa-file='Checkout']")
    WebElement backToProvider;

    @FindBy( css = "span[class='capitalize']")
    List<WebElement>  selectCreditChange;


    public CheckoutPage(AppiumDriver<WebElement> driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void selectTeeTime(String time) throws InterruptedException {
        TeeTimeListingMobilePage tee = new TeeTimeListingMobilePage(driver);
        if (tee.teeTime.size() > 0) {
           /* page.ScrollFinalPage(home.footer.get(1));
            Thread.sleep(6000);
            page.ScrollFinalPage(tee.filterBy);*/
            for (int i = 0; i < tee.teeTime.size(); i++) {
                if(timeList.get(i).getText().equalsIgnoreCase(time))
                {
                    WebElement timeS= tee.teeTime.get(i);
                    WebDriverWait wait= new WebDriverWait(driver,80);
                    wait.until(ExpectedConditions.elementToBeClickable(timeS)).click();
                    break;
                }
            }
        } else
            Assert.assertEquals(tee.messageTeeTimeEmpty.get(0).getText(), "Nothing Found!");
    }

    public void selectRate(String rate) throws InterruptedException {
        UtilityWebMobile page = new UtilityWebMobile();
        HomePageMobilePage home= new HomePageMobilePage(driver);
        TeeTimeListingMobilePage tee = new TeeTimeListingMobilePage(driver);
        if (rateList.size() > 0) {
            page.ScrollFinalPage(rateListHeader);
            Thread.sleep(6000);
            page.ScrollFinalPage(home.footer.get(0));
            for (WebElement element: rateList)
            {
                if(element.getText().equalsIgnoreCase(rate))
                {
                    WebDriverWait wait= new WebDriverWait(driver,80);
                    wait.until(ExpectedConditions.elementToBeClickable(element)).click();
                    break;
                }
            }

        } else
            Assert.assertEquals(tee.messageTeeTimeEmpty.get(0).getText(), "Nothing Found!");
    }

    public void selectProvider() throws InterruptedException {
        Thread.sleep(6000);
        TeeTimeListingMobilePage tee=new TeeTimeListingMobilePage(driver);
        if (providerList.size() > 0) {
            WebDriverWait wait= new WebDriverWait(driver,80);
            wait.until(ExpectedConditions.elementToBeClickable(providerList.get(0))).click();
        } else
            Assert.assertEquals(tee.messageTeeTimeEmpty.get(0).getText(), "Nothing Found!");
    }

    public void verifyProviderScree() throws InterruptedException {
        Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        Assert.assertEquals(providerScreen.get(0).getText(), "Book with Supreme Golf");
        Assert.assertEquals(providerScreen.get(1).getText(), "Book directly on provider website");

    }
    public double totalAmountSelect() throws InterruptedException {
        Thread.sleep(2000);
        WebDriverWait wait= new WebDriverWait(driver,80);
        wait.until(ExpectedConditions.visibilityOf(totalAmount));
        return Double.parseDouble(totalAmount.getText().replace("$"," "));

    }

    public void totalAmountChange(String players,double amount) throws InterruptedException {
        Thread.sleep(5000);
        WebDriverWait wait= new WebDriverWait(driver,80);
        wait.until(ExpectedConditions.visibilityOf(totalAmount));
        double total= Double.parseDouble(totalAmount.getText().replace("$"," "));
        Assert.assertNotEquals(amount,total);

    }

    public void verifyCheckoutScreen() throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertEquals(checkoutScreen.get(0).getText(),"Purchase Summary");
        Assert.assertEquals(checkoutScreen.get(1).getText(),"Payment Method");

    }


    public void selectBookNow() throws InterruptedException {
        Thread.sleep(5000);
        UtilityWebMobile page= new UtilityWebMobile();
        page.ScrollFinalPage(bookNow.get(1));
        WebDriverWait wait= new WebDriverWait(driver,80);
        wait.until(ExpectedConditions.elementToBeClickable(bookNow.get(1))).click();

    }
    public void verifyConfirmationScreen() throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertTrue(confirmationScreenHeader.isDisplayed());
    }

    public void selectAddButton() throws InterruptedException {
        Thread.sleep(5000);
        TeeTimeListingMobilePage page= new TeeTimeListingMobilePage(driver);
        WebDriverWait wait= new WebDriverWait(driver,80);
        wait.until(ExpectedConditions.elementToBeClickable(page.searchButton.get(0))).click();
    }

    public void verifyAddButton() throws InterruptedException {
        Thread.sleep(5000);
        TeeTimeListingMobilePage page= new TeeTimeListingMobilePage(driver);
        Assert.assertTrue(page.searchButton.get(0).isDisplayed());
    }


    public void enterFirstName(String firstname) throws Exception {
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(fullName));
        if (fullName.isDisplayed()) {
            fullName.sendKeys(firstname);
            Thread.sleep(2000);

        }
    }

    public void enterCreditCard(String name) throws Exception {
        Thread.sleep(3000);
        int size = driver.findElements(By.tagName("iframe")).size();
        System.out.println("Iframe size" + " " + size);
        Thread.sleep(4000);
        driver.switchTo().frame(1);
        WebElement card = driver.findElement(By.name("card_number"));
        card.sendKeys(name);

    }

    public void enterExpDate(String exp) throws Exception {
        Thread.sleep(3000);
        driver.switchTo().defaultContent();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("expirationDate")));
        WebElement expDate = driver.findElement(By.name("expirationDate"));
        expDate.sendKeys(exp);
    }


    public void enterCVV(String cvv) throws Exception {
        Thread.sleep(2000);
        driver.switchTo().frame(2);
        WebElement enterCVV = driver.findElement(By.id("cvv"));
        enterCVV.sendKeys(cvv);
        Thread.sleep(2000);
    }

    public void enterZipCode(String zipCode) throws Exception {
        Thread.sleep(2000);
        driver.switchTo().defaultContent();
        WebElement zipCod = driver.findElement(By.name("zip"));
        zipCod.sendKeys(zipCode);
        Thread.sleep(2000);
    }

    public void selectAddNewButton() throws InterruptedException {
        Thread.sleep(5000);
        TeeTimeListingMobilePage page= new TeeTimeListingMobilePage(driver);
        WebDriverWait wait= new WebDriverWait(driver,80);
        wait.until(ExpectedConditions.elementToBeClickable(page.searchButton.get(1))).click();
    }

    public void selectChangeButton() throws InterruptedException {
        Thread.sleep(5000);
        WebDriverWait wait= new WebDriverWait(driver,80);
        wait.until(ExpectedConditions.elementToBeClickable(cardSelecction)).click();
    }

    public void creditCardsIncorrect() throws InterruptedException {
        Thread.sleep(5000);
        WebDriverWait wait= new WebDriverWait(driver,80);
        wait.until(ExpectedConditions.textToBePresentInElement(creditCardIncorrect, "The card number you entered is incorrect"));
    }

    public void backToProvider() throws InterruptedException {
        Thread.sleep(5000);
        WebDriverWait wait= new WebDriverWait(driver,80);
        wait.until(ExpectedConditions.textToBePresentInElement(backToProvider, "Back to Providers"));
    }

    public void backToProviderClick() throws InterruptedException {
        Thread.sleep(5000);
        WebDriverWait wait= new WebDriverWait(driver,80);
        wait.until(ExpectedConditions.elementToBeClickable(backToProvider)).click();
    }

    public void changeCard(String car) throws InterruptedException {
        if (selectCreditChange.size() > 0) {
            for (WebElement element : selectCreditChange) {
                if (element.getText().equalsIgnoreCase(car)) {
                    WebDriverWait wait = new WebDriverWait(driver, 80);
                    wait.until(ExpectedConditions.elementToBeClickable(element)).click();
                    break;
                }
            }
        }
    }



}
