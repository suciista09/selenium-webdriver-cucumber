package webdriver.example.Steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import webdriver.example.driver.WebdriverHelper;
import webdriver.example.utils.PropertyUtils;

public class BaseSteps {

    @Given("the user navigate to \"([^\"]*)\" page$")
    public void userNavigateTo(String arg0){
        System.out.println("Navigate to  : " + arg0);
        String url = PropertyUtils.loadLocatorProperties().getProperty(arg0);
        System.out.println("URL : " + url);
        WebdriverHelper.navigateTo(url);

    }

    @When("the user input \"([^\"]*)\" field with \"([^\"]*)\" text$")
    public void userInputFieldWithText(String arg0, String arg1){

        By locator = PropertyUtils.getLocatorFromProperties(arg0);

        WebdriverHelper.typeElement(locator, arg1);

    }

    @When("the user click \"([^\"]*)\" element")
    public void userClickElement(String arg0){
        By locator = PropertyUtils.getLocatorFromProperties(arg0);

        WebdriverHelper.clickElement(locator);
    }

    @When("the user verify element \"([^\"]*)\" exist")
    public void userVerifyElementExist(String arg0) throws Exception {
        By locator = PropertyUtils.getLocatorFromProperties(arg0);

        if (WebdriverHelper.isElementIsDisplayed(locator)){
            //put info logger
        }else {
            throw new Exception("Element : " + locator.toString() + "is not displayed yet");
        }
    }

}
