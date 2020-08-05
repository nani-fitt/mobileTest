package ClassBase;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SignInpage {

    AppiumDriver<WebElement> driver;

    @FindBy(css = "div[class='py-2']")
    List<WebElement> signIn;

    @FindBy(css = "a[class='ml-1 font-black text-orangey-red focus:outline-none']")
    List<WebElement> signUp;

    @FindBy(css = "h1[data-qa-file='Login']")
    WebElement signInText;

    @FindBy(css = "label[for='rememberMe']")
    WebElement labelKeepLogin;

    @FindBy(css = "p[data-qa-file='Login']")
    WebElement signInText1;

    @FindBy(css = "p[data-qa-file='TextInput']")
    List<WebElement> textField;

    @FindBy(css = "button[data-qa-file='StandardButton']")
    List<WebElement> loginButton;

    @FindBy(name = "email")
    WebElement emailField;

    @FindBy(name = "password")
    WebElement passField;

    @FindBy(css = "p[class='pt-2 pl-2 text-red text-tiny leading-common2']")
    WebElement invalidTextPass;

    @FindBy(css = "button[id='internal-button-sign-up-password']")
    WebElement showField;

    @FindBy(css = "a[class='self-center text-little font-medium text-blood-orange leading-natural -tracking-0-22 focus:outline-none']")
    WebElement forgotPassword;

    @FindBy(css = "p[data-qa-file='TextInput']")
    List<WebElement> emailReset;

    @FindBy(css = "p[data-qa-file='RequestResetPassword']")
    WebElement resentPassword;

    @FindBy(css = "h1[data-qa-file='RequestResetPassword']")
    WebElement headerPassword;

    @FindBy(css = "p[data-qa-file='RequestResetPassword']")
    List<WebElement> checkEmail;

    @FindBy(css = "h1[data-qa-file='SignUp']")
    WebElement SignUpButton;

    @FindBy(css = "div[id='sign-out']")
    WebElement signOut;

    @FindBy(css = "button[data-qa-file='SocialSignIn']")
    List<WebElement> googleButton;

    @FindBy(css = "input[id= 'identifierId']")
    WebElement emailGoogle;

    @FindBy(css = "p[class='text-coral font-bold text-little leading-large text-left']")
    WebElement passGoogleUsedAccount;

    @FindBy(name = "email")
    WebElement emailFacebook;

    @FindBy(name = "pass")
    WebElement passFacebook;

    @FindBy(name = "login")
    WebElement loginFacebook;

    @FindBy(css = "button[class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc qIypjc TrZEUc']")
    WebElement siguienteButton;

    @FindBy(id = "error_box")
    List<WebElement> errorFacebook;

    @FindBy(css = "div[class='fsl fwb fcb']")
    WebElement errorFacebookMessage;

    @FindBy(css = "div[id='bookings']")
    WebElement bookingMenu;

    @FindBy(css = "input[id='account_name_text_field']")
    WebElement emailApple;

    @FindBy(css = "button[id='sign-in']")
    WebElement nextAppleButton;

    @FindBy(css = "input[id='password_text_field']")
    WebElement passApple;

    @FindBy(css = "button[class='button button-primary last nav-action  pull-right weight-medium']")
    WebElement continueApple;


    public SignInpage(AppiumDriver<WebElement> driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void clickOnSigIn() throws InterruptedException {
        Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", signIn.get(2));
        signIn.get(2).click();
        Thread.sleep(5000);
    }
    public void clickOnSigUnLink() throws InterruptedException {
        Thread.sleep(8000);
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        signUp.get(1).click();
        Thread.sleep(5000);
    }

    public void clickOnBookingMenu() throws InterruptedException {
        Thread.sleep(8000);
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        bookingMenu.click();
        Thread.sleep(5000);
    }

    public void verifySignInElementBelow() throws Exception {
        Thread.sleep(5000);
        Assert.assertEquals(signInText.getText(), "Sign In To Your Account");
        Assert.assertEquals(signInText1.getText(), "Sign in to your existing profile.");
    }

    public void verifyEmailPresent() throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertEquals(textField.get(0).getText(), "Email");

    }

    public void verifyPassword() throws InterruptedException {
        Thread.sleep(4000);
        Assert.assertEquals(textField.get(1).getText(), "Password");
    }

    public void verifyKeepLogin() throws InterruptedException {
        Thread.sleep(4000);
        driver.manage().timeouts().implicitlyWait(80,TimeUnit.SECONDS);
        Assert.assertEquals(labelKeepLogin.getText(), "Keep me logged in");
        Thread.sleep(4000);
    }

    public void enterIncorrectEmail(String email) throws Exception {
        Thread.sleep(4000);
        emailField.sendKeys(email);
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("h1[class='text-6 font-bold text-navy leading-natural -tracking-0-6']")).click();

    }

    public void verifyEmailInvalidText() throws Exception {
        Thread.sleep(4000);
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        Assert.assertEquals(textField.get(1).getText(), "The email you entered is not valid");
        Thread.sleep(3000);
    }

    public void verifyPasswordEmailInvalidText() throws Exception {
        Thread.sleep(4000);
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        Assert.assertEquals(invalidTextPass.getText(),
                "The email/password you entered is incorrect");
        Thread.sleep(2000);
    }

    public void verifyPasswordInvalidText() throws Exception {
        Thread.sleep(5000);
        passField.click();
        emailField.click();
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        Assert.assertEquals(textField.get(2).getText(), "Please enter a password");
        Thread.sleep(2000);
    }

    public void clearFieldEmail() throws InterruptedException {
        Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(80,TimeUnit.SECONDS);
        emailField.clear();
    }

    public void clickOnLogin() throws Exception {
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.elementToBeClickable(loginButton.get(0)));
        loginButton.get(0).click();
        Thread.sleep(12000);

    }

    public void loginDisable() throws InterruptedException {
        Thread.sleep(5000);
        boolean login = loginButton.get(0).isEnabled();
        System.out.println("Login disable" + " " + login);
        Assert.assertFalse(login);
    }

    public void enterPassword(String pass) throws Exception {
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElements(passField));
        passField.sendKeys(pass);
        Thread.sleep(3000);
    }

    public void selectShow() throws Exception {
        Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(80,  TimeUnit.SECONDS);
        showField.click();
        Thread.sleep(4000);
        Assert.assertEquals("Hide", showField.getText());
        Thread.sleep(4000);
    }

    public void clearFieldPass() throws InterruptedException {
        Thread.sleep(5000);
        passField.clear();
    }

    public void enterCorrectEmail(String email) throws Exception {
        Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(80,  TimeUnit.SECONDS);
        emailField.sendKeys(email);
        Thread.sleep(3000);
    }

    public void passINCorrect(String pass) throws Exception {
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfAllElements(passField));
        passField.sendKeys(pass);
        Thread.sleep(3000);
    }

    public void clickOnForgotPassword() throws Exception {
        Thread.sleep(5000);
        System.out.println("Size" + " " + forgotPassword.getText());
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        forgotPassword.click();
        Thread.sleep(3000);

    }

    public void verifyRestPassword() throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertEquals(headerPassword.getText(), "Forgot your Password?");
        Assert.assertEquals(resentPassword.getText(), "Enter your email address below and follow the instructions sent to your inbox.");
        Assert.assertEquals(emailReset.get(0).getText(), "Email");

    }

    public void clickOnResetPassword() throws Exception {
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(loginButton.get(0))).click();
        Thread.sleep(4000);
    }

    public void verifyCheckYourEmailPresent() throws Exception {
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfAllElements(checkEmail));
        Assert.assertEquals("If your email is in our system you will receive instructions on how to reset your password. Didn't receive an email with instructions? Click Below", checkEmail.get(0).getText());
        loginButton.get(0).click();
        Thread.sleep(4000);
    }

    public void clickOnCreateAccount() throws Exception {
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(forgotPassword)).click();
        Thread.sleep(4000);
    }

    public void clickOnFacebook(String email, String pass) throws Exception {
        Thread.sleep(5000);
        String browersActual = driver.getWindowHandle();
        System.out.println("Actual browser" + " " + browersActual);
        driver.manage().timeouts().implicitlyWait(80,TimeUnit.SECONDS);
        googleButton.get(0).click();
        Set<String> allWindowHandles = driver.getWindowHandles();
        Thread.sleep(2000);
        System.out.println("size windows"+ allWindowHandles.size());
        String winHandle1 = null;
        for (String winHandle : allWindowHandles) {
            System.out.println("Window handle - > " + winHandle);
            driver.switchTo().window(winHandle);// Switch to the desired window first and then execute commands using
            winHandle1=winHandle;
        }
        Thread.sleep(4000);
        if (emailFacebook.isDisplayed()) {
            Thread.sleep(2000);
            emailFacebook.sendKeys(email);
            Thread.sleep(5000);
            passFacebook.sendKeys(pass);
            Thread.sleep(3000);
            loginFacebook.click();
            Thread.sleep(3000);
            Thread.sleep(9000);
        }
        driver.switchTo().window(browersActual);
        driver.switchTo().defaultContent();
        Thread.sleep(10000);

    }

    public void clickOnFacebookIncorrect(String email, String pass) throws Exception {
        Thread.sleep(5000);
        String browersActual = driver.getWindowHandle();
        System.out.println("Actual browser" + " " + browersActual);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(googleButton.get(0)));
        googleButton.get(0).click();
        Set<String> allWindowHandles = driver.getWindowHandles();
        Thread.sleep(2000);
        System.out.println("size windows"+ allWindowHandles.size());
        String winHandle1 = null;
        for (String winHandle : allWindowHandles) {
            System.out.println("Window handle - > " + winHandle);
            driver.switchTo().window(winHandle);// Switch to the desired window first and then execute commands using
            winHandle1=winHandle;
        }
        Thread.sleep(4000);
        if (emailFacebook.isDisplayed()) {
            Thread.sleep(2000);
            emailFacebook.sendKeys(email);
            Thread.sleep(5000);
            passFacebook.sendKeys(pass);
            Thread.sleep(3000);
            loginFacebook.click();
            Thread.sleep(3000);
            Thread.sleep(9000);
            if(errorFacebook.size() > 1)
            {
                Assert.assertTrue(errorFacebookMessage.isDisplayed());
            }

        }
        driver.switchTo().window(browersActual);
        driver.switchTo().defaultContent();
        Thread.sleep(8000);

    }

    public void verifySignUpIsPresent() throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertEquals("Create Account", SignUpButton.getText());
    }


    public void verifyDashboard(String firstname, String lastname) throws Exception {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "return document.getElementById('profile-name').textContent;";
        String proName = (String) js.executeScript(script);

        System.out.println("usert" + proName);
        Assert.assertEquals(proName, firstname + " " + lastname);

        Thread.sleep(2000);
        String script2 = "return document.getElementById('my-sg').textContent;";
        String mysgDom = (String) js.executeScript(script2);

        Assert.assertEquals(mysgDom, "My SG");

        String script3 = "return document.getElementById('bookings').textContent;";
        String bookingsDom = (String) js.executeScript(script3);
        Assert.assertEquals(bookingsDom, "Bookings");
        Thread.sleep(2000);

    }

    public void madeASignOut() throws Exception {
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfAllElements(signOut));
        signOut.click();
        Thread.sleep(4000);
    }

    public void clickOnGoogleButton(String email, String pass) throws Exception {
        Thread.sleep(5000);
        String browersActual = driver.getWindowHandle();
        System.out.println("Actual browser" + " " + browersActual);
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        googleButton.get(1).click();
        Set<String> allWindowHandles = driver.getWindowHandles();
        Thread.sleep(2000);
        System.out.println("size windows"+ allWindowHandles.size());
        String winHandle1 = null;
        for (String winHandle : allWindowHandles) {
            System.out.println("Window handle - > " + winHandle);
            driver.switchTo().window(winHandle);// Switch to the desired window first and then execute commands using
            winHandle1=winHandle;
        }
        Thread.sleep(4000);
        if (emailGoogle.isDisplayed()) {
            Thread.sleep(2000);
            emailGoogle.sendKeys(email);
            siguienteButton.click();
            Thread.sleep(5000);
            passField.sendKeys(pass);
            siguienteButton.click();
            Thread.sleep(3000);
        }
        driver.switchTo().window(browersActual);
        driver.switchTo().defaultContent();
        Thread.sleep(10000);
    }

    public void accountUsed() throws InterruptedException {
        Thread.sleep(6000);
        Assert.assertTrue(passGoogleUsedAccount.isDisplayed());
    }

    public void clickOnAppleButton(String email, String pass) throws Exception {
        Thread.sleep(5000);
        String browersActual = driver.getWindowHandle();
        System.out.println("Actual browser" + " " + browersActual);
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        googleButton.get(2).click();
        Set<String> allWindowHandles = driver.getWindowHandles();
        Thread.sleep(2000);
        System.out.println("size windows"+ allWindowHandles.size());
        String winHandle1 = null;
        for (String winHandle : allWindowHandles) {
            System.out.println("Window handle - > " + winHandle);
            driver.switchTo().window(winHandle);// Switch to the desired window first and then execute commands using
            winHandle1=winHandle;
        }
        Thread.sleep(4000);
        if (emailApple.isDisplayed()) {
            Thread.sleep(2000);
            emailApple.sendKeys(email);
            nextAppleButton.click();
            Thread.sleep(5000);
            passApple.sendKeys(pass);
            nextAppleButton.click();
            Thread.sleep(5000);
            continueApple.click();
            Thread.sleep(5000);
        }
        driver.switchTo().window(browersActual);
        driver.switchTo().defaultContent();
        Thread.sleep(10000);
    }




}
