package testing.project.features.navigation;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import static net.serenitybdd.screenplay.GivenWhenThen.*;

import net.thucydides.core.annotations.Managed;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.openqa.selenium.WebDriver;

import testing.project.questions.OnlineBankingUrl;
import testing.project.tasks.NavigateTo;

import static org.hamcrest.Matchers.containsString;

@RunWith(SerenityRunner.class)
public class WhenClickingOnOnlineBanking {
    @Managed
    WebDriver browser;

    @Test
    public void shouldBeAbleToSeeBankingPage() {
        Actor borat = new Actor("Borat");

        givenThat(borat).can(BrowseTheWeb.with(browser));
        when(borat).attemptsTo(NavigateTo.onlineBanking());
        then(borat).should(seeThat(OnlineBankingUrl.is(), containsString("https://click.alfabank.ru/login")));
    }
}
