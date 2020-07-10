package Util;


import java.util.List;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.common.base.Function;

public class UtilityWebMobile {

	AppiumDriver<MobileElement> driver;
	JavascriptExecutor ex;
	private static final int PAGE_WAIT_TIMEOUT_IN_SECONDS = 100;

	public void SelectElement(By locator, String texto) {

		Select lista = new Select(driver.findElement(locator));
		lista.selectByValue(texto);

	}


	public void ScrollFinalPage(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);

	}

	// --------------------Scrolling down on the
	// webpage-----------------------------------

	public void ScrollVentanaDown() throws Exception {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0, 250)");
		Thread.sleep(5000);

	}
	// --------------------Scrolling up on the
	// webpage-----------------------------------

	public void ScrollVentanaUp() throws Exception {

		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,-300)");
		Thread.sleep(5000);

	}

	// ------------------Esperar porque cargue el query---------------------

	protected void waitForJQueryLoad() {
		WebDriverWait jsWait = new WebDriverWait(driver, 10);
		try {
			ExpectedCondition<Boolean> jQueryLoad = driver -> ((Long) ((JavascriptExecutor) this.driver)
					.executeScript("return jQuery.active") == 0);

			boolean jqueryReady = (Boolean) ex.executeScript("return jQuery.active==0");

			if (!jqueryReady) {
				jsWait.until(jQueryLoad);
			}
		} catch (WebDriverException ignored) {
		}
	}

	// ----------------------Esperar porque cargue la pagina
	// completa--------------------------

	public void waitCompleteLoadPage() {
		new WebDriverWait(driver, PAGE_WAIT_TIMEOUT_IN_SECONDS).until(webDriver -> ((JavascriptExecutor) webDriver)
				.executeScript("return document.readyState").equals("complete"));
	}

	// esperar por el
	// elemento--------------------------------------------------------------

	public void waitForElement(final By by, final int timeoutInSeconds) {
		final WebDriverWait wait = new WebDriverWait(this.driver, timeoutInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	// ------------------esperar porque cargue la pagina---------------------

	public void waitForPageLoad() {
		waitForElement(By.tagName("html"), PAGE_WAIT_TIMEOUT_IN_SECONDS);
	}

	///// -------------------------------DOM-------------------------------------------------

	public WebElement isElementPresnt(WebDriver driver, String xpath, int time) {
		
		WebElement ele = null;

		for (int i = 0; i < time; i++) {
			try {
				ele = driver.findElement(By.xpath(xpath));
				break;
			} catch (Exception e) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					System.out.println("Waiting for element to appear on DOM");
				}
			}

		}
		return ele;

	}

	//// ------------stale element----------------------------------

	public void StaleElement(By locator) {
		boolean staleElement = true;

		while (staleElement) {

			try {

				driver.findElement(locator).click();

				staleElement = false;

			} catch (StaleElementReferenceException e) {

				staleElement = true;

			}

		}
	}

	////////////////// ---------------verificar el elemento si
	////////////////// esta--------------------/////////////////

	public void assertAndVerifyElement(By element) throws InterruptedException {
		boolean isPresent = false;

		for (int i = 0; i < 5; i++) {
			try {
				if (driver.findElement(element) != null) {
					isPresent = true;
					break;
				}
			} catch (Exception e) {
				// System.out.println(e.getLocalizedMessage());
				Thread.sleep(1000);
			}
		}
		Assert.assertTrue(isPresent, "\"" + element + "\" is not present.");

	}

	////////////////////////// present
	////////////////////////// element--------------------------------------------------------------

	public Function<WebDriver, WebElement> presenceOfElementLocated(final By locator) {
		return new Function<WebDriver, WebElement>() {
			@Override
			public WebElement apply(WebDriver driver) {
				return driver.findElement(locator);
			}
		};
	}


}
