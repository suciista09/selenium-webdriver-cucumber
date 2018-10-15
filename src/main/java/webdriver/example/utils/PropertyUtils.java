package webdriver.example.utils;

import org.openqa.selenium.By;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Properties;

public class PropertyUtils {

    public static Properties CONFIG_PROPERTIES=null;

    private static Properties loadConfigProperties(){
        String propertiesFileName = "config.properties";

        Properties properties = new Properties();

        try{
            FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+"/"+propertiesFileName);
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (FileNotFoundException e) {

        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties;

    }

    public static Properties loadCapabilitiesProperties(){
        String propertiesFileName = "capabilities.properties";

        Properties properties = new Properties();

        try{
            FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/" + propertiesFileName);
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (FileNotFoundException e) {

        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties;

    }

    public static Properties loadLocatorProperties(){
        String propertiesFileName = "locator.properties";

        Properties properties = new Properties();

        try{
            FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/" + propertiesFileName);
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (FileNotFoundException e) {

        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties;

    }

    public static By getLocatorFromProperties(String key_locartor) {
        //pindahkan saat load driver
        Properties properties = PropertyUtils.loadLocatorProperties();
        String propLocator = properties.getProperty(key_locartor);
        if (!propLocator.contains("_")){
            throw new NoSuchElementException("Bad format. please check how you write your locator in locator.properties");
        }
        String[] values = propLocator.split("_");
        String locatorType = values[0];
        String locatorValue = propLocator.substring(propLocator.indexOf("_") + 1);

        if(locatorType.equalsIgnoreCase("id"))
            return By.id(locatorValue);
        else if(locatorType.equalsIgnoreCase("name"))
            return By.name(locatorValue);
        else if((locatorType.equalsIgnoreCase("classname")) || (locatorType.equalsIgnoreCase("class")))
            return By.className(locatorValue);
        else if((locatorType.equalsIgnoreCase("tagname")) || (locatorType.equalsIgnoreCase("tag")))
            return By.className(locatorValue);
        else if((locatorType.equalsIgnoreCase("linktext")) || (locatorType.equalsIgnoreCase("link")))
            return By.linkText(locatorValue);
        else if(locatorType.toLowerCase().equals("partiallinktext"))
            return By.partialLinkText(locatorValue);
        else if((locatorType.toLowerCase().equals("cssselector")) || (locatorType.toLowerCase().equals("css")))
            return By.cssSelector(locatorValue);
        else if(locatorType.toLowerCase().equals("xpath"))
            return By.xpath(locatorValue);
        else
            throw new NoSuchElementException("unknown locator type : " + locatorType);
    }

    public static String getAppiumServerAddress()
    {
        if(CONFIG_PROPERTIES==null)
        {
            CONFIG_PROPERTIES = loadConfigProperties();
        }


        return (String) CONFIG_PROPERTIES.get("appium.url");

    }

    public static String getAppiumPort()
    {
        if(CONFIG_PROPERTIES==null)
        {
            CONFIG_PROPERTIES = loadConfigProperties();
        }
        return (String) CONFIG_PROPERTIES.get("appium.port");
    }

    public static String getBrowserName()
    {
        if(CONFIG_PROPERTIES==null)
        {
            CONFIG_PROPERTIES = loadConfigProperties();
        }
        return (String) CONFIG_PROPERTIES.get("browser.name");
    }
}
