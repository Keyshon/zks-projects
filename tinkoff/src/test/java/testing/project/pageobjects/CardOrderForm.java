package testing.project.pageobjects;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import testing.project.Configuration;

@DefaultUrl(Configuration.baseUrl + "/cards/debit-cards/tinkoff-black/")
public class CardOrderForm extends PageObject {
    public static Target formHeader() {
        return Target
                .the("Form Header")
                .locatedBy("//div[@class='Header__centered_3otfC']");
    }
    public static Target fullNameField() {
        return Target
                .the("Full Name Field")
                .locatedBy("//input[@name='fio']");
    }
    public static Target fullNameFieldError() {
        return Target
                .the("Full Name Field Error Text")
                .locatedBy("//input[@name='fio']//ancestor::div[@class='Row__row_M1nfF']//div[@class='Error__errorMessage_3nSmp']");
    }
    public static Target phoneNumberField() {
        return Target
                .the("Phone Number Field")
                .locatedBy("//input[@name='phone_mobile']");
    }
    public static Target emailField() {
        return Target
                .the("Email Field")
                .locatedBy("//input[@name='email']");
    }
    public static Target birthDateField() {
        return Target
                .the("Birth Date Field")
                .locatedBy("//input[@name='birthdate']");
    }
    public static Target codeWordField() {
        return Target
                .the("Code Word Field")
                .locatedBy("//input[@name='mother_maiden_name']");
    }
    public static Target phoneConfirmationHeader() {
        return Target
                .the("Phone Confirmation Header")
                .locatedBy("//div[@class='Sms__title_2FpDV']");
    }
    public static Target sendButton() {
        return Target
                .the("Send Button")
                .locatedBy("//button[@name='goForward']");
    }
}
