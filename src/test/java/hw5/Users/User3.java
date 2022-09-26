package hw5.Users;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/hw5.features/UserTablePageVipCheckbox.feature"},
        glue = {"hw5.Steps"},
        tags = "@third"
)
public class User3 extends AbstractTestNGCucumberTests {
}
