package hw5.Steps;

import elements.DifferentElementsPage;
import elements.HomePage;
import elements.UserTablePage;
import hw5.TestContext.TestContext;
import org.openqa.selenium.WebDriver;


public class AbstractStep {

    protected WebDriver driver;

    protected HomePage homePage;
    protected DifferentElementsPage differentElementsPage;
    protected UserTablePage userTablePage;

    public AbstractStep() {
        driver = TestContext.getInstance().getObject("driver");
        homePage = new HomePage(driver);
        differentElementsPage = new DifferentElementsPage(driver);
        userTablePage = new UserTablePage(driver);
    }
}
