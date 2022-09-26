package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LeftMenu {

    @FindBy(css = "ul[class = 'sidebar-menu left']>li>a>span")
    private List<WebElement> leftMenuItems;

    public LeftMenu(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getLeftMenuItems() {
        return this.leftMenuItems;
    }

    public void clickLeftMenuItems(final String item) {
        for (WebElement element : leftMenuItems) {
            if (item.equals(element.getText())) {
                element.click();
                break;
            }
        }

    }
}
