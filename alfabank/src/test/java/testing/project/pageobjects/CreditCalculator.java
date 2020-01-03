package testing.project.pageobjects;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import testing.project.Configuration;

@DefaultUrl(Configuration.baseUrl + "/get-money/credit/credit-cash")
public class CreditCalculator extends PageObject {
    public static Target sumField() {
        return Target
                .the("Sum Field")
                .locatedBy("//input[@name='creditAmount']");
    }
    public static Target termListItem(int item) {
        return Target
                .the("Term list item " + String.valueOf(item))
                .locatedBy("//div[@class='_1b6utU2-']//button[{0}]").of(String.valueOf(item + 1)); // +1 because XPath starts counting from 1, not 0
    }
    public static Target monthCostResult() {
        return Target
                .the("Month Credit Cost")
                .locatedBy("//div[contains(@class, '_3w139KjS')]/p");
    }
    public static Target calculatorTitle() {
        return Target
                .the("Calculator Title")
                .locatedBy("//div[@id='refin-calculator']");
    }
}
