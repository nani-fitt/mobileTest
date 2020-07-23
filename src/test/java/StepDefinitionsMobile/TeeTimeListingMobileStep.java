package StepDefinitionsMobile;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import ClassBase.TeeTimeListingMobilePage;
import Util.Log;
import Util.PropertyHelper;
import Util.TestBase;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TeeTimeListingMobileStep extends TestBase {

	TeeTimeListingMobilePage page = new TeeTimeListingMobilePage(driver);


	@Then("Made click on search button")
	public void made_click_on_search_button() throws Exception {
		Log.info("******CLICK ON SEARCH BUTTON*******");
		page.clickOnSearchButton();
	}
	@Then("Verify name and address is present")
	public void verify_name_and_address_is_present(DataTable dataTable) throws InterruptedException {
		Log.info("******VERIFY NAME AND ADDRESS FOR A COURSE ARE PRESENT*******");
		List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> data : list) {
			Properties p= PropertyHelper.loadData();
			String course= p.getProperty(data.get("Course"));
			String adress= p.getProperty(data.get("Address"));
			page.verifyNameAndAddress(course, adress);
		}
	}

	@Then("Verify course info is present")
	public void verify_description_icon_is_present() throws Exception {
		Log.info("******VERIFY ICON DESCRIPTION DISPLAYED*******");
		page.verifyCourseInfo();
	}

	@Then("Click course info icon")
	public void click_on_description_icon() throws Exception {
		Log.info("******CLICK ON ICON DESCRIPTION*******");
		page.clickOnCourseInfo();
	}

	@Then("Verify course reviews link")
	public void verify_course_reviews_link() throws InterruptedException {
		Log.info("******VERIFY GOLFER REVIEWS*******");
		page.verifyGolferReviewsLink();
	}

	@Then("Click on golfer reviews")
	public void click_on_golfer_reviews() throws Exception {
		Log.info("*****CLICK GOLFER REVIEWS*******");
		page.clickOnGolferReviewsLink();
	}

	@Then("Verify the save icon is present")
	public void verify_the_favorite_icon_is_present() throws InterruptedException {
		Log.info("******VERIFY FAVORITE ICON IS PRESENT*******");
		page.verifyFavoriteIcon();
	}

	@Then("Click on save icon")
	public void click_on_favorite_icon() throws Exception {
		Log.info("******CLICK ON FAVORITE ICON*******");
		page.clickOnFavoriteIcon();
	}

	@Then("Verify the color of icon change")
	public void verify_the_color_of_icon_change() throws InterruptedException {
		Log.info("******VERIFY SAVE ICON CHANGE THE COLOR*******");
		page.verifyFavorite();
	}

	@Then("Verify the alert icon is present")
	public void verify_the_alert_icon_is_present() throws InterruptedException {
		Log.info("******VERIFY ALERT ICON IS PRESENT*******");
		page.verifyAlertIcon();
	}

	@Then("Click on alert icon")
	public void click_on_alert_icon() throws Exception {
		Log.info("******CLICK ON ALERT ICON*******");
		page.clickOnAlertIcon();
	}

	@When("Select in the main search option players")
	public void select_in_the_main_search_option() throws Exception {
		Log.info("******SELECT ANY PLAYERS IN THE SEARCH FIELD*******");
		Properties p= PropertyHelper.loadData();
		String players= p.getProperty("PlayersSelect");
		page.MadeAnotherSearchPlayers(players);
	}

	@When("Select in the main search option holes")
	public void select_in_the_main_search_option_holes() throws Exception {
		Log.info("******SELECT ANY HOLES IN THE SEARCH FIELD*******");
		Properties p= PropertyHelper.loadData();
		String holes= p.getProperty("HolesSelect");
		page.MadeAnotherSearchHoles(holes);
	}

	@Then("Verify next icon is present")
	public void verify_next_icon_is_present() throws InterruptedException {
		Log.info("******VERIFY NEXT ICON IS PRESENT*******");
		page.verifyNextIconIsPresent();
	}
	
	@Then("Click on next icon")
	public void click_on_next_icon() throws Exception {
		Log.info("******CLICK ON PREVIOUS ICON*******");
		page.clickOnNextIcon();
		
	}
	
	@Then("Click on previous icon")
	public void click_on_previous_icon() throws Exception {
		Log.info("******CLICK ON NEXT ICON*******");
		page.clickOnPreviousIcon();
	}

	@Then("Verify previous icon is present")
	public void verify_previous_icon_is_present() throws InterruptedException {
		Log.info("******VERIFY PREVIOUS ICON IS PRESENT*******");
		page.verifyPreviousIconIsPresent();
	}



	@Then("Verify the result for the search")
	public void verify_the_result() throws Exception {
		Log.info("******VERIFY THE RESULT FOR THE SEARCH*******");
		Properties p= PropertyHelper.loadData();
		String players= p.getProperty("PlayersFilters");
		page.verifyResultForTheSearchPlayers(players);
	}

	@Then("Verify the result for the search for hole")
	public void verify_the_result_for_holes() throws Exception {
		Log.info("******VERIFY THE RESULT FOR THE SEARCH*******");
		page.verifyResultForTheSearchHoles("9");
	}

    @Then("Click on Deals button")
    public void Click_on_Deals() throws Exception {
        Log.info("******CLICK ON DEALS*******");
        page.clickOnDeals();
    }
	
	@Then("Check the result for tee time")
	public void Check_the_result() throws Exception {
		Log.info("******CHECK THE RESULT FOR TEE TIME*******");
		page.verifyResultForDeals();
	}

	@Then("Verify result course info")
	public void verifyResultCourseInfo() {
		Log.info("******VERIFY RESULT COURSE INFO*******");
	}

	@Then("Verify Back to courses text link is displayed")
	public void verifyBackToCoursesTextLinkIsDisplayed() throws Exception {
		Log.info("******VERIFY BACK COURSES IS DISPLAYED*******");
		page.verifyBackToCourses();
	}

	@Then("Click on Back to courses text link")
	public void clickOnBackToCoursesTextLink() throws Exception {
		Log.info("******CLICK ON BACK TO COURSES*******");
		page.clickBackToCourses();
	}

	@Then("Verify FilterBy is present")
	public void verifyFilterByIsPresent() {
		Log.info("******VERIFY THE FILTERS PRESENT*******");
		//page.VerifyFilterByIsPresent();
	}

	@And("Verify Golfer reviews screen is opened")
	public void verifyGolferReviewsScreenIsOpened() {
	}
}
