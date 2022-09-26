package hw4.steps;

import elements.DifferentElementsPage;
import elements.HomePage;
import org.openqa.selenium.WebDriver;


public abstract class AbstractStep {

    protected WebDriver driver;

    protected HomePage homePage;
    protected DifferentElementsPage differentElementsPage;

    protected AbstractStep(WebDriver driver) {
        this.driver = driver;
        this.homePage = new HomePage(driver);
        this.differentElementsPage = new DifferentElementsPage(driver);
    }
}
