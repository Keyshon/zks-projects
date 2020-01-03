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
public class WhenChangingSiteCategory {
    @TestData
    public static Collection<Object[]> testData(){
        return Arrays.asList(new Object[][]{
                {SiteCategory.Individuals, SiteCategory.Individuals.getPageTitle()},
                {SiteCategory.SmallBusiness,  SiteCategory.SmallBusiness.getPageTitle()},
                {SiteCategory.Corporate, SiteCategory.Corporate.getPageTitle()},
                {SiteCategory.Financial, SiteCategory.Financial.getPageTitle()},
                {SiteCategory.AClub, SiteCategory.AClub.getPageTitle()},
                {SiteCategory.Invest, SiteCategory.Invest.getPageTitle()}
        });
    }
    private final SiteCategory category;
    private final String categoryPageTitle;

    public WhenChangingSiteCategory(SiteCategory category, String categoryPageTitle) {
        this.category = category;
        this.categoryPageTitle = categoryPageTitle;
    }

    @Managed
    WebDriver browser;

    @Test
    public void shouldBeAbleToSeeCategoryTitle() {
        Actor borat = new Actor("Borat");

        givenThat(borat).can(BrowseTheWeb.with(browser));
        when(borat).attemptsTo(NavigateTo.category(category));
        then(borat).should(seeThat(TheWebPage.title(), containsString(categoryPageTitle)));
    }
}
