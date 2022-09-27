package hw5.Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import java.util.List;

public class ActionStep extends AbstractStep {

    @When("I click on {string} button in Header")
    public void openHeaderMenuItem(String Item) {
        homePage.getHeaderMenu().clickNavigatiounBarItem(Item);
    }

    @And("I click on {string} button in Service dropdown")
    public void openServiceDropdownItem(String item) {
        homePage.getHeaderMenu().clickNavigatiounBarItem("SERVICE");
        homePage.clickDropdownMenuItems(item);
    }

    @And("I select checkboxes in main form on Different Elements page")
    public void selectCheckboxesOnDifferentElementsPage(List<String> checkboxes) {
        checkboxes.forEach(s -> differentElementsPage.clickCheckboxItem(s));
    }

    @And("I select radio buttons in main form on Different Elements page")
    public void selectRadioboxesOnDifferentElementsPage(List<String> radioboxes) {
        radioboxes.forEach(s -> differentElementsPage.clickRadioboxItem(s));
    }

    @And("I select in dropdown in main form on Different Elements page")
    public void selectDropdownOnDifferentElementsPage(List<String> dropdownItem) {
        dropdownItem.forEach(s -> differentElementsPage.clickOptionItem(s));
    }

    @When("I select 'vip' checkbox for {string}")
    public void selectCheckboxOnUserTablePage(String username) {
        userTablePage.getCheckboxByUsername(username).click();
    }
}
