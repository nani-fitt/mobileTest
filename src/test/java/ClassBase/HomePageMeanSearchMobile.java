package ClassBase;

import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class HomePageMeanSearchMobile {

	AppiumDriver<MobileElement> driver;
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

	@FindBy(css = "span[data-qa-file='FilterNumber']")
	WebElement playersNumber;

	@FindBy(css = "div[class='react-datepicker__week'] div")
	 List<WebElement> dateInto;

	@FindBy(css = "span[data-qa-file='GroupToggleButton']")
	List<WebElement> valuesButtons;

	@FindBy(css = "button[data-qa-file='CustomHeader']")
	 List<WebElement> nextMounth;

	@FindBy(css = "p[data-qa-file= 'SearchDropDown']")
	 List<WebElement> players;

	@FindBy(xpath = "ul[data-qa-node='Menu']")
	 WebElement listaPlayers;

	@FindBy(id = "location")
	 WebElement location;
	
	@FindBy(css = "div[class= 'react-datepicker__month-container']")
	private WebElement dataPickerOpen;

    @FindBy(css = "div[data-qa-file='SearchAutocomplete']")
    List<WebElement> autoSuggestionList;

	@FindBy(xpath = "//div[contains(@class, 'react-datepicker__week')]")
	List<WebElement> dateList;


	public HomePageMeanSearchMobile(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void MadeSearchCityorCourse(String city) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfAllElements(search));
		if (search.isDisplayed()) {
			search.click();
			search.sendKeys(city);
			Thread.sleep(2000);
		}
	}

	public void CurrentLocationMessage()
	{
		WebDriverWait wait= new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(autoSuggestionList.get(3)));
		Assert.assertEquals("Enable location services", autoSuggestionList.get(3).getText());
	}

	public void AutoSuggestion(String name) throws Exception {

		Thread.sleep(2000);
	    System.out.println("Size"+" "+ autoSuggestionList.size());
        System.out.println("Size"+" "+ autoSuggestionList.get(0).getText());
        for (int i=0; i< autoSuggestionList.size(); i++)
		{
			String value= autoSuggestionList.get(i).getText();
			if (value.equalsIgnoreCase(name))
			{
				WebElement auto= autoSuggestionList.get(i);
				WebDriverWait wait= new WebDriverWait(driver,20);
				wait.until(ExpectedConditions.elementToBeClickable(auto)).click();
				Thread.sleep(1000);
				break;
			}
		}
	}

	public void FechaMainSearch() throws Exception {

		try {
			Thread.sleep(3000);
			fecha.click();
			today = getCurrentDay();
			System.out.println("Today's number: " + today + "\n");
			Thread.sleep(2000);

		} catch (NoSuchElementException e) {

			System.out.println(e.toString());
		}

	}


	public void SelectDate(String fecha) throws Exception {

           Thread.sleep(2000);
		if (dataPickerOpen.isDisplayed()) {
			System.out.println("mouth" + " " + mes.get(1).getText());
			String text2 = mes.get(1).getText();
			String[] divTexto = text2.split(" ");
			String buscarMes = divTexto[0];
			System.out.println("text mouth" + " " + buscarMes);

			//picar fecha entrda por el usuario
			String[] fechaMes = fecha.split("/");
			String mouth = fechaMes[0];
			String day = fechaMes[1];
			System.out.println("Date compare" + " " + day);
			String year = fechaMes[2];

			while (!mouth.contains(buscarMes)) {

				try {
					WebDriverWait wait = new WebDriverWait(driver, 10);
					wait.until(ExpectedConditions.elementToBeClickable(nextMounth.get(1)));
					nextMounth.get(1).click();
					Thread.sleep(2000);
					String mes1 = mes.get(1).getText();
					String[] divTexto1 = mes1.split(" ");
					buscarMes = divTexto1[0];

				} catch (NoSuchElementException e) {
					// TODO: handle exception
				}
			}
			System.out.println("List date" + " " + dateList.size());
			for (int i = 0; i < dateList.size(); i++) {

				for (int j = 0; j < dateInto.size(); j++) {

					String classDate = dateInto.get(j).getAttribute("class");
					System.out.println("Date print" + " " + classDate);
					if (!classDate.contains("disabled")) {
						String date = dateInto.get(j).getText();
						if (date.equals(day)) {
							WebElement dateSelect = dateInto.get(j);
							WebDriverWait wait = new WebDriverWait(driver, 20);
							wait.until(ExpectedConditions.elementToBeClickable(dateSelect)).click();
							Thread.sleep(2000);
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
		int Todaymes = calendar.get(Calendar.MONTH);
		System.out.println("Today Int: " + dayToday + "\n");
		String today = Integer.toString(dayToday);
		return today;
	}

	public void ClickOnPlayers() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(players.get(1)));
		System.out.println("Players by defect" + " " + players.get(1).getText());
		Assert.assertEquals("Any", players.get(1).getText());
		players.get(1).click();
		Thread.sleep(2000);

	}
	public void ClickOnHoles() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(players.get(3)));
		System.out.println("Holes by defect" + players.get(3).getText());
		Assert.assertEquals("Any", players.get(3).getText());
		players.get(3).click();

	}

	public void EnterInvalidData(String invalidData) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfAllElements(search));
		search.click();
		if (search.isDisplayed()) {

			search.sendKeys(invalidData);
			Thread.sleep(2000);
			search.sendKeys(Keys.DOWN);
			Thread.sleep(1000);
			System.out.println("Error Message" + " " + autoSuggestionList.get(0).getText());

		}
	}

	public void CheckMessage() {
		Assert.assertEquals("We couldn't find results for your search", autoSuggestionList.get(2).getText());
	}

	public void CheckInvalidZipCodeMessage() {

		Assert.assertEquals("We couldn't find results for your search",
				autoSuggestionList.get(2).getText());
	}

	public void CheckLocationEnable() throws Exception {

		Thread.sleep(2000);
		String text = location.getText();
		String [] text1= text.split(",");
		System.out.println("Location enable" + " " + location.getText());
		System.out.println("Location enable" + " " + search.getAttribute("value"));
		String [] text2= search.getAttribute("value").split(",");
		Thread.sleep(2000);
	}

	public void CheckLocationDisable() {

		if (location.isDisplayed()) {
			String locat = location.getText();
			if (locat.contains(" ")) {
				System.out.println("Location is disable");
				Assert.assertEquals(" ", driver.findElement(By.xpath("//input[@id='input-2']")).getText());
			}
		}

	}
	public void ClickOnDoneButton() throws Exception {
		TeeTimeListingMobilePage page= new TeeTimeListingMobilePage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(page.searchButton.get(2))).click();
		Thread.sleep(3000);
	}

	public void SelectCartHoles(String cart) throws InterruptedException {

		Thread.sleep(2000);
		System.out.println("Size of the filters list"+ " "+ valuesButtons.size());
		for (int i=0; i<valuesButtons.size(); i++) {
			if(valuesButtons.get(i).getText().equals(cart)) {
				WebElement fil= valuesButtons.get(i);
				WebDriverWait wait = new WebDriverWait(driver, 20);
				wait.until(ExpectedConditions.elementToBeClickable(fil));
				fil.click();
				Thread.sleep(2000);
				break;
			}
		}
	}

	public void SelectFiltersPlayersMax(String number) throws Exception {
		String numberPresent = playersNumber.getText();
		if(numberPresent.equals("Any") && (!number.equals("Any"))) {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(maxAndMinIcon.get(1))).click();
			Thread.sleep(2000);

			String[] playersNum = playersNumber.getText().split(" ");
			int numberUser = Integer.parseInt(number);
			int numberPres = Integer.parseInt(playersNum[0]);
			System.out.println("Number players" + " " + playersNum[0]);
			while (!(numberUser == numberPres)) {
				if (numberUser > numberPres) {
					wait.until(ExpectedConditions.elementToBeClickable(maxAndMinIcon.get(1))).click();
					Thread.sleep(2000);
					String[] players = playersNumber.getText().split(" ");
					numberPres = Integer.parseInt(players[0]);
				} else {
					wait.until(ExpectedConditions.elementToBeClickable(maxAndMinIcon.get(0))).click();
					Thread.sleep(2000);
					String[] players = playersNumber.getText().split(" ");
					numberPres = Integer.parseInt(players[0]);
				}
			}
		}
		String [] numberText = playersNumber.getText().split(" ");
		Assert.assertEquals(numberText[0], number);

	}



}
