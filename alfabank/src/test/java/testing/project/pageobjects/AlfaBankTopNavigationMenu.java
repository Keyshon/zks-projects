package testing.project.pageobjects;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import testing.project.Configuration;
import testing.project.models.SiteCategory;

@DefaultUrl(Configuration.baseUrl)
public class AlfaBankTopNavigationMenu extends PageObject {
    public static Target siteCategoryMenuSection(SiteCategory category) {
        return Target
                .the(category + " category")
                .locatedBy("//div[@class='header-segments__3c0kJ']//li[{0}]") // Using of link names is not possible due to html entities
                .of(String.valueOf(category.getOrder() + 1)); // Starting from one
    }

    public static Target siteLogo() {
        return Target
                .the( "Index page logo")
                .locatedBy("//div[@class='header-logo__1kaTG']");
    }

    public static Target onlineBankingButton() {
        return Target
                .the( "Online Banking Button")
                .locatedBy("//a[@title='Интернет-банк']");
    }
}
