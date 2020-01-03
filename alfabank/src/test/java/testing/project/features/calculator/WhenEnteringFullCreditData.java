package testing.project.features.calculator;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import static net.serenitybdd.screenplay.GivenWhenThen.*;

import net.thucydides.core.annotations.Managed;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.openqa.selenium.WebDriver;

import testing.project.questions.CreditCalculatorPrice;
import testing.project.tasks.ChangeCreditData;
import testing.project.tasks.StartWith;

import static org.hamcrest.Matchers.containsString;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="test-data/credit-values.csv")
public class WhenEnteringFullCreditData {
    private int creditSum;
    private int creditTerm;
    private String expectedCost;

    public void setCreditSum(int creditSum) {
        this.creditSum = creditSum;
    }
    public void setCreditTerm(int creditTerm) {
        this.creditTerm = creditTerm;
    }
    public void setExpectedCost(String expectedCost) {
        this.expectedCost = String.valueOf(expectedCost);
    }

    @Managed
    WebDriver browser;

    @Test
    public void shouldBeAbleToSeeSiteCategoryTitle() {
        Actor borat = new Actor("Borat");

        givenThat(borat).can(BrowseTheWeb.with(browser));
        givenThat(borat).wasAbleTo(StartWith.creditCalculatorPage());
        when(borat).attemptsTo(ChangeCreditData.withValues(creditSum, creditTerm));
        then(borat).should(seeThat(CreditCalculatorPrice.is(), containsString(expectedCost)));
    }
}
