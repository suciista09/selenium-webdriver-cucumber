package webdriver.example.pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by suci on 04/02/2018.
 */
public class LoginPage extends BasePage {

    private String idEmail = "";
    private String idPassword = "";
    private String idLoginButton = "";
    private String pathUrl = "/login";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void typeEmail(String email){
        typeElement("ID", idEmail, email);
    }

    public void typePassword(String password){
        typeElement("ID", idPassword, password);
    }

    public void clickLoginButton(){
        clickElement("ID", idLoginButton);
    }

    public void verifyLoginSuccess(){

    }

    public void open(){

        openUrl(pathUrl);
    }

}
