package hw2.ex2;

import hw2.driver.DriverSettings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class EpamTest2 extends DriverSettings {

    @Test
    public void exercise2Test() {
        //exercise 2. Open test site by URL
        driver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");

        //exercise 2. Assert Browser title
        softAssert.assertEquals(driver.getTitle(), "Home Page");

        //exercise 2. Perform login
        driver.findElement(By.cssSelector("a[href = '#']")).click();
        driver.findElement(By.id("name")).sendKeys("Roman");
        driver.findElement(By.id("password")).sendKeys("Jdi1234");
        driver.findElement(By.id("login-button")).click();

        //exercise 2. Assert User name in the left-top side of screen that user is loggined
        softAssert.assertEquals(driver.findElement(By.id("user-name")).getText(),
                "ROMAN IOVLEV");

        //exercise 2. Open through the header menu Service -> Different Elements Page
        driver.findElement(By.className("dropdown")).click();
        driver.findElement(By.className("dropdown-menu")).findElement(By
                .cssSelector("[href='different-elements.html']")).click();

        //Exercise 2. Select checkboxes	Water
        driver.findElements(By.cssSelector("label[class='label-checkbox']"))
                .stream().filter((s) -> ((s.getText().equals("Water"))
                        || (s.getText().equals("Wind"))))
                .forEach(WebElement::click);

        //Exercise 2. Select radio Selen
        driver.findElements(By.cssSelector("label[class='label-radio']"))
                .stream().filter((s) -> (s.getText().equals("Selen")))
                .forEach(WebElement::click);

        //Exercise 2. Select in dropdown Yellow
        driver.findElement(By.cssSelector("select[class='uui-form-element']"))
                .findElements(By.tagName("option"))
                .stream().filter((s) -> s.getText().equals("Yellow"))
                .forEach(WebElement::click);

        //Exercise 2. Assert that
        //•	for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        //•	for radio button there is a log row and value is corresponded to the status of radio button
        //•	for dropdown there is a log row and value is corresponded to the selected value.

        driver.findElements(By.cssSelector("ul[class = 'panel-body-list logs'] li"))
                .stream().map(WebElement::getText)
                .forEach((s) -> softAssert.assertTrue(s
                        .matches("(\\d\\d:\\d\\d:\\d\\d Wind: condition changed to true)" +
                                "|(\\d\\d:\\d\\d:\\d\\d Water: condition changed to true)" +
                                "|(\\d\\d:\\d\\d:\\d\\d Colors: value changed to Yellow)" +
                                "|(\\d\\d:\\d\\d:\\d\\d metal: value changed to Selen)")));
        softAssert.assertAll();
    }

}
