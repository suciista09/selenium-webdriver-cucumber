package webdriver.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.example.BaseConfig;

import java.util.List;

/**
 * Created by suci on 04/02/2018.
 */
public class BasePage {

    protected WebDriver driver;
    protected Wait wait;
    protected int TIMEOUT = 10;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    private By getByElement(String locatorType, String locatorName){
        //locatorType(locatorType);

        if(locatorType.equalsIgnoreCase("ID")){
            return By.id(locatorName);
        }else if(locatorType.equalsIgnoreCase("NAME")){
            return By.name(locatorName);
        }else if(locatorType.equalsIgnoreCase("XPATH")){
            return By.xpath(locatorName);
        }else if(locatorType.equalsIgnoreCase("CLASSNAME")){
            return By.className(locatorName);
        }else if (locatorType.equalsIgnoreCase("CSSSELECTOR")){
            return By.cssSelector(locatorName);
        }else if(locatorType.equalsIgnoreCase("LINKTEXT")){
            return By.linkText(locatorName);
        }
        else if(locatorType.equalsIgnoreCase("PARTIALLINKTEXT")){
            return By.partialLinkText(locatorName);
        }else{
            return null;
        }

    }

    /**
     * open an url
     * @param url
     */
    public void openUrl(String pathUrl){
        driver.get(BaseConfig.BASE_URL + "/" + pathUrl);
    }

    /**
     * click an element
     * @param locatorType : ID,XPATH,NAME,CLASSNAME,CSSSELECTOR,LINKTEXT,PARTIALLINKTEXT
     * @param locatorName : name of locator
     */
    public void clickElement(String locatorType, String locatorName){
        waitElementToBeClickAble(locatorType,locatorName);
        driver.findElement(getByElement(locatorType,locatorName)).click();
    }

    /**
     * type an element
     * @param locatorType : ID,XPATH,NAME,CLASSNAME,CSSSELECTOR,LINKTEXT,PARTIALLINKTEXT
     * @param locatorName : name of locator
     * @param input
     */
    public void typeElement(String locatorType, String locatorName, String input){
        By by  = getByElement(locatorType,locatorName);
        driver.findElement(by).sendKeys(input);
    }

    /**
     *
     * @param locatorType : ID,XPATH,NAME,CLASSNAME,CSSSELECTOR,LINKTEXT,PARTIALLINKTEXT
     * @param locatorName : name of locator
     */
    public void waitElementToBeClickAble(final String locatorType, final String locatorName) {
        wait = new WebDriverWait(driver,TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(getByElement(locatorType,locatorName)));
    }

    /**
     * get text from element
     * @param locatorType : ID,XPATH,NAME,CLASSNAME,CSSSELECTOR,LINKTEXT,PARTIALLINKTEXT
     * @param locatorName : name of locator
     * @return text: String
     */
    public String getTextString(String locatorType, String locatorName){
        return driver.findElement(getByElement(locatorType,locatorName)).getText();
    }

    /**
     *
     * @param locatorType ID,XPATH,NAME,CLASSNAME,CSSSELECTOR,LINKTEXT,PARTIALLINKTEXT
     * @param locatorName name of locator
     * @return boolean
     */
    public boolean isDisplayed(String locatorType, String locatorName){
        try{
            return driver.findElement(getByElement(locatorType, locatorName)).isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

    /**
     * get title of page
     * @return
     */
    public String getTitlePage(){
        return driver.getTitle();
    }

    /**
     * select drop down by value
     * @param locatorType ID,XPATH,NAME,CLASSNAME,CSSSELECTOR,LINKTEXT,PARTIALLINKTEXT
     * @param locatorName name of locator
     * @param value
     */
    public void selectDropDownByValue(String locatorType, String locatorName, String value){
        Select select = new Select(driver.findElement(getByElement(locatorType,locatorName)));
        select.selectByValue(value);
    }

    /**
     * select drop down by index
     * @param locatorType ID,XPATH,NAME,CLASSNAME,CSSSELECTOR,LINKTEXT,PARTIALLINKTEXT
     * @param locatorName name of locator
     * @param index
     */
    public void selectDropDownByIndex(String locatorType, String locatorName, int index){
        Select select = new Select(driver.findElement(getByElement(locatorType,locatorName)));
        select.selectByIndex(index);
    }

    /**
     * select drop down by visible text
     * @param locatorType ID,XPATH,NAME,CLASSNAME,CSSSELECTOR,LINKTEXT,PARTIALLINKTEXT
     * @param locatorName name of locator
     * @param text
     */
    public void selectDropDownByVisibleText(String locatorType, String locatorName, String text){
        Select select = new Select(driver.findElement(getByElement(locatorType,locatorName)));
        select.selectByVisibleText(text);
    }

    /**
     * get all option elements
     * @param locatorType ID,XPATH,NAME,CLASSNAME,CSSSELECTOR,LINKTEXT,PARTIALLINKTEXT
     * @param locatorName name of locator
     * @return
     */
    public List<WebElement> getAllOptions(String locatorType, String locatorName){
        Select select = new Select(driver.findElement(getByElement(locatorType,locatorName)));
        return select.getOptions();
    }

    /**
     * go to previous page
     */
    public void gotoPreviousPage(){
        driver.navigate().back();
    }

    /**
     *
     * @param locatorType ID,XPATH,NAME,CLASSNAME,CSSSELECTOR,LINKTEXT,PARTIALLINKTEXT
     * @param locatorName name of locator
     * @return
     */
    public List<WebElement> getElements(String locatorType, String locatorName){
        return driver.findElements(getByElement(locatorType,locatorName));
    }

    /**
     * click an element
     * @param element : WebElement
     */
    public void clickElement(WebElement element){
        element.click();
    }
}
