package calculator.actions;

import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CalculatorActions extends UIInteractionSteps {
    public void openTheCalculator() {
        openUrl("https://testpages.eviltester.com/styled/apps/calculator.html");
    }
    public void enter(String... keys) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10)); // 10 seconds timeout
        for(String key: keys) {
            WebElement button = buttonNamed(key);
            jsClick(button);
        }
    }
    public String displayedResult() {
        return find("#calculated-display").getAttribute("value");
    }

    private final WebElement buttonNamed(String name) {
        return $("//button[.='" + name + "']");
    }
    public void jsClick(WebElement element) {
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].click();", element);
    }
}
