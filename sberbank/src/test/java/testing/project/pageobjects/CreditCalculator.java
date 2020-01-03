package testing.project.pageobjects;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import testing.project.Configuration;

@DefaultUrl(Configuration.baseUrl + "/personal/kredit-nalichnymi")
public class CreditCalculator extends PageObject {
    public static Target sumField() {
        return Target
                .the("Sum Field")
                .locatedBy("//div[@class='any-slider'][1]//span");
    }
    public static Target sumFieldInput() {
        return Target
                .the("Sum Field Input")
                .locatedBy("//div[@class='any-slider'][1]//input[@class='kit-input__control']");
    }
    public static Target termField() {
        return Target
                .the("Term Field")
                .locatedBy("//div[@class='any-slider'][2]//span");
    }
    public static Target termFieldInput() {
        return Target
                .the("Term Field Input")
                .locatedBy("//div[@class='any-slider'][2]//input[@class='kit-input__control']");
    }
    public static Target monthCostResult() {
        return Target
                .the("Month Credit Cost")
                .locatedBy("//div[@class='calc-credit-output__payment']//span");
    }
    public static Target calculatorTitle() {
        return Target
                .the("Calculator Title")
                .locatedBy("//div[@class='calc-credit']");
    }
    public static Target cookieWarning() {
        return Target
                .the("Cookie Warning")
                .locatedBy("//a[@class='cookie-warning__close']");
    }
}
