package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HeaderMenu {

    @FindBy(css = "nav[role = 'navigation']>ul>li")
    private List<WebElement> navigationBarItems;

    public HeaderMenu(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getNavigationBarItems() {
        return this.navigationBarItems;
    }

    public void clickNavigatiounBarItem(final String item) {
        for (WebElement element : navigationBarItems) {
            if (item.equals(element.getText())) {
                element.click();
                break;
            }
        }
    }
}
