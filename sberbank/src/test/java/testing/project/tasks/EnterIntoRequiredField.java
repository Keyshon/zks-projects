package testing.project.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import testing.project.pageobjects.CardOrderForm;
import testing.project.pageobjects.CreditCalculator;

public class EnterIntoRequiredField implements Task {
    @Override
    @Step("{0} enters empty value in a required field")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CreditCalculator.cookieWarning()), // Removes warning
                Enter.theValue("").into(CardOrderForm.firstNameField()),
                Click.on(CardOrderForm.formHeader())); // click to refresh application input values
    }

    public static Performable anEmptyValue() {
        return Instrumented.instanceOf(EnterIntoRequiredField.class).withProperties();
    }
}
