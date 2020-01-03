package testing.project.features.calculator;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.screenplay.Actor;

import static net.serenitybdd.screenplay.GivenWhenThen.*;

import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import net.thucydides.junit.annotations.TestData;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.openqa.selenium.WebDriver;
import testing.project.questions.CreditCalculatorPrice;
import testing.project.tasks.ChangeCreditTerm;
import testing.project.tasks.StartWith;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.containsString;

@RunWith(SerenityParameterizedRunner.class)
public class WhenChangingCreditTerm {
    @TestData
    public static Collection<Object[]> testData(){
        return Arrays.asList(new Object[][]{
                {1, "26 450"},
                {2, "13 850"},
        });
    }
    private final int creditTermValue;
    private final String expectedCreditCost;

    public WhenChangingCreditTerm(int creditTermValue, String expectedCreditCost) {
        this.creditTermValue = creditTermValue;
        this.expectedCreditCost = expectedCreditCost;
    }

    @Managed
    WebDriver browser;

    @Test
    public void shouldBeAbleToSeeUpdatedCost() {
        Actor borat = new Actor("Borat");

        givenThat(borat).can(BrowseTheWeb.with(browser));
        givenThat(borat).wasAbleTo(StartWith.creditCalculatorPage());
        when(borat).attemptsTo(ChangeCreditTerm.toValue(creditTermValue));
        then(borat).should(seeThat(CreditCalculatorPrice.is(), containsString(expectedCreditCost)));
    }
}
