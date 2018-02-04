package webdriver.example.Steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import webdriver.example.BaseConfig;
import webdriver.example.WebdriverHelper;

import java.net.MalformedURLException;

/**
 * Created by suci on 04/02/2018.
 */
public class Hook {

    private WebDriver driver;

    @Before
    public void beforeScenario() throws MalformedURLException {
        System.out.println("Holaaa");
        String browserName = System.getProperty("browserName");


        driver = WebdriverHelper.getDriver(browserName);
        driver.manage().window().maximize();
        driver.get(BaseConfig.BASE_URL);
    }

    @After
    public void afterScenario(Scenario scenario){
        driver.close();
    }
}
