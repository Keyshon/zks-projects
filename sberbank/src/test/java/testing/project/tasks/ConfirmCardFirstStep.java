package testing.project.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.targets.XPathOrCssTarget;
import net.serenitybdd.screenplay.waits.Wait;
import net.thucydides.core.annotations.Step;
import testing.project.pageobjects.CardOrderForm;
import testing.project.questions.SecondStep;

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
                        Click.on(CardOrderForm.cookieWarning()), // Closes cookie warning
                        Enter.theValue("Тестов").into(CardOrderForm.lastNameField()),
                        Enter.theValue("Тест").into(CardOrderForm.firstNameField()),
                        Enter.theValue("Тестович").into(CardOrderForm.middleNameField()),
                        Enter.theValue("01011994").into(CardOrderForm.birthDateField()),
                        Enter.theValue("test@test.test").into(CardOrderForm.emailField()),
                        Click.on(CardOrderForm.phoneField()),
                        Enter.keyValues("9872640002").into(CardOrderForm.phoneField()),
                        Enter.theValue("9209").into(CardOrderForm.seriesField()),
                        Enter.theValue("933169").into(CardOrderForm.numberField()),
                        Enter.theValue("15022012").into(CardOrderForm.issueDateField()),
                        Scroll.to(CardOrderForm.sendFirstStepButton()), // Otherwise, not clickable at point
                        Click.on(CardOrderForm.sendFirstStepButton())
                );
                break;
            case NOT_FILLED_FIELDS:
                actor.attemptsTo(
                        Click.on(CardOrderForm.cookieWarning()), // Closes cookie warning
                        Enter.theValue("Тестов").into(CardOrderForm.lastNameField()),
                        Enter.theValue("").into(CardOrderForm.firstNameField()),
                        Enter.theValue("Тестович").into(CardOrderForm.middleNameField()),
                        Enter.theValue("01011994").into(CardOrderForm.birthDateField()),
                        Enter.theValue("test@test.test").into(CardOrderForm.emailField()),
                        Click.on(CardOrderForm.phoneField()),
                        Enter.keyValues("9872640002").into(CardOrderForm.phoneField()),
                        Enter.theValue("9209").into(CardOrderForm.seriesField()),
                        Enter.theValue("933169").into(CardOrderForm.numberField()),
                        Enter.theValue("15022012").into(CardOrderForm.issueDateField()),
                        Scroll.to(CardOrderForm.sendFirstStepButton()), // Otherwise, not clickable at point
                        Click.on(CardOrderForm.sendFirstStepButton())
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
