package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class UserTablePage {

    private LeftMenu leftMenu;
    private HeaderMenu headerMenu;
    private WebDriver driver;


    @FindBy(css = "tbody tr")
    private List<WebElement> userTable;

    @FindBy(css = "ul[class = 'panel-body-list logs'] li")
    private List<WebElement> logs;

    public UserTablePage(WebDriver driver) {
        this.driver = driver;
        headerMenu = new HeaderMenu(this.driver);
        leftMenu = new LeftMenu(this.driver);
        PageFactory.initElements(this.driver, this);
    }

    public WebElement getByNumber(String num) {
        return userTable
                .stream()
                .filter(s -> s.findElement(By.cssSelector("td")).getText().equals(num))
                .findFirst()
                .orElse(null);
    }

    public List<WebElement> getNumbers() {
        return userTable
                .stream()
                .map(s -> s.findElement(By.cssSelector("td")))
                .collect(Collectors.toList());
    }

    public WebElement getByUsername(String username) {
        return userTable
                .stream()
                .filter(s -> s.findElement(By.cssSelector("td a")).getText().equals(username))
                .findFirst()
                .orElse(null);
    }

    public List<WebElement> getUsernames() {
        return userTable
                .stream()
                .map(s -> s.findElement(By.cssSelector("td a")))
                .collect(Collectors.toList());
    }

    public List<WebElement> getDroplistByUsername(String username) {
        WebElement webElement = getByUsername(username);
        return webElement.findElements(By.cssSelector("td select option"));
    }

    public List<WebElement> getDroplists() {
        return userTable
                .stream()
                .map(s -> s.findElement(By.cssSelector("td select")))
                .collect(Collectors.toList());
    }

    public List<WebElement> getDescriptions() {
        return userTable
                .stream()
                .map(s -> s.findElement(By.cssSelector("td div[class = 'user-descr'] span")))
                .collect(Collectors.toList());
    }

    public List<WebElement> getCheckboxes() {
        return userTable
                .stream()
                .map(s -> s.findElement(By.cssSelector("td div input[type = 'checkbox']")))
                .collect(Collectors.toList());
    }

    public WebElement getCheckboxByUsername(String username) {
        WebElement webElement = getByUsername(username);
        return webElement.findElement(By.cssSelector("td div input[type = 'checkbox']"));
    }

    public List<String> getLogs() {
        return logs
                .stream()
                .map(s -> s.getText().substring(9))
                .collect(Collectors.toList());
    }
}
