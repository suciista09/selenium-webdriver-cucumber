package webdriver.example.driver;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.example.BaseConfig;
import webdriver.example.utils.PropertyUtils;

import java.util.Map;
import java.util.Properties;

/**
 * Created by suci on 04/02/2018.
 */
public class WebdriverHelper {

    public static WebDriver driver;
    private static WebDriverWait wait;
    private static int TIMEOUT = 10;

    public static DesiredCapabilities getCapabilities (String browser){
        DesiredCapabilities dcBrowser = null;

        if(browser.equalsIgnoreCase("firefox")){
            dcBrowser = DesiredCapabilities.firefox();
            dcBrowser.setBrowserName("firefox");
            dcBrowser.setCapability("firefox_binary", "/Applications/Firefox.app/Contents/MacOS/firefox-bin");

        }
        else if (browser.equalsIgnoreCase("chrome")){
            dcBrowser = DesiredCapabilities.chrome();

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");

            dcBrowser.setCapability(ChromeOptions.CAPABILITY, options);
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/src/main/resources/chromedriver2.35");
        }
        else if(browser.equalsIgnoreCase("ie")){
            dcBrowser = DesiredCapabilities.internetExplorer();
            dcBrowser.setBrowserName("iexplore");
        }else{
            Assert.fail("Unsupported Browser");
        }

        Properties capProp= PropertyUtils.loadCapabilitiesProperties();

        String value=null;
        for(Map.Entry<Object, Object> e : capProp.entrySet())
        {
            value=(String) e.getValue();
            dcBrowser.setCapability((String) e.getKey(), value);
        }

        return dcBrowser;
    }


    public static void loadDriver(String browser){
        driver = getDriver(browser);
        wait = new WebDriverWait(driver,TIMEOUT);
        driver.manage().window().maximize();
    }

    public static void closeDriver(){
        driver.close();
    }

    public static WebDriver getDriver(String browser){
        DesiredCapabilities dc = getCapabilities(browser);
        WebDriver mDriver=null;

        if (browser.equalsIgnoreCase("chrome")){
            mDriver = new ChromeDriver(dc);
        }else{
            Assert.fail("Unsupported Browser");
        }

        return mDriver;
    }

    public static void typeElement(By Locator, String input){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
        element.sendKeys(input);
    }

    public static void navigateTo(String pathUrl){
        driver.get(BaseConfig.BASE_URL +  pathUrl);
    }

    public static void clickElement(By locator){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));

        element.click();
    }

    public static boolean isElementIsDisplayed(By locator){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        try {
            return element.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }



}
