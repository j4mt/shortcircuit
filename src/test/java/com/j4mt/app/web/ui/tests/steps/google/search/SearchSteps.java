package com.j4mt.app.web.ui.tests.steps.google.search;

import com.j4mt.app.web.ui.tests.driver.DriverProvider;
import com.codeborne.selenide.WebDriverRunner;
import com.j4mt.app.web.ui.tests.pages.google.GooglePage;
import com.j4mt.app.web.ui.tests.pages.google.GoogleResultsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.Properties;

import static com.j4mt.app.web.ui.tests.util.Utils.waitABit;
import static com.codeborne.selenide.Selenide.open;


public class SearchSteps {

    private String test_environment;
    GooglePage googlePage = new GooglePage();
    GoogleResultsPage googleResultsPage = new GoogleResultsPage();
    public static Properties config = null;


    @When("^I am on homepage$")
    public void iAmOnHomepage() throws Exception {
        WebDriverRunner.setWebDriver(DriverProvider.getDriver());
        waitABit(3000);
        test_environment= "http://www.google.ie";
        open(test_environment);
        googlePage.isGoogplePage();
    }

    @And("^I search \"([^\"]*)\"$")
    public void iSearch(String word) throws Throwable {
        googlePage.search(word);
    }

    @Then("is displayed \"([^\"]*)\"$")
    public void resultsPage(String resultLink){
        googleResultsPage.resultLink(resultLink);
    }
}
