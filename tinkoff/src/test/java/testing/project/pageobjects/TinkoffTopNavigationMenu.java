package testing.project.pageobjects;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import testing.project.Configuration;
import testing.project.models.SiteCategory;

@DefaultUrl(Configuration.baseUrl)
public class TinkoffTopNavigationMenu extends PageObject {
    public static Target siteCategoryMenuSection(SiteCategory category) {
        return Target
                .the(category + " category")
                .locatedBy("//span[text()='{0}' and @data-qa-type='uikit/navigation.firstMenuItemTitle']/parent::a")
                .of(category.getName());
    }

    public static Target siteLogo() {
        return Target
                .the( "Index page logo")
                .locatedBy("//div[contains(@class, '_3m8xq')]//a[@data-qa-type='uikit/navigation.tinkoffLogo']");
    }

    public static Target onlineBankingButton() {
        return Target
                .the( "Online Banking Button")
                .locatedBy("//a[@data-qa-type='uikit/navigation.loginLink']");
    }
}
