package hw4.tests.ex1;

import hw2.driver.DriverSettings;
import hw4.errorListiner.ScreenShotListener;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

@Listeners({ScreenShotListener.class})
@Feature("Home Page test class")
public class EpamTest1 extends DriverSettings {

    @Test
    @Story("Home page test method")
    public void testExercise1() {
        //Exercise 1. Open test site by URL
        actionStep.openHomePage();

        //Exercise 1. Assert Browser title
        assertionStep.assertTitle("Home Page");

        //Exercise 1. Perform login
        actionStep.loginHomePage(DriverSettings.properties.getProperty("name"),
                DriverSettings.properties.getProperty("password"));

        //Exercise 1. Assert Username is loggined
        assertionStep.assertUsername("ROMAN IOVLEV");

        //Exercise 1. Assert that there are 4 items on the header section are displayed and they have proper texts
        assertionStep.assertHeaderSection();

        //Exercise 1. Assert that there are 4 images on the Index Page and they are displayed
        assertionStep.assertBenefitIcons();

        //Exercise 1. Assert that there are 4 texts on the Index Page under icons and they have proper text
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
        assertionStep.assertIconsText(Texts);
        //Exercise 1. Assert that there is the iframe with “Frame Button” exist
        assertionStep.assertIframe();

        //Exercise 1. Switch to the iframe and check that there is “Frame Button” in the iframe
        actionStep.switchToFrame("frame");
        assertionStep.assertFrameButton();

        //Exercise 1. Switch to original window back
        actionStep.switchToDefaultContent();
        assertionStep.assertOriginalWindow();

        //Exercise 1. Assert that there are 5 items in the Left Section are displayed and they have proper text
        List<String> elements = Arrays.asList("Home", "Contact form",
                "Service", "Metals & Colors", "Elements packs");
        assertionStep.assertLeftSection(elements);
    }
}



