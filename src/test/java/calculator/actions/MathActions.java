package calculator.actions;

public class MathActions {
    CalculatorActions onTheCalculator;

    public void opensTheCalculator() {
        onTheCalculator.openTheCalculator();
    }
    public void calculates(String leftOperand, String operator, String rightOperand) {
        onTheCalculator.enter(leftOperand, operator, rightOperand, "=");
    }
    public String seesAResult() {
        return onTheCalculator.displayedResult();
    }
}
