package StepDefinitionsMobile;

import ClassBase.HomePageMeanSearchMobile;
import ClassBase.SignInpage;
import Util.Log;
import Util.PropertyHelper;
import Util.TestBase;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Properties;

public class SignInSteps extends TestBase {

	SignInpage page = new SignInpage(driver);
	HomePageMeanSearchMobile home= new HomePageMeanSearchMobile(driver);

	@When("Click on Sign In button")
	public void click_on_Sign_In_button() throws Exception {
		Log.info("******CLICK ON SIGN IN*******");
		page.clickOnSigIn();
	}

	@Then("Verify the message below Sign In")
	public void verify_the_message_below_Sign_In() throws Exception {
		Log.info("******VERIFY TEXT BELOW SIGN IN*******");
		page.verifySignInElementBelow();
	}

	@Then("Verify email is present")
	public void verify_email_is_present() throws InterruptedException {
		Log.info("******VERIFY TEXT EMAIL IS PRESENT*******");
		page.verifyEmailPresent();
	}

	@Then("Verify password is present")
	public void verify_password_is_present() throws InterruptedException {
		Log.info("******VERIFY TEXT PASSWORD IS PRESENT*******");
		page.verifyPassword();
	}

	@Then("Verify the error message is present")
	public void verify_the_error_message_is_present() throws Exception {
		Log.info("******VERIFY ERROR MESSAGE FOR EMAIL IS DISPLAYED*******");
		page.verifyEmailInvalidText();
	}

	@Then("Verify the message is present for password")
	public void verify_the_message_is_present_for_password() throws Exception {
		Log.info("******VERIFY MESSAGE ERROR FOR PASSWORD IS DISPLAYED*******");
		page.verifyPasswordInvalidText();
	}

	@Then("Clean email field")
	public void clean_email_field() throws InterruptedException {
		Log.info("******CLEAR EMAIL FIELD*******");
		page.clearFieldEmail();
	}

	@Then("Verify the login button is disable")
	public void verify_the_login_button_is_disable() throws InterruptedException {
		Log.info("******VERIFY LOGIN DISABLE*******");
		page.loginDisable();
	}

	@Then("Enter password")
	public void enter_password(DataTable dataTable) throws Exception {
		Log.info("******ENTER PASSWORD*******");
		List<String> course = dataTable.asList();
		Properties p = PropertyHelper.loadData();
		String passIncorrect = p.getProperty(course.get(0));
		page.enterPassword(passIncorrect);
	}

	@Then("Select Show option")
	public void select_Show_option() throws Exception {
		Log.info("******SELECT SHOW PASSWORD*******");
		page.selectShow();
	}

	@Then("Clear password field")
	public void clear_password_field() throws InterruptedException {
		Log.info("******CLEAR FIELD PASSWORD*******");
		page.clearFieldPass();
	}

	@When("Enter correct email")
	public void enter_correct_email(DataTable dataTable) throws Exception {
		Log.info("******ENTER CORRECT EMAIL*******");
		List<String> course = dataTable.asList();
		Properties p = PropertyHelper.loadData();
		String email = p.getProperty(course.get(0));
		page.enterCorrectEmail(email);
	}

	@When("Enter Invalid password")
	public void enter_Invalid_password(DataTable dataTable) throws Exception {
		Log.info("******ENTER INCORRECT PASSWORD*******");
		List<String> course = dataTable.asList();
		Properties p = PropertyHelper.loadData();
		String passIncorrect = p.getProperty(course.get(0));
		page.passINCorrect(passIncorrect);
	}

	@When("Click on Login button")
	public void click_on_Login_button() throws Exception {
		Log.info("******CLICK ON LOGIN BUTTON*******");
		page.clickOnLogin();
	}

	@Then("Verify the message error")
	public void verify_the_message_error() throws Exception {
		Log.info("******VERIFY MESSAGE ERROR*******");
		page.verifyPasswordEmailInvalidText();

	}

	@When("Enter invalid email")
	public void enter_invalid_email(DataTable dataTable) throws Exception {
		Log.info("******ENTER INVALID EMAIL*******");
		List<String> course = dataTable.asList();
		Properties p = PropertyHelper.loadData();
		String emailIncorrect = p.getProperty(course.get(0));
		page.enterIncorrectEmail(emailIncorrect);
		
	}

	@When("Enter valid password")
	public void enter_valid_password(DataTable dataTable) throws Exception {
		Log.info("******ENTER INVALID PASSWORD*******");
		List<String> course = dataTable.asList();
		Properties p = PropertyHelper.loadData();
		String passCorrect = p.getProperty(course.get(0));
		page.enterPassword(passCorrect);
	}

