package ClassBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;


public class SignUpPage {

	AppiumDriver<MobileElement> driver;


	@FindBy(id = "create-account")
	WebElement createAccount;

	@FindBy(css = "p[data-qa-file='SignUp']")
	WebElement headerSignUP;

	@FindBy(css = "a[class='text-orangey-red font-bold']")
	WebElement signInLink;

	@FindBy(css = "p[data-qa-file='TextInput']")
	List<WebElement> headerField;

	@FindBy(css = "span[data-qa-file='WelcomeToSupreme']")
	List<WebElement> welcomeSG;

	@FindBy(css = "button[data-qa-file='SignUp']")
	 WebElement buttonEmail;

	@FindBy(css = "svg[data-qa-node='UncheckedIcon']")
	WebElement unCheck;

	@FindBy(css = "svg[data-qa-node='CheckedIcon']")
	WebElement check;

	@FindBy(xpath = "//span[@class='text-sm font-thin']")
	 WebElement signInMessage;

	@FindBy(name = "firstName")
	 WebElement firstNameField;

	@FindBy(name = "lastName")
	 WebElement lastNameField;

	@FindBy(name = "zipCode")
	 WebElement zipCodeField;

	@FindBy(name = "email")
	 WebElement emailField;

	@FindBy(name = "password")
	 WebElement passwordField;

	@FindBy(name = "referralCode")
	 WebElement referralCodeField;

	@FindBy(css = "p[class='text-coral font-bold text-little leading-large text-left']")
	WebElement messageEmailTaken;

	@FindBy(css = "span[data-qa-file='PasswordFeedback']")
	List<WebElement> verifyPassSixCharacteres;

	@FindBy(css = "button[data-qa-file='SocialSignIn']")
	List<WebElement> googleButton;

	@FindBy(css = "p[class=' error-text text-xxs text-red font-normal leading-relaxed ml-4 mt-1 place']")
	List<WebElement> emailUsedText;



	public SignUpPage(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnCreateAccount() throws Exception {
		Thread.sleep(8000);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(createAccount)).click();
		Thread.sleep(4000);
	}

	public void clickOnCreateButton() throws Exception {
		Thread.sleep(10000);
        TeeTimeListingMobilePage page = new TeeTimeListingMobilePage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.elementToBeClickable(page.searchButton.get(0))).click();
		Thread.sleep(5000);
	}

	public void verifyMessageSignUp() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertEquals(headerSignUP.getText(),"Browse millions of tee times and earn rewards with Supreme Golf. It's Free!");
	}

	public void verifyFirstName() {
		Assert.assertEquals(headerField.get(0).getText(), "First Name");
	}

	public void verifyLastName() {
		Assert.assertEquals(headerField.get(1).getText(), "Last Name");
	}

	public void verifyZipCode() {
		Assert.assertEquals(headerField.get(2).getText(), "Zip Code");
	}

	public void verifyEmailAddres() {
		Assert.assertEquals(headerField.get(3).getText(), "Email");
	}

	public void verifyPassword() {
		Assert.assertEquals(headerField.get(4).getText(), "Password");
	}

	public void verifyReferralCode() {
		Assert.assertEquals(headerField.get(5).getText(), "Referral Code");
	}

	public void signUPSuccessful(String firstname, String lastname, String zipcode, String email, String pass)
			throws Exception {
		firstNameField.sendKeys(firstname);
		Thread.sleep(2000);
		lastNameField.sendKeys(lastname);
		Thread.sleep(2000);
		zipCodeField.sendKeys(zipcode);
		Thread.sleep(2000);
		emailField.sendKeys(email);
		Thread.sleep(2000);
		passwordField.sendKeys(pass);

	}

	public void clickOnWelcomeButton() throws Exception {
		Thread.sleep(8000);
		TeeTimeListingMobilePage page = new TeeTimeListingMobilePage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(page.searchButton.get(0))).click();
		Thread.sleep(4000);
	}

	public void clickOnEmailSignUp() throws Exception {
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(buttonEmail)).click();
		Thread.sleep(3000);
	}

	public void verifyCharacteres() throws Exception {
		Thread.sleep(4000);
		Assert.assertEquals(verifyPassSixCharacteres.get(0).getText(), "a minimum of 6 characters");
		Thread.sleep(2000);
	}

	public void verifyNumber() throws Exception {
        Thread.sleep(4000);
		Assert.assertEquals(verifyPassSixCharacteres.get(2).getText(), "at least one number");
		Thread.sleep(2000);
	}

	public void verifyLetter() throws Exception {
		Thread.sleep(4000);
		Assert.assertEquals(verifyPassSixCharacteres.get(1).getText(), "at least one uppercase and lowercase letter");
		Thread.sleep(2000);
	}

	public void createAccountDisable() throws InterruptedException {
		Thread.sleep(5000);
		TeeTimeListingMobilePage page = new TeeTimeListingMobilePage(driver);
		boolean create= page.searchButton.get(0).isEnabled();
		if (!create) {
			System.out.println("THE BUTTON IS DISABLE");
			Assert.assertFalse(false);
		}
	}

	public void clickOnGoogleButton() throws InterruptedException {
        Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(googleButton.get(1))).click();

	}

	public void clickOnFacebookButton() throws InterruptedException {
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(googleButton.get(0))).click();

	}

	public void messageFieldEmpty() throws InterruptedException {
		Thread.sleep(5000);
		SoftAssert sortAssert= new SoftAssert();
		referralCodeField.click();
		sortAssert.assertEquals(emailUsedText.get(0).getText(), "Please enter your name");
		sortAssert.assertEquals(emailUsedText.get(1).getText(), "Please enter a zip code");
		//sortAssert.assertEquals(emailUsedText.get(2).getText(), "Please enter an email");
		sortAssert.assertEquals(emailUsedText.get(2).getText(), "Please enter a valid password");

	}
	
	public void verifyEmailAlreadyUsed() throws Exception
	{
		Thread.sleep(4000);
		WebDriverWait wait = new WebDriverWait(driver, 80);
		wait.until(ExpectedConditions.textToBePresentInElement(emailUsedText.get(0), "Email is already taken"));
		Thread.sleep(4000);
	}


	public void verifyWelcomeSG() throws InterruptedException {
		Thread.sleep(8000);
		Assert.assertEquals(welcomeSG.get(0).getText(), "Welcome To Supreme Golf!");
		Assert.assertEquals(welcomeSG.get(2).getText(), "  I want to receive email updates from Supreme Golf");
	}

	public void clickSignInLink() throws InterruptedException {
         Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(signInLink)).click();
		Thread.sleep(3000);
	}


	public void VerifyMessageEmailTaken() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertEquals(messageEmailTaken.getText(), "This account already exist. Please sign in with the credentials you used to create your Supreme Golf account and link your account in your account settings.");

	}



}
