package ClassBase;

import java.sql.Time;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;


public class HomePageMeanSearchMobile {

	AppiumDriver<WebElement> driver;
	private String today;

	@FindBy(xpath = "//input[@placeholder=\"Select any course, city, or zip\"]")
	 WebElement search;

	@FindBy(css = "input[data-qa-file='CustomInput']")
	 WebElement fecha;

	@FindBy(css = "button[data-qa-file='FilterNumber']")
	List<WebElement> maxAndMinIcon;

	@FindBy(className = "react-datepicker__week")
	 WebElement date;

	@FindBy(css = "span[data-qa-file='CustomHeader']")
	 List<WebElement> mes;

	@FindBy(css = "div[data-qa-file='FilterNumber']")
	WebElement playersNumber;

	@FindBy(css = "div[class='react-datepicker__week'] div")
	 List<WebElement> dateInto;

	@FindBy(css = "span[data-qa-file='GroupToggleButton']")
	List<WebElement> valuesButtons;

	@FindBy(id = "plus-button")
	WebElement nextMounth;

	@FindBy(id = "min-button")
	WebElement previuosMounth;

	@FindBy(id = "plus-button")
	WebElement maxPlayers;

	@FindBy(id = "minus-button")
	WebElement lessPlayers;

	@FindBy(css = "p[data-qa-file= 'SearchDropDown']")
	 List<WebElement> players;

	@FindBy(id = "location")
	 WebElement location;
	
	@FindBy(css = "div[class= 'react-datepicker__month-container']")
	WebElement dataPickerOpen;

    @FindBy(css = "div[data-qa-file='SearchAutocomplete']")
    List<WebElement> autoSuggestionList;

	@FindBy(xpath = "//div[contains(@class, 'react-datepicker__week')]")
	List<WebElement> dateList;


	public HomePageMeanSearchMobile(AppiumDriver<WebElement> driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void madeSearchCityorCourse(String city) throws Exception {
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 80);
		wait.until(ExpectedConditions.visibilityOfAllElements(search));
		if (search.isDisplayed()) {
			search.click();
			search.sendKeys(city);
			Thread.sleep(2000);
		}
	}

	public void currentLocationMessage() throws InterruptedException {
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		Assert.assertEquals("Enable location services", autoSuggestionList.get(3).getText());
	}

	public void autoSuggestion(String name) throws Exception {
		Thread.sleep(5000);
	    System.out.println("Size"+" "+ autoSuggestionList.size());
        System.out.println("Size"+" "+ autoSuggestionList.get(0).getText());
		for (WebElement webElement : autoSuggestionList) {
			String value = webElement.getText();
			if (value.equalsIgnoreCase(name)) {
				WebDriverWait wait = new WebDriverWait(driver, 60);
				wait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
				Thread.sleep(1000);
				break;
			}
		}
	}

	public void fechaMainSearch() throws Exception {
		try {
			Thread.sleep(5000);
			fecha.click();
			today = getCurrentDay();
			System.out.println("Today's number: " + today + "\n");
			Thread.sleep(2000);
		} catch (NoSuchElementException e) {
			System.out.println(e.toString());
		}

	}


	public void selectDate(String fecha) throws Exception {
           Thread.sleep(8000);
		if (dataPickerOpen.isDisplayed()) {
			System.out.println("mouth" + " " + mes.get(1).getText());
			String text2 = mes.get(1).getText();
			System.out.println("text mouth" + " " + text2);
			//picar fecha entrda por el usuario
			String[] fechaMes = fecha.split("/");
			String mouth = fechaMes[0];
			String day = fechaMes[1];
			System.out.println("Date compare" + " " + day);
			while (!mouth.contains(text2)) {
				try {
					WebDriverWait wait = new WebDriverWait(driver, 50);
					wait.until(ExpectedConditions.elementToBeClickable(nextMounth)).click();
					Thread.sleep(3000);
					text2 = mes.get(1).getText();

				} catch (NoSuchElementException e) {
					// TODO: handle exception
				}
			}
			System.out.println("List date" + " " + dateList.size());
			for (int i = 0; i < dateList.size(); i++) {
				for (WebElement webElement : dateInto) {
					String classDate = webElement.getAttribute("class");
					System.out.println("Date print" + " " + classDate);
					if (!classDate.contains("disabled")) {
						String date = webElement.getText();
						if (date.equals(day)) {
							WebDriverWait wait = new WebDriverWait(driver, 50);
							wait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
							Thread.sleep(5000);
							break;
						}
					}
				}
			}
		}
	}

