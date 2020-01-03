package testing.project.features.order;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import testing.project.questions.SecondStep;
import testing.project.tasks.ConfirmCardFirstStep;
import testing.project.tasks.StartWith;

import static net.serenitybdd.screenplay.GivenWhenThen.*;

@RunWith(SerenityRunner.class)
public class WhenConfirmingCardOrderStepWithValidData {
    @Managed
    WebDriver browser;

    @Test
    public void shouldBeAbleToSeeTheSecondStep() {
        Actor borat = new Actor("Borat");

        givenThat(borat).can(BrowseTheWeb.with(browser));
        givenThat(borat).wasAbleTo(StartWith.cardOrderPage());
        when(borat).attemptsTo(ConfirmCardFirstStep.withFilledFields());
        then(borat).should(seeThat(SecondStep.isDisplayed()));
    }
}
