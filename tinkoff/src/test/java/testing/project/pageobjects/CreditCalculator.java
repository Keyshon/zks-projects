package testing.project.pageobjects;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import testing.project.Configuration;

@DefaultUrl(Configuration.baseUrl + "/loans/cash-loan")
public class CreditCalculator extends PageObject {
    public static Target sumField() {
        return Target
                .the("Sum Field")
                .locatedBy("//input[@name='cashloan_calculator_amount_field']");
    }
    public static Target termField() {
        return Target
                .the("Term Field")
                .locatedBy("//input[@name='cashloan_calculator_term_field']");
    }
    public static Target monthCostResult() {
        return Target
                .the("Month Credit Cost")
                .locatedBy("//div[@class='Payment__payment_1Sf8I']/span");
    }
    public static Target calculatorTitle() {
        return Target
                .the("Calculator Title")
                .locatedBy("//div[@class='Header__centered_1XFhI']");
    }
}
