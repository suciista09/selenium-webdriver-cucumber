package webdriver.example;

/**
 * Created by suci on 04/02/2018.
 */

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        strict = false,
        features={"classpath:features"},
        glue={"classpath:webdriver/example/Steps/"},
        format = { "pretty","html:target/reports/cucumber-reports","json:target/cucumber.json" }
        //,tags = { "~@ignore","@detailtest" }
)
public class TestRunner {

}
