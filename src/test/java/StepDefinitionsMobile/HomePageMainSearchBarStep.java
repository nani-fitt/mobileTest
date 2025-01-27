package StepDefinitionsMobile;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import ClassBase.HomePageMeanSearchMobile;
import Util.PropertyHelper;
import Util.TestBase;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageMainSearchBarStep extends TestBase {

	HomePageMeanSearchMobile page = new HomePageMeanSearchMobile(driver);
	Properties p = PropertyHelper.loadData();

	@Then("Show current location")
	public void show_current_location() throws Exception {
		//Log.info("******SHOW CURRENT LOCATION*******");
		page.checkLocationEnable();

	}

	@Then("Enter current location")
	public void enter_a_course() throws Exception {
		//Log.info("******ENTER CURRENT LOCATION*******");
		page.madeSearchCityorCourse("Current Location");

	}

	@Then("Show a error message for current location")
	public void show_a_error_message() throws InterruptedException {
		//Log.info("******SHOW THE ERROR MESSAGE*******");
        page.currentLocationMessage();

	}

	@When("Enter a course in the search field")
	public void enter_a_course_in_the_search_field(DataTable dataTable) throws Exception {
		//Log.info("******CHECK THE SUGGESTION COURSE*******");
		List<String> course = dataTable.asList();
		String focus1= p.getProperty(course.get(0));
		page.madeSearchCityorCourse(focus1);

	}

	@Then("Show the courses list suggestions")
	public void show_the_list_suggestions(DataTable dataTable) throws Exception {
		//Log.info("******SELECT THE COURSE*******");
		List<String> data = dataTable.asList();
		String auto= p.getProperty(data.get(0));
		page.autoSuggestion(auto);
		validateWindows();
	}

	@When("Enter a city in the search field")
	public void enter_a_city_in_the_search_field(DataTable dataTable) throws Exception {
		//Log.info("******CHECK THE SUGGESTION CITY*******");
		List<String> city = dataTable.asList();
		String auto= p.getProperty(city.get(0));
		page.madeSearchCityorCourse(auto);

	}

	@Then("Show the city list suggestions")
	public void showCitySuggestions(DataTable dataTable) throws Exception {
		//Log.info("******SELECT THE CITY*******");
		List<String> data = dataTable.asList();
		String auto= p.getProperty(data.get(0));
		page.autoSuggestion(auto);
	}

	@When("Verify the current date")
	public void verify_the_current_date() throws Exception {
	//	Log.info("******CLICK ON CALENDAR BUTTON*******");
		page.fechaMainSearch();
	}

	@Then("Select one day")
	public void select_one_day(DataTable dataTable) throws Exception {
	//	Log.info("******SELECT DATE*******");
		List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> data : list) {
			String fecha= p.getProperty(data.get("Date"));
			page.selectDate(fecha);
		}
	}

	@When("Enter city or course invalid")
	public void enterCityCourseInvalid(DataTable dataTable) throws Exception {
	//	Log.info("******ENTER INVALID CITY OR COURSE*******");
		List<String> city = dataTable.asList();
		String cit= p.getProperty(city.get(0));
		page.enterInvalidData(cit);

	}

	@Then("Show the error message")
	public void showMessage() throws Exception {
	//	Log.info("******CHECK THE ERROR MESSAGE*******");
		page.checkMessage();

	}

	@When("Enter zip code invalid")
	public void enterZipCodeInvalid(DataTable dataTable) throws Exception {
	//	Log.info("******ENTER INVALID ZIP CODE*******");
		List<String> zipcode = dataTable.asList();
		String zip= p.getProperty(zipcode.get(0));
		page.enterInvalidData(zip);

	}

	@Then("Show zip code message error")
	public void showMessageZipCode() throws Exception {
	//	Log.info("******SHOW THE ERROR MESSAGE WHEN THE ZIP CODE IS INVALID*******");
		page.checkInvalidZipCodeMessage();

	}

	@Then("Select Done button")
	public void selectDoneButton() throws Exception {
	//	Log.info("******SELECT DONE BUTTON*******");
		page.clickOnDoneButton();
	}

	@Then("Select the option Players")
	public void selectTheOptionPlayers() throws Exception {
	//	Log.info("******SELECT PLAYERS OPTION*******");
		page.clickOnPlayers();
	}

    @When("Select number of Players desired")
    public void selectNumberOfPlayersDesired(DataTable datatable) throws Exception {
	//	Log.info("******SELECT PLAYERS DESIRED*******");
		List<String> data= datatable.asList();
		Properties p= PropertyHelper.loadData();
		String numberPlayers= p.getProperty(data.get(0));
		page.selectFiltersPlayersMax(numberPlayers);
    }

    @And("Click on holes option")
    public void clickOnHolesOption() throws Exception {
	//	Log.info("******SELECT HOLES OPTION*******");
		page.clickOnHoles();
    }

    @And("Select the option Holes")
    public void selectTheOptionHoles(DataTable dataTable) throws InterruptedException {
	//	Log.info("*******SELECT NUMBER HOLES DESIRED*******");
		List<String> data= dataTable.asList();
		Properties p= PropertyHelper.loadData();
		String numberHoles= p.getProperty(data.get(0));
		page.selectCartHoles(numberHoles);
    }
}
