package hw5.Steps;

import hw5.TestContext.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class GivenStep extends AbstractStep {

    @Given("I open JDI GitHub site")
    public void openHomePage() {
        Properties properties = TestContext.getInstance().getObject("properties");
        homePage.open(properties.getProperty("url"));
    }

    @And("I login as User {string}")
    public void loginHomePage(String name) {
        Properties properties = TestContext.getInstance().getObject("properties");
        List<String> loginPassword = Arrays.asList(properties.getProperty(name).split(","));
        homePage.login(loginPassword.get(0), loginPassword.get(1));
    }
}
