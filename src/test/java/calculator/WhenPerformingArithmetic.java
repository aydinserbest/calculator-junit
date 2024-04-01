package calculator;

import calculator.actions.MathActions;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class WhenPerformingArithmetic {
    @Steps
    MathActions matt;
    @Managed
    WebDriver driver;
    @Test
    public void shouldMultiplyTwoNumbers() {
        matt.opensTheCalculator();

        matt.calculates("2", "*", "2");

        assertThat(matt.seesAResult()).isEqualTo("4");

    }
}
