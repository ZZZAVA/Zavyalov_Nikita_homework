package elements;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

    private HeaderMenu headerMenu;
    private LeftMenu leftMenu;
    private WebDriver driver;

    @FindBy(css = "a[href = '#']")
    private WebElement loginCaret;

    @FindBy(id = "name")
    private WebElement name;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(id = "user-name")
    private WebElement userName;

    @FindBy(className = "benefit-icon")
    private List<WebElement> benefitIcons;

    @FindBy(className = "benefit-txt")
    private List<WebElement> benefitTxt;


    @FindBy(id = "frame")
    private WebElement iFrame;

    @FindBy(id = "frame-button")
    private WebElement frameButton;

    @FindBy(tagName = "body")
    private WebElement body;

    @FindBy(css = "ul[class = 'dropdown-menu'] li a")
    private List<WebElement> dropdownItems;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        headerMenu = new HeaderMenu(this.driver);
        leftMenu = new LeftMenu(this.driver);
        PageFactory.initElements(this.driver, this);
    }

    public void open(String url) {
        this.driver.navigate().to(url);
    }

    public HeaderMenu getHeaderMenu() {
        return this.headerMenu;
    }

    public LeftMenu getLeftMenu() {
        return leftMenu;
    }

    public void login(String userName, String password) {
        this.loginCaret.click();
        this.name.sendKeys(userName);
        this.password.sendKeys(password);
        this.loginButton.click();
    }

    public void clickDropdownMenuItems(final String item) {
        for (WebElement element : dropdownItems) {
            if (item.equals(element.getText())) {
                element.click();
                break;
            }
        }
    }

    public String getUserName() {
        return this.userName.getText();
    }

    public List<WebElement> getBenefitIcons() {
        return this.benefitIcons;
    }

    public List<WebElement> getBenefitTxt() {
        return this.benefitTxt;
    }

    public WebElement getiFrame() {
        return this.iFrame;
    }

    public WebElement getFrameButton() {
        return this.frameButton;
    }

    public WebElement getBody() {
        return this.body;
    }

}
