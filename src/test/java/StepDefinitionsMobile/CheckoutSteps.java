package StepDefinitionsMobile;

import ClassBase.CheckoutPage;
import Util.PropertyHelper;
import Util.TestBase;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Properties;

public class CheckoutSteps extends TestBase {

    CheckoutPage page= new CheckoutPage(driver);
    double amount=0;

    @And("Select the tee time desired {string}")
    public void selectTheTeeTimeDesired( String Time) throws InterruptedException {
       // Log.info("************SELECT TIME DESIRED************");
        Properties p= PropertyHelper.loadData();
        String time= p.getProperty(Time);
        page.selectTeeTime(time);

    }

    @Then("Click on any Rate type {string}")
    public void clickOnAnyRateType(String Rate) throws InterruptedException {
     //   Log.info("************SELECT TIME RATE************");
        Properties p= PropertyHelper.loadData();
        String rate= p.getProperty(Rate);
        page.selectRate(rate);
    }

    @Then("Verify the provider screen is displayed")
    public void verifyTheProviderScreenIsDisplayed() throws InterruptedException {
     //   Log.info("************VERIFY PROVIDER************");
        page.verifyProviderScree();
    }

    @When("Select one provider")
    public void selectOneProvider() throws InterruptedException {
     //   Log.info("************SELECT TIME PROVIDER************");
        page.selectProvider();
    }

    @Then("Verify checkout screen is present")
    public void verifyCheckoutScreenIsPresent() throws InterruptedException {
     //   Log.info("************VERIFY CHECKOUT SCREEN************");
        page.verifyCheckoutScreen();
        amount= page.totalAmountSelect();

    }

    @When("Values checkout after select players")
    public void valuesCheckoutAfterSelectPlayers(DataTable dataTable) throws InterruptedException {
      //  Log.info("************VERIFY AMOUNT CHANGE************");
        List<String> data= dataTable.asList();
        Properties p= PropertyHelper.loadData();
        String players= p.getProperty(data.get(0));
        page.totalAmountChange(players,amount);
    }

    @Then("Select Book now button")
    public void selectBookNowButton() throws InterruptedException {
      //  Log.info("************BOOK NOW BUTTON************");
        page.selectBookNow();
    }

    @And("Verify the Confirmation screen is displayed")
    public void verifyTheConfirmationScreenIsDisplayed() throws InterruptedException {
     //   Log.info("************VERIFY CONFIRMATION SCREEN************");
        page.verifyConfirmationScreen();
    }

    @And("Verify the button Add new is present")
    public void verifyTheButtonAddNewIsPresent() throws InterruptedException {
      //  Log.info("************VERIFY ADD BUTTON************");
        page.verifyAddButton();

    }

    @When("Click on Add New button")
    public void clickOnAddNewButton() throws InterruptedException {
      //  Log.info("************VERIFY ADD BUTTON************");
        page.selectAddButton();
    }

    @And("Enter full name")
    public void enterFullName(DataTable dataTable) throws Exception {
      //  Log.info("************ENTER FULL NAME************");
        List<String> data= dataTable.asList();
        Properties p= PropertyHelper.loadData();
        String name= p.getProperty(data.get(0));
        page.enterFirstName(name);
    }

    @And("Enter credit card")
    public void enterCreditCard(DataTable dataTable) throws Exception {
      //  Log.info("************ENTER CREDIT CARD************");
        List<String> data= dataTable.asList();
        Properties p= PropertyHelper.loadData();
        String credit= p.getProperty(data.get(0));
        page.enterCreditCard(credit);
    }

    @And("Enter Exp years")
    public void enterExpYears(DataTable dataTable) throws Exception {
       // Log.info("************ENTER EXP YEARS************");
        List<String> data= dataTable.asList();
        Properties p= PropertyHelper.loadData();
        String years= p.getProperty(data.get(0));
        page.enterExpDate(years);
    }

    @And("Enter CVV")
    public void enterCVV(DataTable dataTable) throws Exception {
      //  Log.info("************ENTER CVV************");
        List<String> data= dataTable.asList();
        Properties p= PropertyHelper.loadData();
        String cvv= p.getProperty(data.get(0));
        page.enterCVV(cvv);
    }

    @And("Enter zip code")
    public void enterZipCode(DataTable dataTable) throws Exception {
      //  Log.info("************ENTER ZIP CODE ************");
        List<String> data= dataTable.asList();
        Properties p= PropertyHelper.loadData();
        String zipCode= p.getProperty(data.get(0));
        page.enterZipCode(zipCode);
    }

    @When("Click on change credit cards")
    public void clickOnChangeCreditCards() throws InterruptedException {
      //  Log.info("************CHANGE CREDIT CARD ************");
        page.selectChangeButton();

    }

    @And("Verify the message for credit card incorrect is displayed")
    public void verifyTheMessageForCreditCardIncorrectIsDisplayed() throws InterruptedException {
       // Log.info("************ VERIFY MESSAGE IS DISPLAYED ************");
        page.creditCardsIncorrect();

    }

    @And("Verify Back to provider link is present")
    public void verifyBackToProviderLinkIsPresent() throws InterruptedException {
     //   Log.info("************ VERIFY BACK TO PROVIDER************");
        page.backToProvider();
    }

    @When("Click on Back to provider link")
    public void clickOnBackToProviderLink() throws InterruptedException {
      //  Log.info("************ CLICK BACK TO PROVIDER************");
        page.backToProviderClick();
    }

    @And("Selected the credit card desired")
    public void selectedTheCreditCardDesired() throws InterruptedException {
     //   Log.info("************ CLICK BACK TO PROVIDER************");
        Properties p= PropertyHelper.loadData();
        String cardName= p.getProperty("CardName");
        page.changeCard(cardName);

    }

    @When("Click on Done")
    public void clickOnDone() {
    }

    @And("Click on MYy SG dashboard")
    public void clickOnMYySGDashboard() {
    }

    @And("Select Payment Methods options")
    public void selectPaymentMethodsOptions() {
    }

    @When("Click on Remove option")
    public void clickOnRemoveOption() {
    }

    @Then("Verify the credit card was deleted")
    public void verifyTheCreditCardWasDeleted() {
    }

    @When("Click on Add New Credit Card button")
    public void clickOnAddNewCreditCardButton() throws InterruptedException {
     //   Log.info("************CLICK ON NEW ADD CREDIT CARD ************");
        page.selectAddNewButton();
    }
}
