package StepDefinitionsMobile;

import ClassBase.CourseListingMobilePage;
import ClassBase.TeeTimeListingMobilePage;
import Util.Log;
import Util.TestBase;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CourseListingMobileStep extends TestBase {

	TeeTimeListingMobilePage page = new TeeTimeListingMobilePage(driver);
	CourseListingMobilePage course = new CourseListingMobilePage(driver);
	@When("Check Sort by dropdown is displayed")
	public void check_Sort_by_dropdown_is_displayed() throws Exception {
		Log.info("******VERIFY SORT BY IS PRESENT*******");
		page.VerifySortBy();
	}

	@Then("Verify the data for the courses is present")
	public void verify_the_data_for_the_courses_is_present() throws Exception {
		Log.info("******VERIFY THE DATA FOR COURSES IS PRESENT*******");
		course.VerifyTheData();

	}

	@Then("Check the result")
	public void check_the_result() throws Exception {
		Log.info("******VERIFY THE RESULT DEALS BUTTON*******");
		course.VerifyTheResultForDealsCourses();
	}

	@Then("Verify the next and previous button are displayed")
	public void verify_the_next_and_previous_button_are_displayed() {
		Log.info("******VERIFY NEXT AND PREVIOUS ICON PRESENT*******");
		page.VerifyNextIconIsPresent();
		page.VerifyPreviousIconIsPresent();
	}

	@Then("Click on next button")
	public void click_on_next_button() throws Exception {
		Log.info("******CLICK ON NEXT ICON*******");
		page.ClickOnNextIcon();
	}

	@Then("Click on previous button")
	public void click_on_previous_button() throws Exception {
		Log.info("******CLICK ON PREVIOUS ICON*******");
		page.ClickOnPreviousIcon();
	}

	@Then("Check number courses displayed")
	public void check_number_courses_displayed() throws Exception {
		Log.info("******NUMBER OF COURSES*******");
       page.VerifyResultForDeals();

	}


	@Then("Select the option map view")
	public void select_the_option_map_view() throws Exception {
		Log.info("******SELECT THE OPTION MAP VIEW*******");
		course.ClickOnMapView();
	}

	@Then("Verify the data for the filters are present")
	public void verify_the_data_for_the_filters_are_present() {
		Log.info("******VERIFY FILTERS ARE PRESENT*******");
		page.VerifyFilterByIsPresent();
	}

	@Then("Verify the message error is present")
	public void verify_the_message_error_is_present() {
		Log.info("******VERIFY THE MESSAGE FOR ERROR IS PRESENT*******");
		course.ErrorMessageLocationDisable();
	}

	@Then("Verify tee time page is displayed")
	public void verify_tee_time() throws Exception {
		Log.info("******VERIFY TEE TIME IS DISPLAYED*******");
		page.VerifyCourseInfo();
	}

	@Then("Select Max view")
	public void Select_Max_view() throws Exception {

		Log.info("******VERIFY MAX VIEW MAP IS CORRECT*******");
		course.VerifyMaxView();
	}

	@Then("Select Min view")
	public void Select_Min_view() throws Exception {
		Log.info("******VERIFY MIN VIEW MAP IS CORRECT*******");
		course.VerifyMinView();
	}


	@Then("Check Map button is present")
	public void checkMapButtonIsPresent() throws Exception {
		Log.info("******VERIFY MAP BUTTON IS PRESENT*******");
		page.VerifyMap();
	}

	@Then("Select a course in the map view")
	public void selectACourseInTheMapView() throws InterruptedException {
		Log.info("******SELECT COURSE MAP VIEW*******");
		course.SelectCourseMap();
	}

	@When("Click on search field")
	public void clickOnSearchField() throws InterruptedException {
		Log.info("******CLICK ON SEARCH FIELD COURSES*******");
		course.ClickOnSearchField();
	}

	@Then("Verify list of courses in the screen")
	public void verifyListOfCoursesInTheScreen() {
		Log.info("******LIST OF COURSES SCREEN PRESENT*******");
		course.VerifyCourseList();
	}
}
