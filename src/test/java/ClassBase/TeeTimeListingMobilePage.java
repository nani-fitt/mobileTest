package ClassBase;


import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import Util.UtilityWebMobile;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TeeTimeListingMobilePage {

    AppiumDriver<MobileElement> driver;

    @FindBy(css = "button[data-qa-file='StandardButton']")
    List<WebElement> searchButton;

    @FindBy(css = "section[data-qa-file='Footer']")
    WebElement linkSection;

    @FindBy(css = "button[data-qa-file='FiltersBar']")
    List<WebElement> sortByFiltersMap;

    @FindBy(css = "p[data-qa-file='InfoCourse']")
    WebElement dataCourse;

    @FindBy(css = "p[data-qa-file='CourseTimeSlots']")
    List<WebElement> addressCourse;

    @FindBy(css = "button[data-qa-file='InfoCourse']")
     WebElement backCourses;

    @FindBy(css = "button[data-qa-file='CourseHeader']")
    List<WebElement> courseInfo;

    @FindBy(css = "div[data-qa-file='CourseTileInfo']")
    List<WebElement> courseMapView;

    @FindBy(css = "button[data-qa-file='ShortRatingsReviewsTeeTime']")
    private WebElement reviewsLink;

    @FindBy(css = "p[data-qa-file='FavoriteTeeTime']")
    private WebElement favoriteIcon;

    @FindBy(css = "p[data-qa-file='PriceAlertTeeTime']")
    private WebElement alertIcon;

    @FindBy(css = "button[data-qa-file='ListHeaderFilters']")
    WebElement dealsOnly;

    @FindBy(css = "div[data-qa-file='TimeSlots']")
    List<WebElement> teeTime;

    @FindBy(css = "p[class*='inline-flex pl-1 text-xs text-slate-grey leading-large quantity-players']")
    List<WebElement> playersList;

    @FindBy(css = "p[class*='inline-flex pl-1 text-xs text-slate-grey leading-large holes-amenity']")
    List<WebElement> holesList;

    @FindBy(css = "p[class*='inline-flex pl-1 text-xs text-slate-grey leading-large card-name']")
    List<WebElement> cartList;

    @FindBy(css = "div[class*='inline-flex text-5 font-black text-navy tracking-hardest tee-time']")
    List<WebElement> timeList;

    @FindBy(css = "span[class*='inline-flex text-5 font-black text-navy tracking-hardest tee-starting-rate']")
    List<WebElement> priceList;

    @FindBy(css = "span[class*='flex bg-white rounded-3 border border-cloudy-blue px-2 w-fit-content text-center text-xs font-medium text-slate-grey tracking-fastened rates-available']")
    List<WebElement> rateList;

    @FindBy(css = "p[data-qa-file='TimeSlots']")
    List<WebElement> messageTeeTimeEmpty;

    @FindBy(css = "img[data-qa-file='DayNavigation']")
    List<WebElement> nextPreviousIcon;

    @FindBy(css = "p[data-qa-file='LeftFilterWrapper']")
    private WebElement filterBy;

    @FindBy(css = "p[data-qa-file='FiltersList']")
    List<WebElement> filtersAll;

    @FindBy(id = "date")
    private WebElement date;

    public TeeTimeListingMobilePage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void ClickOnSearchButton() throws Exception {

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfAllElements(searchButton.get(0)));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", searchButton.get(0));
        Thread.sleep(8000);
    }

    public void VerifySortBy() throws Exception {
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfAllElements(sortByFiltersMap.get(0)));
        Assert.assertTrue(sortByFiltersMap.get(0).isDisplayed());
    }

    public void VerifyMap() throws Exception {
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfAllElements(sortByFiltersMap.get(1)));
        Assert.assertTrue(sortByFiltersMap.get(1).isDisplayed());
    }

    public void VerifyNameAndAddress(String course, String addres) throws InterruptedException {

        Thread.sleep(2000);
        Assert.assertEquals(dataCourse.getText(), course);
        Assert.assertEquals(addressCourse.get(0).getText(), addres);
    }

    public void VerifyCourseInfo() throws Exception {
        Thread.sleep(2000);
        System.out.println("Text course" + " " + courseInfo.get(1).getText());
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.textToBePresentInElement(courseInfo.get(1), "Course Info"));

    }

    public void ClickOnCourseInfo() throws Exception {

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(courseInfo.get(1))).click();
        Thread.sleep(3000);
    }

    public void VerifyGolferReviewsLink() throws InterruptedException {
        Thread.sleep(2000);
        reviewsLink.isDisplayed();
        Assert.assertTrue(reviewsLink.isDisplayed());
    }

    public void VerifyFavoriteIcon() throws InterruptedException {

        Thread.sleep(3000);
        boolean icon = favoriteIcon.isDisplayed();
        Assert.assertTrue(icon);
    }

    public void ClickOnFavoriteIcon() throws Exception {

        String text = favoriteIcon.getText();
        System.out.println("Text" + " " + text);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(favoriteIcon)).click();
        Thread.sleep(5000);
        System.out.println("Intoo");

    }

    public void VerifyFavorite() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.textToBePresentInElement(favoriteIcon, "Save"));
        String saved = favoriteIcon.getText();
        System.out.println("See" + " " + saved);

    }

    public void VerifyAlertIcon() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(alertIcon.isDisplayed());
    }

    public void ClickOnAlertIcon() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(alertIcon)).click();
        Thread.sleep(4000);
    }

    public void ClickOnDeals() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(dealsOnly)).click();
        Thread.sleep(3000);
    }


    public void ClickOnGolferReviewsLink() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(reviewsLink)).click();
        Thread.sleep(2000);

    }

    public void MadeAnotherSearchPlayers(String players) throws Exception {

        HomePageMeanSearchMobile page = new HomePageMeanSearchMobile(driver);
        page.ClickOnPlayers();
     //   page.SelectPlayers(players);
        Thread.sleep(2000);
    }

    public void MadeAnotherSearchHoles(String holes) throws Exception {

        HomePageMeanSearchMobile page = new HomePageMeanSearchMobile(driver);
        page.ClickOnHoles();
       // page.SelectPlayers(holes);
        Thread.sleep(2000);
    }

    public void VerifyResultForTheSearchPlayers(String players) throws Exception {
        UtilityWebMobile page = new UtilityWebMobile();
        if (teeTime.size() > 1) {
            if (players.contains("Four") || players.contains("4")) {
                page.ScrollFinalPage(linkSection);
                Thread.sleep(4000);
                page.ScrollFinalPage(dealsOnly);
                System.out.println("Size list" + " " + teeTime.size());

                System.out.println("Sublist" + " " + playersList.size());

                for (int i = 0; i < playersList.size(); i++) {
                    System.out.println("Print---------------" + " " + playersList.get(i).getText());

                    if (playersList.get(i).getText().equalsIgnoreCase("1-3")
                            || playersList.get(i).getText().equalsIgnoreCase("1-2")
                            || playersList.get(i).getText().equalsIgnoreCase("1")) {

                        System.out.println("The number of players is incorrect");
                        Assert.assertEquals(playersList.get(i).getText(), "1-4");
                        break;

                    }
                }
            } else if (players.contains("Three") || players.contains("3")) {
                page.ScrollFinalPage(linkSection);
                Thread.sleep(4000);
                page.ScrollFinalPage(dealsOnly);
                System.out.println("Size list" + " " + teeTime.size());

                System.out.println("Sublist" + " " + playersList.size());
                for (int i = 0; i < playersList.size(); i++) {

                    System.out.println("Print---------------" + " " + playersList.get(i).getText());

                    if (playersList.get(i).getText().equalsIgnoreCase("1-2")
                            || playersList.get(i).getText().equalsIgnoreCase("1")) {

                        System.out.println("The number of players is incorrect");
                        Assert.assertEquals(playersList.get(i).getText(), "1-3");
                        break;

                    }

                }
            } else if (players.contains("Five") || players.contains("5")) {
                page.ScrollFinalPage(linkSection);
                Thread.sleep(4000);
                page.ScrollFinalPage(dealsOnly);
                System.out.println("Size list" + " " + teeTime.size());
                for (int i = 0; i < playersList.size(); i++) {

                    System.out.println("Print---------------" + " " + playersList.get(i).getText());

                    if (playersList.get(i).getText().equalsIgnoreCase("1-3")
                            || playersList.get(i).getText().equalsIgnoreCase("1-2")
                            || playersList.get(i).getText().equalsIgnoreCase("1-4")
                            || playersList.get(i).getText().equalsIgnoreCase("1")) {

                        System.out.println("The number of players is incorrect");
                        Assert.assertEquals(playersList.get(i).getText(), "1-5");
                        break;
                    }
                }
            } else if (players.contains("Six") || players.contains("6")) {
                page.ScrollFinalPage(linkSection);
                Thread.sleep(4000);
                page.ScrollFinalPage(dealsOnly);
                System.out.println("Size list" + " " + teeTime.size());
                System.out.println("Sublist" + " " + playersList.size());

                for (int i = 0; i < playersList.size(); i++) {

                    System.out.println("Print---------------" + " " + playersList.get(i).getText());

                    if (playersList.get(i).getText().equalsIgnoreCase("1-3")
                            || playersList.get(i).getText().equalsIgnoreCase("1-2")
                            || playersList.get(i).getText().equalsIgnoreCase("1-4")
                            || playersList.get(i).getText().equalsIgnoreCase("1-5")
                            || playersList.get(i).getText().equalsIgnoreCase("1")) {

                        System.out.println("The number of players is incorrect");
                        Assert.assertEquals(playersList.get(i).getText(), "1-6");
                        break;
                    }
                }
            }
        } else
            Assert.assertEquals(messageTeeTimeEmpty.get(1).getText(),
                    "There are currently no results for your search. Try adjusting your filters, then search again.");
    }

    public void VerifyResultForTheSearchHoles(String holes) throws Exception {

        UtilityWebMobile page = new UtilityWebMobile();
        if (teeTime.size() > 1) {
            if (holes.contains("9")) {
                page.ScrollFinalPage(linkSection);
                Thread.sleep(4000);
                page.ScrollFinalPage(dealsOnly);
                System.out.println("Size of the list" + " " + teeTime.size());
                System.out.println("Sublist" + " " + holesList.size());

                for (int i = 0; i < holesList.size(); i++) {

                    System.out.println("Element -------------" + " " + holesList.get(i).getText());

                    if (holesList.get(i).getText().contains("18")) {

                        System.out.println("The number of players is incorrect");
                        Assert.assertEquals(holesList.get(i).getText(), "9");
                        break;

                    }

                }
            } else {
                if (holes.contains("18")) {
                    page.ScrollFinalPage(linkSection);
                    Thread.sleep(4000);
                    page.ScrollFinalPage(dealsOnly);
                    System.out.println("Size of the list" + " " + teeTime.size());
                    System.out.println("Sublist" + " " + holesList.size());

                    for (int i = 0; i < holesList.size(); i++) {

                        System.out.println("Element -------------" + " " + holesList.get(i).getText());

                        if (holesList.get(i).getText().contains("9")) {

                            System.out.println("The number of players is incorrect");
                            Assert.assertEquals(holesList.get(i).getText(), "18");
                            break;
                        }
                    }
                }
            }
        } else
            Assert.assertEquals(messageTeeTimeEmpty.get(1).getText(),
                    "There are currently no results for your search. Try adjusting your filters, then search again.");

    }

    public void VerifyNextIconIsPresent() {

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfAllElements(nextPreviousIcon.get(2)));
        nextPreviousIcon.get(2).isDisplayed();
    }

    public void ClickOnNextIcon() throws Exception {

        String check = date.getText();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(nextPreviousIcon.get(2))).click();
        Thread.sleep(2000);
        String check1 = date.getText();
        Assert.assertNotEquals(check, check1);
    }

    public void ClickOnPreviousIcon() throws Exception {

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
            wait.until(ExpectedConditions.elementToBeClickable(nextPreviousIcon.get(0))).click();
            Thread.sleep(2000);
            System.out.println("Entro");
            String verifydate = date.getText();
            Assert.assertEquals(check, verifydate);

        }
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(nextPreviousIcon.get(0))).click();
        Thread.sleep(2000);

    }

    public void VerifyPreviousIconIsPresent() {

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfAllElements(nextPreviousIcon.get(0)));
        nextPreviousIcon.get(0).isDisplayed();
    }


    public void VerifyFilterByIsPresent() {

        Assert.assertTrue(filterBy.isDisplayed());
        Assert.assertEquals(filterBy.getText(), "Filters");
        Assert.assertEquals(filtersAll.get(1).getText(), "Players");
        Assert.assertEquals(filtersAll.get(2).getText(), "Price");
        Assert.assertEquals(filtersAll.get(3).getText(), "Time");
        Assert.assertEquals(filtersAll.get(4).getText(), "Holes");
        Assert.assertEquals(filtersAll.get(5).getText(), "Cart");
        Assert.assertEquals(filtersAll.get(6).getText(), "Rate Type");
    }

    public void VerifyResultForDeals() throws Exception {
        UtilityWebMobile page = new UtilityWebMobile();
        if (teeTime.size() > 1) {
            page.ScrollFinalPage(linkSection);
            Thread.sleep(4000);
            page.ScrollFinalPage(dealsOnly);
            System.out.println("Size of the list" + " " + teeTime.size());

            if (teeTime.size() == 1) {

                String deals = teeTime.get(0)
                        .findElements(By.cssSelector("p[class='pr-sm text-xs text-dark-grey leading-large tracking-fastened']"))
                        .get(0).getText();
                System.out.println("Present deals" + " " + deals);
                Assert.assertEquals(deals, "Deal");

            } else {
                for (int i = 0; i < teeTime.size(); i++) {

                    String deals = teeTime.get(i)
                            .findElements(
                                    By.cssSelector("p[class='pr-sm text-xs text-dark-grey leading-large tracking-fastened']"))
                            .get(0).getText();
                    System.out.println("Present deals" + " " + deals);
                    Assert.assertEquals(deals, "Deal");
                }
            }

        } else
            Assert.assertEquals(messageTeeTimeEmpty.get(1).getText(),
                    "There are currently no results for your search. Try adjusting your filters, then search again.");

    }

    public void ClickBackToCourses() throws Exception {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(backCourses)).click();
        Thread.sleep(4000);
    }

    public void VerifyBackToCourses() throws Exception {
        Assert.assertEquals(backCourses.getText(), "Back to Courses");
    }

}
