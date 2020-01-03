package testing.project.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class OnlineBankingUrl implements Question<String> {
    @Override
    @Step("Page contains the right URL")
    public String answeredBy(Actor actor) {
        WebDriver driver = getDriver();
        return driver.getCurrentUrl();
    }

    public static Question<String> is() {
        return new OnlineBankingUrl();
    }

}
