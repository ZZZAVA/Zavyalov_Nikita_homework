package hw5.Steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Map;

public class AssertionStep extends AbstractStep {

    @Then("Browser title equals {string}")
    public void assertTitle(String title) {
        Assert.assertEquals(driver.getTitle(), title);
    }

    @And("Name is displayed and equals to {string}")
    public void assertUsername(String username) {
        Assert.assertEquals(homePage.getUserName(), username);
    }

    @Then("I see that part of logs in right section on Different Elements page")
    public void assertLogs(List<String> logs) {
        Assert.assertTrue(differentElementsPage.getLogsWithoutTime().containsAll(logs));
    }

    @Then("{string} page should be opened")
    public void UserTableIsOpened(String title) {
        Assert.assertEquals(driver.getTitle(), title);
    }

    @And("6 Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void assertNumberTypeDropdownsOnUserTable() {
        userTablePage.getDroplists().forEach(s -> Assert.assertTrue(s.isDisplayed()));
    }

    @And("6 Usernames should be displayed on Users Table on User Table Page")
    public void assertUserNamesOnUserTable() {
        userTablePage.getUsernames().forEach(s -> Assert.assertTrue(s.isDisplayed()));
    }

    @And("6 Description texts under images should be displayed on Users Table on User Table Page")
    public void assertDescriptionsOnUserTable() {
        userTablePage.getDescriptions().forEach(s -> Assert.assertTrue(s.isDisplayed()));
    }

    @And("6 checkboxes should be displayed on Users Table on User Table Page")
    public void assertCheckboxesOnUserTable() {
        userTablePage.getCheckboxes().forEach(s -> Assert.assertTrue(s.isDisplayed()));
    }

    @And("User table should contain following values:")
    public void assertDataTableOnUserTablePage(DataTable args) {
        List<Map<String, String>> table = args.asMaps(String.class, String.class);
        SoftAssert softAssert = new SoftAssert();
        for (int i = 0; i < table.size(); i++) {
            softAssert.assertEquals(userTablePage.getNumbers().get(i).getText()
                    , table.get(i).get("Number"));
            softAssert.assertEquals(userTablePage.getUsernames().get(i).getText()
                    , table.get(i).get("User"));
            System.out.println();
            softAssert.assertEquals(userTablePage
                            .getDescriptions()
                            .get(i)
                            .getText()
                            .replace(" ","")
                            .replace("\n", "")
                    , table.get(i).get("Description").replace(" ",""));
        }
        softAssert.assertAll();
    }

    @And("droplist should contain values in column Type for user Roman")
    public void assertDroplistForUser(DataTable args) {
        List<Map<String, String>> table = args.asMaps(String.class, String.class);
        SoftAssert softAssert = new SoftAssert();
        for (int i = 0; i < table.size(); i++) {
            softAssert.assertEquals(userTablePage.getDroplistByUsername("Roman").get(i).getText()
                    , table.get(i).get("Dropdown Values"));
        }
        softAssert.assertAll();
    }

    @Then("1 log row has {string} text in log section")
    public void assertVipCheckboxIsClicked(String log) {
        Assert.assertEquals(userTablePage.getLogs().get(0), log);
    }
}
