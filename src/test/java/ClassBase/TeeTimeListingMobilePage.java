package ClassBase;


import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import Util.UtilityWebMobile;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TeeTimeListingMobilePage {

    AppiumDriver<WebElement> driver;

    @FindBy(css = "button[data-qa-file='StandardButton']")
    List<WebElement> searchButton;

    @FindBy(css = "button[data-qa-file='FiltersBar']")
    List<WebElement> sortByFiltersMap;

    @FindBy(css = "h1[data-qa-file='InfoCourse']")
    WebElement dataCourse;

    @FindBy(css = "button[data-qa-file='CourseTimeSlots']")
    List<WebElement> addressCourse;

    @FindBy(css = "button[data-qa-file='InfoCourse']")
     WebElement backCourses;

    @FindBy(css = "button[data-qa-file='CourseHeader']")
    List<WebElement> courseInfo;

    @FindBy(css = "div[data-qa-file='CourseTileInfo']")
    List<WebElement> courseMapView;

    @FindBy(css = "button[data-qa-file='ShortRatingsReviewsTeeTime']")
     WebElement reviewsLink;

    @FindBy(css = "p[data-qa-file='FavoriteTeeTime']")
     WebElement favoriteIcon;

    @FindBy(css = "p[data-qa-file='PriceAlertTeeTime']")
     WebElement alertIcon;

    @FindBy(css = "div[data-qa-file='TimeSlots']")
    List<WebElement> teeTime;

    @FindBy(css = "p[class*='inline-flex pl-1 text-xs leading-large quantity-players']")
    List<WebElement> playersList;

    @FindBy(css = "p[class*='inline-flex pl-1 text-xs leading-large holes-amenity']")
    List<WebElement> holesList;

    @FindBy(css = "p[data-qa-file='NotFoundList']")
    List<WebElement> messageTeeTimeEmpty;

    @FindBy(id = "right-arrow")
    WebElement nextIcon;

    @FindBy(id = "left-arrow")
    WebElement previousIcon;

    @FindBy(css = "button[data-qa-file='FiltersButton']")
     WebElement filterBy;

    @FindBy(css = "p[data-qa-file='FiltersList']")
    List<WebElement> filtersAll;

    @FindBy(id = "date")
     WebElement date;

    public TeeTimeListingMobilePage(AppiumDriver<WebElement> driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnSearchButton() throws Exception {
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, 80);
        wait.until(ExpectedConditions.visibilityOfAllElements(searchButton.get(0)));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", searchButton.get(0));
        Thread.sleep(8000);
    }

    public void verifySortBy() throws Exception {
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfAllElements(sortByFiltersMap.get(0)));
        Assert.assertTrue(sortByFiltersMap.get(0).isDisplayed());
    }

    public void verifyMap() throws Exception {
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfAllElements(sortByFiltersMap.get(1)));
        Assert.assertTrue(sortByFiltersMap.get(1).isDisplayed());
    }

    public void verifyNameAndAddress(String course, String addres) throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertEquals(dataCourse.getText(), course);
        Assert.assertEquals(addressCourse.get(1).getText(), addres);
    }

    public void verifyCourseInfo() throws Exception {
        Thread.sleep(5000);
        System.out.println("Text course" + " " + courseInfo.get(1).getText());
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.textToBePresentInElement(courseInfo.get(1), "Course Info"));

    }

    public void clickOnCourseInfo() throws Exception {
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.elementToBeClickable(courseInfo.get(1))).click();
        Thread.sleep(3000);
    }

    public void verifyGolferReviewsLink() throws InterruptedException {
        Thread.sleep(5000);
        reviewsLink.isDisplayed();
        Assert.assertTrue(reviewsLink.isDisplayed());
    }

    public void verifyFavoriteIcon() throws InterruptedException {
        Thread.sleep(5000);
        boolean icon = favoriteIcon.isDisplayed();
        Assert.assertTrue(icon);
    }

    public void clickOnFavoriteIcon() throws Exception {
        Thread.sleep(5000);
        String text = favoriteIcon.getText();
        System.out.println("Text" + " " + text);
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.elementToBeClickable(favoriteIcon)).click();
        Thread.sleep(5000);
        System.out.println("Intoo");

    }

    public void verifyFavorite() throws InterruptedException {
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.textToBePresentInElement(favoriteIcon, "Save"));
        String saved = favoriteIcon.getText();
        System.out.println("See" + " " + saved);

    }

    public void verifyAlertIcon() throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertTrue(alertIcon.isDisplayed());
    }

    public void clickOnAlertIcon() throws Exception {
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.elementToBeClickable(alertIcon)).click();
        Thread.sleep(4000);
    }

    public void clickOnGolferReviewsLink() throws Exception {
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.elementToBeClickable(reviewsLink)).click();
        Thread.sleep(2000);

    }

    public void MadeAnotherSearchPlayers(String players) throws Exception {

        HomePageMeanSearchMobile page = new HomePageMeanSearchMobile(driver);
        page.clickOnPlayers();
     //   page.SelectPlayers(players);
        Thread.sleep(5000);
    }

    public void MadeAnotherSearchHoles(String holes) throws Exception {

        HomePageMeanSearchMobile page = new HomePageMeanSearchMobile(driver);
        page.clickOnHoles();
       // page.SelectPlayers(holes);
        Thread.sleep(5000);
    }

    public void verifyResultForTheSearchPlayers(String players) throws Exception {
        UtilityWebMobile page = new UtilityWebMobile();
        HomePageMobilePage home= new HomePageMobilePage(driver);
        if (teeTime.size() > 1) {
            if (players.contains("Four") || players.contains("4")) {
                page.ScrollFinalPage(home.footer.get(1));
                Thread.sleep(4000);
                page.ScrollFinalPage(filterBy);
                System.out.println("Size list" + " " + teeTime.size());
                System.out.println("Sublist" + " " + playersList.size());
               Assert.assertFalse(playersList.stream().anyMatch(webElement -> webElement.getText().contains("1-3") ||
                        webElement.getText().contains("1-2")));

            } else if (players.contains("Three") || players.contains("3")) {
                page.ScrollFinalPage(home.footer.get(1));
                Thread.sleep(4000);
                page.ScrollFinalPage(filterBy);
                System.out.println("Size list" + " " + teeTime.size());
                System.out.println("Sublist" + " " + playersList.size());
                Assert.assertFalse(playersList.stream().anyMatch(webElement -> webElement.getText().contains("1") ||
                        webElement.getText().contains("1-2")));

            } else if (players.contains("Five") || players.contains("5")) {
                page.ScrollFinalPage(home.footer.get(1));
                Thread.sleep(4000);
                page.ScrollFinalPage(filterBy);
                System.out.println("Size list" + " " + teeTime.size());

                Assert.assertFalse(playersList.stream().anyMatch(webElement -> webElement.getText().contains("1-4") ||
                        webElement.getText().contains("1-3") || webElement.getText().contains("1-2") ||
                        webElement.getText().contains("1")));

            } else if (players.contains("Six") || players.contains("6")) {
                page.ScrollFinalPage(home.footer.get(1));
                Thread.sleep(4000);
                page.ScrollFinalPage(filterBy);
                System.out.println("Size list" + " " + teeTime.size());
                System.out.println("Sublist" + " " + playersList.size());

               Assert.assertFalse( playersList.stream().anyMatch(webElement -> webElement.getText().contains("1-4") ||
                        webElement.getText().contains("1-3") || webElement.getText().contains("1-2") ||
                        webElement.getText().contains("1") || webElement.getText().contains("1-4")));
            }
            else if (players.contains("Two") || players.contains("2")) {
                page.ScrollFinalPage(home.footer.get(1));
                Thread.sleep(4000);
                page.ScrollFinalPage(filterBy);
                System.out.println("Size list" + " " + teeTime.size());
                System.out.println("Sublist" + " " + playersList.size());

                Assert.assertFalse( playersList.stream().anyMatch(webElement -> webElement.getText().contains("1")));
            }
        } else
            Assert.assertEquals(messageTeeTimeEmpty.get(1).getText(),
                    "There are currently no results for your search. Try adjusting your filters, then search again.");
    }

    public void verifyResultForTheSearchHoles(String holes) throws Exception {
        UtilityWebMobile page = new UtilityWebMobile();
        HomePageMobilePage home= new HomePageMobilePage(driver);
        if (teeTime.size() > 1) {
            if (holes.contains("9")) {
                page.ScrollFinalPage(home.footer.get(1));
                Thread.sleep(4000);
                page.ScrollFinalPage(filterBy);
                System.out.println("Size of the list" + " " + teeTime.size());
                System.out.println("Sublist" + " " + holesList.size());
                Assert.assertFalse(holesList.stream().anyMatch(webElement -> webElement.getText().contains("18")));

            } else {
                if (holes.contains("18")) {
                    page.ScrollFinalPage(home.footer.get(1));
                    Thread.sleep(4000);
                    page.ScrollFinalPage(filterBy);
                    System.out.println("Size of the list" + " " + teeTime.size());
                    System.out.println("Sublist" + " " + holesList.size());
                    Assert.assertFalse(holesList.stream().anyMatch(webElement -> webElement.getText().contains("9")));
                }
            }
        }
        else
            Assert.assertEquals(messageTeeTimeEmpty.get(1).getText(),
                    "There are currently no results for your search. Try adjusting your filters, then search again.");
    }

    public void verifyNextIconIsPresent() throws InterruptedException {
        Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        Assert.assertTrue(nextIcon.isDisplayed());

    }

    public void clickOnNextIcon() throws Exception {
        Thread.sleep(5000);
        String check = date.getText();
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.elementToBeClickable(nextIcon)).click();
        Thread.sleep(2000);
        String check1 = date.getText();
        Assert.assertNotEquals(check, check1);
    }

    public void clickOnPreviousIcon() throws Exception {

        String check = date.getText();
        System.out.println("Day of the system" + " " + check);
        String[] mesdate = check.split(",");
        System.out.println("Mounth and date" + " " + mesdate[1]);
        String mesActual = mesdate[1];
        Date fecha = new Date();
        Month mes = LocalDate.now().getMonth();
        String nombre = mes.getDisplayName(TextStyle.FULL, new Locale("en", "EN"));

        // Convierte a mayúscula la primera letra del nombre.
        String primeraLetra = nombre.substring(0, 1);
        String mayuscula = primeraLetra.toUpperCase();
        String demasLetras = nombre.substring(1, nombre.length());
        nombre = mayuscula + demasLetras;

        // Devuelve el dia actual
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        int dayToday = calendar.get(Calendar.DAY_OF_MONTH);
        String today = Integer.toString(dayToday);
        String compare = nombre + " " + today;
        System.out.println("Mes" + " " + compare);

        if (mesActual.contains(compare)) {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.elementToBeClickable(previousIcon)).click();
            Thread.sleep(2000);
            System.out.println("Entro");
            String verifydate = date.getText();
            Assert.assertEquals(check, verifydate);

        }
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(previousIcon)).click();
        Thread.sleep(2000);

    }

    public void verifyPreviousIconIsPresent() throws InterruptedException {
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, 80);
        wait.until(ExpectedConditions.visibilityOfAllElements(previousIcon));
        previousIcon.isDisplayed();
    }


    public void verifyFilterByIsPresent() throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertTrue(filterBy.isDisplayed());
        Assert.assertEquals(filterBy.getText(), "Filters");
        Assert.assertEquals(filtersAll.get(1).getText(), "Players");
        Assert.assertEquals(filtersAll.get(2).getText(), "Price");
        Assert.assertEquals(filtersAll.get(3).getText(), "Time");
        Assert.assertEquals(filtersAll.get(4).getText(), "Holes");
        Assert.assertEquals(filtersAll.get(5).getText(), "Cart");
        Assert.assertEquals(filtersAll.get(6).getText(), "Rate Type");
    }

    public void clickBackToCourses() throws Exception {
         Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.elementToBeClickable(backCourses)).click();
        Thread.sleep(4000);
    }

    public void verifyBackToCourses() throws Exception {
        Thread.sleep(5000);
        Assert.assertEquals(backCourses.getText(), "Back to Courses");
    }

}
