package testing.project.pageobjects;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import testing.project.Configuration;

@DefaultUrl(Configuration.baseUrl + "/everyday/debit-cards/alfacard-beta-2")
public class CardOrderForm extends PageObject {
    public static Target firstNameField() {
        return Target
                .the("First Name Field")
                .locatedBy("//input[@name='name']");
    }

    public static Target formHeader() {
        return Target
                .the("Form Header")
                .locatedBy("//div[@id='ApplyCardForm']");
    }

    public static Target lastNameField() {
        return Target
                .the("Last Name Field")
                .locatedBy("//input[@name='surname']");
    }

    public static Target middleNameField() {
        return Target
                .the("Middle Name Field")
                .locatedBy("//input[@name='patronymic']");
    }

    public static Target agreementToggle() {
        return Target
                .the("Birth Date Field")
                .locatedBy("//div[contains(@class, '_3AmOcudS')]");
    }

    public static Target phoneNumberField() {
        return Target
                .the("Phone Number Field")
                .locatedBy("//input[@name='phone']");
    }

    public static Target emailField() {
        return Target
                .the("Email Field")
                .locatedBy("//input[@name='email']");
    }

    public static Target sendFirstStepButton() {
        return Target
                .the("Form First Step Send Button")
                .locatedBy("//button[contains(@class, '_2muHqTnO')]");
    }

    public static Target secondStepTitle() {
        return Target
                .the("Second Step Title")
                .locatedBy("//div[contains(@class, 'top__in')]//h3");
    }

    public static Target firstNameFieldError() {
        return Target
                .the("First Name Field Error Text")
                .locatedBy("//input[@name='name']/ancestor::div[contains(@class, 'UeWblssj')]//div[contains(@class, '_1YiRHdPe')]");
    }
}
