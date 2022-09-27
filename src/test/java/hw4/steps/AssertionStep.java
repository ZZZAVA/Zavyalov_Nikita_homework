package hw4.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class AssertionStep extends AbstractStep {

    public AssertionStep(WebDriver driver) {
        super(driver);
    }

    @Step("Exercise 1. Assert Browser title {title}")
    public void assertTitle(String title) {
        Assert.assertEquals(driver.getTitle(), title);
    }

    @Step("Exercise 1. Assert {username} is loggined")
    public void assertUsername(String username) {
        Assert.assertEquals(homePage.getUserName(), username);
    }

    @Step("Exercise 1. Assert that there are 4 items on the header section are displayed and they have proper texts")
    public void assertHeaderSection() {
        homePage.getHeaderMenu().getNavigationBarItems().forEach((s) -> Assert.assertTrue(s.isDisplayed()));
    }

    @Step("Exercise 1. Assert that there are 4 images on the Index Page and they are displayed")
    public void assertBenefitIcons() {
        homePage.getBenefitIcons().forEach((s) -> Assert.assertTrue(s.isDisplayed()));
    }

    @Step("Exercise 1. Assert that there are 4 texts on the Index Page under icons and they have proper text")
    public void assertIconsText(List<String> texts) {
        for (int i = 0; i < 4; i++) {
            Assert.assertEquals(homePage.getBenefitTxt().get(i).getText(), texts.get(i));
        }
    }

    @Step("Exercise 1. Assert that there is the iframe with “Frame Button” exist")
    public void assertIframe() {
        Assert.assertTrue(homePage.getiFrame().isDisplayed());
    }

    @Step("Exercise 1. Switch to the iframe and check that there is “Frame Button” in the iframe")
    public void assertFrameButton() {
        Assert.assertTrue(homePage.getFrameButton().isDisplayed());
    }

    @Step("Exercise 1. Assert that focus on original window")
    public void assertOriginalWindow() {
        Assert.assertEquals(driver.switchTo().activeElement(), homePage.getBody());
    }

    @Step("Exercise 1. Assert that there are 5 items {elements} in the Left Section are displayed and they have proper text")
    public void assertLeftSection(List<String> elements) {
        Assert.assertEquals(homePage
                .getLeftMenu().getLeftMenuItems().stream()
                .peek((s) -> Assert.assertTrue(s.isDisplayed()))
                .map(WebElement::getText)
                .collect(Collectors.toList()), elements);
    }

    @Step("Exercise 2. Assert logs")
    public void assertLogs(String regEx) {
        differentElementsPage.getLogs()
                .forEach((s) -> Assert.assertTrue(s.matches(regEx)));
    }
}
