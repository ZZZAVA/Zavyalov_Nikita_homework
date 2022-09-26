package hw2.driver;

import hw4.steps.AbstractStep;
import hw4.steps.ActionStep;
import hw4.steps.AssertionStep;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class DriverSettings {

    protected static SoftAssert softAssert;
    protected static WebDriver driver;
    protected static String path;
    public static Properties properties;
    protected ActionStep actionStep;
    protected AssertionStep assertionStep;

    @BeforeSuite(description = "Set up properties and web driver")
    public void setUpSuite() {
        path = new File("").getAbsolutePath() + "//target//test-classes//chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
        properties = new Properties();
        try (FileReader fr = new FileReader("src/test/resources/config.properties");) {
            properties.load(fr);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @BeforeMethod(description = "Set up chromeDriver, soft assert, steps, maximize window and timeots definition  ")
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        softAssert = new SoftAssert();
        actionStep = new ActionStep(driver);
        assertionStep = new AssertionStep(driver);
    }

    @AfterMethod(description = "tear down web driver")
    public void tearDown() {
        driver.quit();
    }
}
