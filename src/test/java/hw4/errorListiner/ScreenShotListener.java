package hw4.errorListiner;


import hw2.driver.DriverSettings;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class ScreenShotListener extends DriverSettings implements ITestListener {

    public void onTestFailure(ITestResult result){
        Date date = new Date();
        String screenshotName = date.toString().replace(" ", "-").replace(":","-");
        File screenshotFile= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotFile, new File(".//RESULT//"+screenshotName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
