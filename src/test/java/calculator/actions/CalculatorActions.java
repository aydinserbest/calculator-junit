package calculator.actions;

import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.By;
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
            for(String key: keys) {
                WebElement button = buttonNamed(key);
                jsClick(button);
            }
        }
    public String displayedResult() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement display = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("calculated-display")));
        return display.getAttribute("value");
    }

    private final WebElement buttonNamed(String name) {
        //getDriver().findElement(By.xpath("//button[.='" + name + "']"));
       // findBy("//button[.='" + name + "']");
        return  $("//button[.='" + name + "']");
    }
    public void jsClick(WebElement element) {
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].click();", element);
    }
}
