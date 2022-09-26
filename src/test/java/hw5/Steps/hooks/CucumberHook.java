package hw5.Steps.hooks;

import hw5.TestContext.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class CucumberHook {

    private static final String pathToProperties = "src/test/resources/config.properties";
    private static final String pathToDriver =
            new File("").getAbsolutePath() + "//target//test-classes//chromedriver.exe";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", pathToDriver);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        Properties properties = new Properties();
        try (FileReader fr = new FileReader(pathToProperties);) {
            properties.load(fr);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        TestContext.getInstance()
                .putObject("driver", driver)
                .putObject("properties", properties);
    }

    @After
    public void tearDown() {
        WebDriver driver = TestContext.getInstance().getObject("driver");
        if (driver != null) {
            driver.quit();
        }
        TestContext.getInstance().clean();
    }
}
