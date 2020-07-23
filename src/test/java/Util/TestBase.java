package Util;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;



public class TestBase {
    public static AppiumDriver<MobileElement>  driver;
    public static final String USERNAME = "codigodelsur1";
    public static final String AUTOMATE_KEY = "Nxj84iaayiTZ74XAxudv";
    public static final String url = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";


    public void selectBrowser(String browser) throws MalformedURLException, InterruptedException {

        if (browser.equals("Chrome")) {
            Log.info("OPEN CHROME BROWSER FOR ANDROID EMULATOR");
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "sdk_gphone_x86");
            capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
            capabilities.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
            capabilities.setCapability("noReset", true);
            capabilities.setCapability("chromedriverExecutable","/Users/esneyddisguerrerodurand/Downloads/chromedriver");
            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            driver =  new AndroidDriver<MobileElement>(url, capabilities);
            driver.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);
            try {
                driver.get("https://dev@supremegolf.com:2q6T9P*4@staging.app.supremegolf.com");
                String webContext = driver.getContext();
                Set<String> contexts = driver.getContextHandles();
                for (String context : contexts) {
                    if (context.contains("NATIVE_APP")) {
                        driver.context(context);
                        break;
                    }
                }
                driver.findElement(MobileBy.id("com.android.chrome:id/positive_button")).click();
                Thread.sleep(1000);
                driver.context(webContext);

            } catch (WebDriverException | InterruptedException e) {
                System.out.println("WebDriverException occured");
            }
        }
        else if (browser.equals("Safari"))
        {
            Log.info("OPEN SAFARI BROWSER FOR iOS SIMULATOR");

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
            capabilities.setCapability(MobileCapabilityType.UDID, "11B749CE-C3F6-42DF-AC9E-9DD9692796DF");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.1");
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 8 Plus");
            capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "safari");
            capabilities.setCapability("autoAcceptAlerts", true);
            capabilities.setCapability("safariAllowPopups", true);
            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            driver = new IOSDriver<MobileElement>(url, capabilities);
            driver.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);
            try {
                driver.get("https://astaging.app.supremegolf.com");
                driver.get("https://dev@supremegolf.com:2q6T9P*4@staging.app.supremegolf.com");
                driver.findElement(By.id("ignoreWarning")).click();

            } catch (WebDriverException e) {
                System.out.println("WebDriverException occured");
            }
        }
        else if (browser.equals("ChromeEmulator"))
        {
            Log.info("OPEN CHROME DRIVER IN MOBILE VIEW");
            Map<String, String> mobileEmulation = new HashMap<>();
            mobileEmulation.put("deviceName", "iPhone X");
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
            WebDriver driver = new ChromeDriver(chromeOptions);
            driver.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);
            try {
                driver.get("https://dev@supremegolf.com:2q6T9P*4@staging.app.supremegolf.com");

            } catch (WebDriverException e) {
                System.out.println("WebDriverException occured");
            }
        }
    }

}
