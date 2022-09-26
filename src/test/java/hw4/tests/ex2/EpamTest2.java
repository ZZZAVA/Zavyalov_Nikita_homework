package hw4.tests.ex2;

import hw2.driver.DriverSettings;
import hw4.errorListiner.ScreenShotListener;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ScreenShotListener.class})
@Feature("Home Page and Different elements page test class")
public class EpamTest2 extends DriverSettings {

    @Test
    @Story("Home Page and Different elements page test method")
    public void testExercise2() {
        //Exercise 2. Open test site by URL
        actionStep.openHomePage();

        //Exercise 2. Assert Browser title
        assertionStep.assertTitle("Home Page");

        //Exercise 2. Perform login
        actionStep.loginHomePage(DriverSettings.properties.getProperty("name"),
                DriverSettings.properties.getProperty("password"));

        //Exercise 2. Assert Username in the left-top side of screen that user is loggined
        assertionStep.assertUsername("ROMAN IOVLEV");

        //Exercise 2. Open through the header menu Service -> Different Elements Page
        actionStep.openHeaderDropdownMenuItem("SERVICE","DIFFERENT ELEMENTS");

        //Exercise 2. Select checkboxes	Water and Wind
        actionStep.selectCheckbox("Water");
        actionStep.selectCheckbox("Wind");

        //Exercise 2. Select radio Selen
        actionStep.selectRadiobox("Selen");

        //Exercise 2. Select in dropdown Yellow
        actionStep.selectOptionItem("Yellow");

        //Exercise 2. Assert that
        //•	for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        //•	for radio button there is a log row and value is corresponded to the status of radio button
        //•	for dropdown there is a log row and value is corresponded to the selected value.

        assertionStep.assertLogs("(\\d\\d:\\d\\d:\\d\\d Wind: condition changed to true)" +
                "|(\\d\\d:\\d\\d:\\d\\d Water: condition changed to true)" +
                "|(\\d\\d:\\d\\d:\\d\\d Colors: value changed to Yellow)" +
                "|(\\d\\d:\\d\\d:\\d\\d metal: value changed to Selen)");

    }
}