	private String getCurrentDay() {
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
		int dayToday = calendar.get(Calendar.DAY_OF_MONTH);
		System.out.println("Today Int: " + dayToday + "\n");
		return Integer.toString(dayToday);
	}

	public void clickOnPlayers() throws Exception {
        Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		System.out.println("Players by defect" + " " + players.get(1).getText());
		Assert.assertEquals("Any", players.get(1).getText());
		players.get(1).click();
		Thread.sleep(3000);

	}
	public void clickOnHoles() throws Exception {
        Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		System.out.println("Holes by defect" + players.get(3).getText());
		Assert.assertEquals("Any", players.get(3).getText());
		players.get(3).click();

	}

	public void enterInvalidData(String invalidData) throws Exception {
        Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		search.click();
		if (search.isDisplayed()) {
			search.sendKeys(invalidData);
			Thread.sleep(3000);
			search.sendKeys(Keys.DOWN);
			Thread.sleep(2000);
			System.out.println("Error Message" + " " + autoSuggestionList.get(0).getText());
		}
	}

	public void checkMessage() throws InterruptedException {
		Thread.sleep(8000);
		Assert.assertEquals("We couldn't find results for your search", autoSuggestionList.get(2).getText());
	}

	public void checkInvalidZipCodeMessage() throws InterruptedException {
        Thread.sleep(8000);
		Assert.assertEquals("We couldn't find results for your search",
				autoSuggestionList.get(2).getText());
	}

	public void checkLocationEnable() throws Exception {
		Thread.sleep(5000);
		String text = location.getText();
		String [] text1= text.split(",");
		System.out.println("Location enable" + " " + location.getText());
		System.out.println("Location enable" + " " + search.getAttribute("value"));
		String [] text2= search.getAttribute("value").split(",");
		Thread.sleep(3000);
	}

	public void checkLocationDisable() throws InterruptedException {
           Thread.sleep(5000);
		if (location.isDisplayed()) {
			String locat = location.getText();
			if (locat.contains(" ")) {
				System.out.println("Location is disable");
				Assert.assertEquals(" ", driver.findElement(By.xpath("//input[@id='input-2']")).getText());
			}
		}

	}
	public void clickOnDoneButton() throws Exception {
		Thread.sleep(5000);
		TeeTimeListingMobilePage page= new TeeTimeListingMobilePage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 80);
		if(page.searchButton.size()==4)
		wait.until(ExpectedConditions.elementToBeClickable(page.searchButton.get(3))).click();
		else
		wait.until(ExpectedConditions.elementToBeClickable(page.searchButton.get(2))).click();
		Thread.sleep(3000);
	}

	public void selectCartHoles(String cart) throws InterruptedException {
		Thread.sleep(5000);
		System.out.println("Size of the filters list"+ " "+ valuesButtons.size());
		for (WebElement valuesButton : valuesButtons) {
			if (valuesButton.getText().equals(cart)) {
				WebDriverWait wait = new WebDriverWait(driver, 80);
				wait.until(ExpectedConditions.elementToBeClickable(valuesButton));
				valuesButton.click();
				Thread.sleep(3000);
				break;
			}
		}
	}

	public void selectFiltersPlayersMax(String number) throws Exception {
		String numberPresent = playersNumber.getText();
		System.out.println("numberPresent filters= " + numberPresent);
		WebDriverWait wait = new WebDriverWait(driver, 50);
		if(numberPresent.equals("Any") && (!number.equals("Any"))) {
			wait.until(ExpectedConditions.elementToBeClickable(maxPlayers)).click();
			Thread.sleep(3000);
		}
			String[] playersNum = playersNumber.getText().split(" ");
			int numberUser = Integer.parseInt(number);
			int numberPres = Integer.parseInt(playersNum[0]);
			System.out.println("Number players" + " " + playersNum[0]);
			while (!(numberUser == numberPres)) {
				if (numberUser > numberPres) {
					wait.until(ExpectedConditions.elementToBeClickable(maxPlayers)).click();
					Thread.sleep(3000);
					String[] players = playersNumber.getText().split(" ");
					numberPres = Integer.parseInt(players[0]);
				} else {
					wait.until(ExpectedConditions.elementToBeClickable(lessPlayers)).click();
					Thread.sleep(3000);
					String[] players = playersNumber.getText().split(" ");
					numberPres = Integer.parseInt(players[0]);
				}
			}
		String [] numberText = playersNumber.getText().split(" ");
		Assert.assertEquals(numberText[0], number);

	}
	public void verifyCurrentLocation() throws InterruptedException {
		Thread.sleep(8000);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		String valueSearch= search.getAttribute("value");
		Assert.assertEquals(valueSearch, "Current Location");
	}


}
