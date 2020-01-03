package testing.project.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import testing.project.pageobjects.CreditCalculator;

public class ChangeCreditTerm implements Task {
    private final int value;

    public ChangeCreditTerm(int value) {
        this.value = value;
    }

    @Override
    @Step("{0} enters a credit term")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CreditCalculator.cookieWarning()), // Removes warning
                Click.on(CreditCalculator.termField()), // Activates input
                Enter.theValue(String.valueOf(value)).into(CreditCalculator.termFieldInput()),
                Click.on(CreditCalculator.calculatorTitle())); // click to refresh application input values
    }

    public static Performable toValue(int num) {
        return Instrumented.instanceOf(ChangeCreditTerm.class).withProperties(num);
    }
}
