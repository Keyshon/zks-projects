package testing.project.pageobjects;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import testing.project.Configuration;
import testing.project.models.SiteCategory;

@DefaultUrl(Configuration.baseUrl)
public class SberbankTopNavigationMenu extends PageObject {
    public static Target siteCategoryMenuSection(SiteCategory category) {
        return Target
                .the(category + " category")
                .locatedBy("//header//a[text()='{0}']")
                .of(category.getName());
    }

    public static Target siteLogo() {
        return Target
                .the( "Index page logo")
                .locatedBy("//img[@class='header__logo-image'|@class='header-legal__logo-image']");
    }

    public static Target onlineBankingButton() {
        return Target
                .the( "Online Banking Button")
                .locatedBy("//a[contains(@class, 'lg-menu__sbol')]");
    }
}
