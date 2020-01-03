package testing.project.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.thucydides.core.annotations.Step;
import testing.project.pageobjects.CardOrderForm;

public class ConfirmCardFirstStep implements Task {
    public enum TaskName {
        FILLED_FIELDS,
        NOT_FILLED_FIELDS
    };
    private TaskName taskName;

    public ConfirmCardFirstStep(TaskName taskName) {
        this.taskName = taskName;
    }

    @Override
    @Step("{0} enters empty value in a required field")
    public <T extends Actor> void performAs(T actor) {
        switch (taskName) {
            case FILLED_FIELDS:
                actor.attemptsTo(
                        Enter.theValue("Тестов Тест Тестович").into(CardOrderForm.fullNameField()),
                        Enter.theValue("9872640002").into(CardOrderForm.phoneNumberField()),
                        Enter.theValue("test@test.test").into(CardOrderForm.emailField()),
                        Enter.theValue("01011990").into(CardOrderForm.birthDateField()),
                        Enter.theValue("Здоровенный Язь").into(CardOrderForm.codeWordField()),
                        Click.on(CardOrderForm.sendButton())
                );
                break;
            case NOT_FILLED_FIELDS:
                actor.attemptsTo(
                        Enter.theValue("").into(CardOrderForm.fullNameField()), // an empty required field to trigger an error
                        Enter.theValue("9872640002").into(CardOrderForm.phoneNumberField()),
                        Enter.theValue("test@test.test").into(CardOrderForm.emailField()),
                        Enter.theValue("01011990").into(CardOrderForm.birthDateField()),
                        Enter.theValue("Здоровенный Язь").into(CardOrderForm.codeWordField()),
                        Click.on(CardOrderForm.sendButton())
                );
                break;
            default:
                break;
        }
    }

    public static Performable withFilledFields() {
        return Instrumented.instanceOf(ConfirmCardFirstStep.class).withProperties(TaskName.FILLED_FIELDS);
    }
    public static Performable withNotFilledFields() {
        return Instrumented.instanceOf(ConfirmCardFirstStep.class).withProperties(TaskName.NOT_FILLED_FIELDS);
    }
}
