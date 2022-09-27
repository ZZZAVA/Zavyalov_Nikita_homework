package hw5.Users;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/hw5.features/UserTablePage.feature"},
        glue = {"hw5.Steps"},
        tags = "@second"
)
public class User2 extends AbstractTestNGCucumberTests {
}
