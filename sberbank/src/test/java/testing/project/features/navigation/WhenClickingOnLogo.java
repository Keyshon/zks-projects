package testing.project.features.navigation;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import static net.serenitybdd.screenplay.GivenWhenThen.*;

import net.thucydides.core.annotations.Managed;
import net.thucydides.junit.annotations.TestData;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.openqa.selenium.WebDriver;

import testing.project.models.SiteCategory;
import testing.project.tasks.NavigateTo;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.containsString;

@RunWith(SerenityParameterizedRunner.class)
public class WhenClickingOnLogo {
    @TestData
    public static Collection<Object[]> testData(){
        return Arrays.asList(new Object[][]{
                {SiteCategory.Individuals, SiteCategory.Individuals.getPageTitle()},
                {SiteCategory.IndividualBusiness, SiteCategory.SmallBusiness.getPageTitle()},
                {SiteCategory.SmallBusiness, SiteCategory.SmallBusiness.getPageTitle()},
                {SiteCategory.About, SiteCategory.Individuals.getPageTitle()}
        });
    }
    private final SiteCategory category;
    private final String expectedResult;

    public WhenClickingOnLogo(SiteCategory category, String expectedResult) {
        this.category = category;
        this.expectedResult = expectedResult;
    }

    @Managed
    WebDriver browser;

    @Test
    public void shouldBeAbleToSeeSiteCategoryTitle() {
        Actor borat = new Actor("Borat");

        givenThat(borat).can(BrowseTheWeb.with(browser));
        when(borat).attemptsTo(NavigateTo.indexFromCategory(category));
        then(borat).should(seeThat(TheWebPage.title(), containsString(expectedResult)));
    }
}
