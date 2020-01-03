package testing.project.features.calculator;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;

import static net.serenitybdd.screenplay.GivenWhenThen.*;

import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.openqa.selenium.WebDriver;
import testing.project.questions.CreditCalculatorPrice;
import testing.project.tasks.ChangeCreditSum;
import testing.project.tasks.StartWith;

import static org.hamcrest.Matchers.containsString;

@RunWith(SerenityRunner.class)
public class WhenEnteringInvalidCreditSum {
    @Managed
    WebDriver browser;

    @Test
    public void shouldBeAbleToSeeDefaultCost() {
        Actor borat = new Actor("Borat");

        givenThat(borat).can(BrowseTheWeb.with(browser));
        givenThat(borat).wasAbleTo(StartWith.creditCalculatorPage());
        when(borat).attemptsTo(ChangeCreditSum.toValue(0));
        then(borat).should(seeThat(CreditCalculatorPrice.is(), containsString("8 143"))); // credit cost has not changed
    }
}
