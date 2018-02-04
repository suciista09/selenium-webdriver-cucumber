package webdriver.example;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.junit.Assert;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;

/**
 * Created by suci on 04/02/2018.
 */
public class WebdriverHelper {

    public static WebDriver driver;

    public static DesiredCapabilities getCapabilities (String browser){
        DesiredCapabilities dcBrowser = null;

        if(browser.equalsIgnoreCase("firefox")){
            dcBrowser = DesiredCapabilities.firefox();
            dcBrowser.setBrowserName("firefox");
            dcBrowser.setCapability("firefox_binary", "/Applications/Firefox.app/Contents/MacOS/firefox-bin");
            dcBrowser.setPlatform(Platform.ANY);
        }
        else if (browser.equalsIgnoreCase("chrome")){
            dcBrowser = DesiredCapabilities.chrome();

            ChromeOptions options = new ChromeOptions();

            dcBrowser.setCapability(ChromeOptions.CAPABILITY, options);
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/src/main/resources/chromedriver2.35");
        }
        else if(browser.equalsIgnoreCase("ie")){
            dcBrowser = DesiredCapabilities.internetExplorer();
            dcBrowser.setBrowserName("iexplore");
        }else{
            Assert.fail("Unsupported Browser");
        }

        return dcBrowser;
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


}
