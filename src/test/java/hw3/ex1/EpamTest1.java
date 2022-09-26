package hw3.ex1;

import elements.HomePage;
import hw2.driver.DriverSettings;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EpamTest1 extends DriverSettings {

    @Test
    public void exercise1Test() {
        //exercise 1. Open test site by URL
        HomePage homePage = new HomePage(driver);
        homePage.open(properties.getProperty("url"));

        //exercise 1. Assert Browser title
        softAssert.assertEquals(driver.getTitle(), "Home Page");

        //exercise 1. Perform login
        homePage.login(properties.getProperty("name"), properties.getProperty("password"));

        //exercise 1. Assert Username is loggined
        softAssert.assertEquals(homePage.getUserName(), "ROMAN IOVLEV");

        //exercise 1. Assert that there are 4 items on the header section are displayed and they have proper texts
        homePage.getHeaderMenu().getNavigationBarItems().forEach((s) -> softAssert.assertTrue(s.isDisplayed()));

        //exercise 1. Assert that there are 4 images on the Index Page and they are displayed
        homePage.getBenefitIcons().forEach((s) -> softAssert.assertTrue(s.isDisplayed()));

        //exercise 1. Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<String> Texts = Arrays.asList(
                "To include good practices\n" +
                        "and ideas from successful\n" +
                        "EPAM project",
                "To be flexible and\n" +
                        "customizable",
                "To be multiplatform",
                "Already have good base\n" +
                        "(about 20 internal and\n" +
                        "some external projects),\n" +
                        "wish to get more\u2026");
        for (int i = 0; i < 4; i++) {
            softAssert.assertEquals(homePage.getBenefitTxt().get(i).getText(), Texts.get(i));
        }

        //Exercise 1. Assert that there is the iframe with “Frame Button” exist
        softAssert.assertTrue(homePage.getiFrame().isDisplayed());

        //Exercise 1. Switch to the iframe and check that there is “Frame Button” in the iframe
        driver.switchTo().frame("frame");
        softAssert.assertTrue(homePage.getFrameButton().isDisplayed());

        //Exercise 1. Switch to original window back
        driver.switchTo().defaultContent();
        softAssert.assertTrue(homePage.getBody().equals(driver
                .switchTo().activeElement()));

        //Exercise 1. Assert that there are 5 items in the Left Section are displayed and they have proper text
        List<String> names = homePage.getLeftMenu().getLeftMenuItems()
                .stream().peek((s) -> softAssert.assertTrue(s.isDisplayed()))
                .map(WebElement::getText).collect(Collectors.toList());
        softAssert.assertEquals(names, Arrays.asList("Home", "Contact form",
                "Service", "Metals & Colors", "Elements packs"));
        softAssert.assertAll();
    }
}
