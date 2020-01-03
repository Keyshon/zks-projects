package testing.project.pageobjects;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import testing.project.Configuration;

@DefaultUrl(Configuration.baseUrl + "/person/bank_cards/debit/karta-s-bolshimi-bonusami/orderpremiumcard")
public class CardOrderForm extends PageObject {
    public static Target firstNameField() {
        return Target
                .the("First Name Field")
                .locatedBy("//input[@id='odc-personal__firstName']");
    }

    public static Target formHeader() {
        return Target
                .the("Form Header")
                .locatedBy("//h2[@class='odc-personal__header-section']");
    }

    public static Target lastNameField() {
        return Target
                .the("Last Name Field")
                .locatedBy("//input[@name='odc-personal__lastName']");
    }

    public static Target middleNameField() {
        return Target
                .the("Middle Name Field")
                .locatedBy("//input[@id='odc-personal__middleName']");
    }

    public static Target birthDateField() {
        return Target
                .the("Birth Date Field")
                .locatedBy("//input[@id='odc-personal__birthDate']");
    }

    public static Target emailField() {
        return Target
                .the("Email Field")
                .locatedBy("//input[@id='odc-personal__email']");
    }

    public static Target phoneField() {
        return Target
                .the("Phone Field")
                .locatedBy("//input[@id='odc-personal__phone' and contains(@class, '')]");
    }

    public static Target issueDateField() {
        return Target
                .the("Issue Date Field")
                .locatedBy("//input[@id='odc-personal__issueDate']");
    }

    public static Target seriesField() {
        return Target
                .the("Series Field")
                .locatedBy("//input[@id='odc-personal__series']");
    }

    public static Target numberField() {
        return Target
                .the("Number Field")
                .locatedBy("//input[@id='odc-personal__number']");
    }

    public static Target sendFirstStepButton() {
        return Target
                .the("Form First Step Send Button")
                .locatedBy("//div[@class='odc-footer']//button");
    }

    public static Target phoneConfirmationTitle() {
        return Target
                .the("Phone Confirmation Title")
                .locatedBy("//span[contains(@class, 'odc-sms__title')]");
    }

    public static Target firstNameFieldError() {
        return Target
                .the("First Name Field Error Text")
                .locatedBy("//input[@id='odc-personal__firstName']/parent::div/div[@class='odcui-error__text']");
    }

    public static Target cookieWarning() {
        return Target
                .the("Cookie Warning")
                .locatedBy("//a[@class='cookie-warning__close']");
    }
}
