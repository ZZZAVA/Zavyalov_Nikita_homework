package hw2.ex1;

import hw2.driver.DriverSettings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EpamTest1 extends DriverSettings {

    @Test
    public void exercise1Test() {
        //exercise 1. Open test site by URL
        driver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");

        //exercise 1. Assert Browser title
        softAssert.assertEquals(driver.getTitle(), "Home Page");

        //exercise 1. Perform login
        driver.findElement(By.cssSelector("a[href = '#']")).click();
        driver.findElement(By.id("name")).sendKeys("Roman");
        driver.findElement(By.id("password")).sendKeys("Jdi1234");
        driver.findElement(By.id("login-button")).click();

        //exercise 1. Assert Username is loggined
        softAssert.assertEquals(driver.findElement(By.id("user-name")).getText(),
                "ROMAN IOVLEV");

        //exercise 1. Assert that there are 4 items on the header section are displayed and they have proper texts
        softAssert.assertTrue(driver.findElement(By
                .linkText("Home")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By
                .linkText("Contact form")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By
                .linkText("Service")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By
                .linkText("Metals & Colors")).isDisplayed());

        //exercise 1. Assert that there are 4 images on the Index Page and they are displayed
        softAssert.assertTrue(driver.findElement(By
                .className("icon-practise")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By
                .className("icon-custom")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By
                .className("icon-multi")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By
                .className("icon-base")).isDisplayed());

        //exercise 1. Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> benefitTxt = driver.findElements(By.className("benefit-txt"));
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
                        "wish to get more…");
        for (int i = 0; i < 4; i++) {
            softAssert.assertEquals(benefitTxt.get(i).getText(), Texts.get(i));
        }
        //Exercise 1. Assert that there is the iframe with “Frame Button” exist
        softAssert.assertTrue(driver
                .findElement(By.id("frame")).isDisplayed());

        //Exercise 1. Switch to the iframe and check that there is “Frame Button” in the iframe
        String mainWindow = driver.getWindowHandle();
        driver.switchTo().frame("frame");
        softAssert.assertTrue(driver.findElement(By
                .id("frame-button")).isDisplayed());

        //Exercise 1. Switch to original window back
        driver.switchTo().defaultContent();
        WebElement curWindow = driver.findElement(By.tagName("body"));
        softAssert.assertTrue(curWindow.equals(driver
                .switchTo().activeElement()));
        //Exercise 1. Assert that there are 5 items in the Left Section are displayed and they have proper text
        List<String> names = driver.findElements(By.cssSelector("ul[class = 'sidebar-menu left']>li>a>span"))
                .stream().peek((s) -> softAssert.assertTrue(s.isDisplayed()))
                .map(WebElement::getText).collect(Collectors.toList());
        softAssert.assertEquals(names, Arrays.asList("Home", "Contact form",
                "Service", "Metals & Colors", "Elements packs"));
        softAssert.assertAll();
    }
}
