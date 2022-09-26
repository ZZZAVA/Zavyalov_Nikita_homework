package hw2.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class DriverSettings {

    protected static SoftAssert softAssert;
    protected static WebDriver driver;
    protected static String path;

    @BeforeSuite
    public void setUpSuite() {
        path = getClass().getClassLoader().getResource("chromedriver.exe").getPath();
        System.setProperty("webdriver.chrome.driver", path);
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        softAssert = new SoftAssert();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
