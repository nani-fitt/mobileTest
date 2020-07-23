package StepDefinitionsMobile;
import ClassBase.HomePageMeanSearchMobile;
import ClassBase.SignUpPage;
import Util.Log;
import Util.PropertyHelper;
import Util.TestBase;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

public class SignUpSteps extends TestBase {

	SignUpPage page = new SignUpPage(driver);

	@When("Click on Create Account Link")
	public void click_on_Create_Account_Link() throws Exception {
		Log.info("******CLICK ON CREATE ACCOUNT LINK*******");
		page.clickOnCreateAccount();
	}

	@Then("Verify the message below Sign Up")
	public void verify_the_message_below_Sign_Up() throws InterruptedException {
		Log.info("******VERIFY MESSAGE BELOW SIGN UP*******");
		page.verifyMessageSignUp();
	}

	@Then("Verify FirstName is present")
	public void verify_FirstName_is_present() {
		Log.info("******VERIFY FIRST NAME*******");
		page.verifyFirstName();
	}

	@Then("Verify LastName is present")
	public void verify_LastName_is_present() {
		Log.info("******VERIFY LAST NAME*******");
		page.verifyLastName();
	}

	@Then("Verify ZipCode is present")
	public void verify_ZipCode_is_present() {
		Log.info("******VERIFY ZIP CODE*******");
		page.verifyZipCode();
	}

	@Then("Verify Email is present")
	public void verify_Email_is_present() {
		Log.info("******VERIFY EMAIL ADDRESS*******");
		page.verifyEmailAddres();
	}

	@Then("Verify Password is present")
	public void verify_Password_is_present() {
		Log.info("******VERIFY PASSWORD*******");
		page.verifyPassword();
	}

	@Then("Verify Referral Code is present")
	public void verify_Referral_Code_is_present() {
		Log.info("******VERIFY REFERRAL CODE*******");
		page.verifyReferralCode();
	}

	@When("Enter the data")
	public void enter_the_data(DataTable dataTable) throws Exception {
		List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> data : list) {
			Properties p = PropertyHelper.loadData();
			String name = p.getProperty(data.get("Firstname"));
			String lastname = p.getProperty(data.get("Lastname"));
			String zip = p.getProperty(data.get("ZipCode"));
			String pass = p.getProperty(data.get("Password"));
			Random randomGenerator= new Random(System.currentTimeMillis());
			int randomInt = randomGenerator.nextInt(1000);
			String randomEmail=p.getProperty("Email")+randomInt+"@mailinator.com";
			page.signUPSuccessful(name,lastname,zip,randomEmail,pass);

		}
	}

	@When("Enter the data exist")
	public void enter_the_exist(DataTable dataTable) throws Exception {
		List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> data : list) {
			Properties p = PropertyHelper.loadData();
			String name = p.getProperty(data.get("Firstname"));
			String lastname = p.getProperty(data.get("Lastname"));
			String zip = p.getProperty(data.get("ZipCode"));
			String pass = p.getProperty(data.get("Password"));
			String email = p.getProperty(data.get("Email"));
			page.signUPSuccessful(name,lastname,zip,email,pass);
		}
	}


	@Then("Verify the home page is displayed")
	public void verify_home_page_is_present() throws Exception {
		Log.info("******VERIFY THE HOME PAGE IS DISPLAYED*******");
		HomePageMeanSearchMobile main = new HomePageMeanSearchMobile(driver);
		main.fechaMainSearch();
	}

	@Then("Verify log for the characteres")
	public void verify_log_for_the_characteres() throws Exception {
		Log.info("******VERIFY AT LEAST SIX CHARACTERS MESSAGE IS PRESENT*******");
		page.verifyCharacteres();
	}

	@Then("Verify at least one uppercase and lowercase letter")
	public void verify_at_least_one_uppercase_and_lowercase_letter() throws Exception {
		Log.info("******VERIFY MESSAGE FOR LETTER*******");
		page.verifyLetter();
	}

	@Then("Verify at least one number")
	public void verify_at_least_one_number() throws Exception {
		Log.info("******VERIFY MESSAGE FOR NUMBER*******");
		page.verifyNumber();
	}

	@Then("Verify the Create Account button is disable")
	public void verify_the_create_button_is_disable() throws Exception {
		Log.info("******VERIFY CREATE ACCOUNT BUTTON IS DISABLE*******");
		page.createAccountDisable();
	}

	@When("Click on Google button")
	public void click_on_Google_button() throws InterruptedException {
		Log.info("******CLICK ON GOOGLE BUTTON*******");
		page.clickOnGoogleButton();
	}

	@When("Click on Facebook button")
	public void click_on_Facebook_button() throws InterruptedException {
		Log.info("******CLICK ON FACEBOOK BUTTON*******");
		page.clickOnFacebookButton();
	}

	@Then("Verify message for field empty")
	public void Verify_message_for_field_empty() throws Exception {
		Log.info("******VERIFY MESSAGE FOR FIELD EMPTY IS PRESENT*******");
		page.messageFieldEmpty();
	}

    @Then("Verify the message for account used is present")
    public void verifyTheMessageForAccountUsedIsPresent() throws Exception {
		Log.info("******VERIFY MESSAGE ERROR*******");
        page.verifyEmailAlreadyUsed();

    }

	@And("Click on enter email field")
	public void clickOnEnterEmailField() throws Exception {
		Log.info("******CLICK ON SIGN UP WITH EMAIL*******");
		page.clickOnEmailSignUp();
	}

	@And("Click on Create Account Button")
	public void clickOnCreateAccountButton() throws Exception {
		Log.info("******CLICK ON CREATE ACCOUNT BUTTON*******");
		//page.clickOnCreateButton();
	}

	@And("Verify Welcome SG screen")
	public void verifyWelcomeSGScreen() throws InterruptedException {
		Log.info("******Verify Welcome SG Screen*******");
		page.verifyWelcomeSG();
	}

	@And("Click on welcome button")
	public void clickOnWelcomeButton() throws Exception {
		Log.info("******CLICK ON MY FIRST BOOKING*******");
		page.clickOnWelcomeButton();
	}

	@Then("Click on Sign In link since sign up screen")
	public void clickOnSignInLinkSinceSignUpScreen() throws InterruptedException {
		Log.info("******CLICK SIGN IN SINCE SIGN UP*******");
		page.clickSignInLink();
	}

	@Then("Verify Message email taken is displayed")
	public void verifyMessageEmailTakenIsDisplayed() throws Exception {
		Log.info("******EMAIL TAKEN MESSAGE*******");
		page.verifyEmailAlreadyUsed();

	}

	@When("Enter the data {string} {string} {string} {string} {string}")
	public void enterTheData(String firstname, String lastname, String zipcode, String email, String password) throws Exception {
		Properties p= PropertyHelper.loadData();
		String name= p.getProperty(firstname);
		String lastName= p.getProperty(lastname);
		String zipCode= p.getProperty(zipcode);
		String pass= p.getProperty(password);
		Random randomGenerator= new Random(System.currentTimeMillis());
		int randomInt = randomGenerator.nextInt(1000);
		String randomEmail=p.getProperty(email)+randomInt+"@mailinator.com";
		page.signUPSuccessful(name,lastName,zipCode,email,pass);
}
	}