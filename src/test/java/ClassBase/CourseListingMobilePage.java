package ClassBase;


import java.util.List;

import Util.UtilityWebMobile;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
public class CourseListingMobilePage {

	AppiumDriver<MobileElement> driver;


	@FindBy(css = "div[data-qa-file='CourseList']")
	List<WebElement> coursesList;

	@FindBy(css = "button[data-qa-file='SearchHolderForm']")
	WebElement searchButtonCourse;

	@FindBy(css = "p[data-qa-file='CourseList']")
	List<WebElement> messageTeeTimeEmpty;

	@FindBy(css= "button[data-qa-file='MapZoomControl']")
	List<WebElement> maxViewMap;

	@FindBy(css = "span[data-qa-file='Courses']")
	List<WebElement> nameCourseHeader;


	public CourseListingMobilePage(AppiumDriver<MobileElement> driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	public void verifyTheResultForDealsCourses() throws Exception {
        Thread.sleep(4000);
		UtilityWebMobile page= new UtilityWebMobile();
		TeeTimeListingMobilePage teeTime= new TeeTimeListingMobilePage(driver);
		
		if (coursesList.size() >=1) {
			page.ScrollFinalPage(teeTime.linkSection);
			Thread.sleep(4000);
			page.ScrollFinalPage(teeTime.dealsOnly);
			System.out.println("Size of list" + " " + coursesList.size());

			if (coursesList.size() == 1) {

				boolean deals = coursesList.get(0)
						.findElement(By.cssSelector("div[data-qa-file='CourseTileInfo'] img")).getAttribute("alt").equals("Lightning Deals");
				System.out.println("Present deals" + " " + deals);
				Assert.assertTrue(deals);

			} else {
				for (WebElement webElement : coursesList) {

					boolean deals = webElement
							.findElement(By.cssSelector("div[data-qa-file='CourseTileInfo'] img")).getAttribute("alt").equals("Lightning Deals");
					System.out.println("Present deals" + " " + deals);
					Assert.assertTrue(deals);
				}
			}

		} else
			Assert.assertEquals(messageTeeTimeEmpty.get(1).getText(),
					"There are currently no results for your search. Try adjusting your filters, then search again.");

	}

	public void clickOnMapView() throws Exception {
		TeeTimeListingMobilePage page = new TeeTimeListingMobilePage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 80);
		wait.until(ExpectedConditions.elementToBeClickable(page.sortByFiltersMap.get(1))).click();
		Thread.sleep(3000);
	}

	public void errorMessageLocationDisable() {
		
		Assert.assertEquals(messageTeeTimeEmpty.get(1).getText(),
				"There are currently no results for your search. Try adjusting your filters, then search again.");

	}

	public void verifyMaxView() throws Exception {
        Thread.sleep(6000);
		WebDriverWait wait = new WebDriverWait(driver, 80);
		wait.until(ExpectedConditions.elementToBeClickable(maxViewMap.get(0))).click();
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		act.doubleClick(maxViewMap.get(0)).build().perform();
		Thread.sleep(2000);
	}

	public void verifyMinView() throws Exception {
        Thread.sleep(6000);
		WebDriverWait wait = new WebDriverWait(driver, 80);
		wait.until(ExpectedConditions.elementToBeClickable(maxViewMap.get(1))).click();
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		act.doubleClick(maxViewMap.get(1)).build().perform();
	}

	public void verifyTheData() throws InterruptedException {
		Thread.sleep(6000);
		Assert.assertTrue(nameCourseHeader.get(0).isDisplayed());
		Assert.assertTrue(nameCourseHeader.get(1).isDisplayed());
	}

	public void selectCourseMap() throws InterruptedException {
		Thread.sleep(6000);
		TeeTimeListingMobilePage page= new TeeTimeListingMobilePage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 80);
		wait.until(ExpectedConditions.elementToBeClickable(page.courseMapView.get(0))).click();
		Thread.sleep(4000);
	}
	public void clickOnSearchField() throws InterruptedException {
		Thread.sleep(6000);
		WebDriverWait wait = new WebDriverWait(driver, 80);
		wait.until(ExpectedConditions.elementToBeClickable(searchButtonCourse)).click();
		Thread.sleep(3000);
	}

	public void verifyCourseList() throws InterruptedException {
		Thread.sleep(5000);
		if(!coursesList.isEmpty())
		{
			System.out.println("Exist courses for the search made it"+ " "+ coursesList.size());
		}
		else
		{
			Assert.assertTrue(messageTeeTimeEmpty.get(0).isDisplayed());
		}
	}


}