	@When("Select Forgot Password Link")
	public void select_Forgot_Password_Link() throws Exception {
		Log.info("******SELECT FORGOT PASSWORD*******");
		page.clickOnForgotPassword();
	}

	@Then("Verify the Reset Password is present")
	public void verify_the_Reset_Password_is_present() throws Exception {
		Log.info("******VERIFY RESET PASSWORD IS PRESENT*******");
		page.verifyRestPassword();
	}

	@Then("Verify the windows for confirmation is displayed")
	public void verify_the_windows_for_confirmation_is_displayed() throws Exception {
		Log.info("******CLICK ON RESET PASSWORD*******");
		page.clickOnResetPassword();

		Log.info("******CHECK YOUR EMAIL IS DISPLAYED*******");
		page.verifyCheckYourEmailPresent();

	}

	@Then("Verify the windows for error message")
	public void verify_the_windows_for_error_message() throws Exception {
		Log.info("******VERIFY EMAIL INVALID MESSAGE*******");
		page.verifyEmailInvalidText();
	}

	@When("Select Facebook option")
	public void select_Facebook_option(DataTable dataTable) throws Exception {
		Log.info("******CLICK ON FACEBOOK*******");
		List<String> data= dataTable.asList();
		Properties p = PropertyHelper.loadData();
		String email= p.getProperty(data.get(0));
		String pass= p.getProperty(data.get(1));
		page.clickOnFacebook(email,pass);
	}


	@When("Select Create Account link")
	public void select_Create_Account_link() throws Exception {
		Log.info("******CLICK ON CREATE ACCOUNT*******");
		page.clickOnCreateAccount();
	}

	@Then("Check the Sign Up popup is present")
	public void check_the_Sign_Up_popup_is_present() throws InterruptedException {
		Log.info("******VERIFY SIGN UP IS PRESENT*******");
		page.verifySignUpIsPresent();
	}

	@When("Select Google option and enter credentials")
	public void select_Google(DataTable dataTable) throws Exception {
		Log.info("******CLICK ON GOOGLE INVALID*******");
		List<String> data= dataTable.asList();
		Properties p = PropertyHelper.loadData();
		String email= p.getProperty(data.get(0));
		String pass= p.getProperty(data.get(1));
		page.clickOnGoogleButton(email, pass);
	}

	@Then("Verify the user is login with social medias")
	public void verify_the_user() throws Exception {
		Log.info("******VERIFY USER IS LOGIN WITH SOCIAL MEDIAS*******");
		Properties p = PropertyHelper.loadData();
		String emailData= p.getProperty("EmailUserGoogle");
		String lastname= p.getProperty("LastNameUserGoogle");
		page.verifyDashboard(emailData, lastname);
	}

	@Then("Click on SignOut button")
	public void click_on_SignOut_button() throws Exception {
		Log.info("******CLICK ON SIGN OUT BUTTON*******");
		page.madeASignOut();
	}


	@And("Verify Keep me login is present")
	public void verifyKeepMeLoginIsPresent() throws Exception {
		Log.info("******KEEP ME LOGIN*******");
		page.verifyKeepLogin();

	}

	@When("Verify error message google used")
	public void verifyErrorMessageGoogleUsed() throws InterruptedException {
		Log.info("******VERIFY MESSAGE ERROR GOOGLE*******");
		page.accountUsed();
	}

	@When("Select Facebook option incorrect")
	public void selectFacebookOptionIncorrect(DataTable dataTable) throws Exception {
		Log.info("******FACEBOOK INCORRECT*******");
		List<String> data= dataTable.asList();
		Properties p = PropertyHelper.loadData();
		String email= p.getProperty(data.get(0));
		String pass= p.getProperty(data.get(1));
		page.clickOnFacebookIncorrect(email,pass);

	}

	@Then("Select SignUp link")
	public void selectSignUpLink() throws InterruptedException {
		Log.info("******SELECT SIGN UP LINK*******");
		page.clickOnSigUnLink();

	}

	@Then("Verify the current location is displayed")
	public void verifyTheCurrentLocationIsDisplayed() throws InterruptedException {
		Log.info("******VERIFY LOCATION IS DISPLAYED*******");
		home.verifyCurrentLocation();

	}

	@And("Click on Bookings menu")
	public void clickOnBookingsMenu() throws InterruptedException {
		Log.info("******CLICK ON BOOKING MENU*******");
		page.clickOnBookingMenu();

	}

}
