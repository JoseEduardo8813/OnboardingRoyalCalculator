package com.royalcaribbean.jose.calculator.mvp.models;


import android.text.TextUtils;

/**
 * This class contains the logic to do simple arithmetic operations (additions, subtraction, division and multiplication).
 */
public class CalculatorModel {

    private String valueOne = "";
    private String valueTwo = "";

    private static final String ADDITION = "+";
    private static final String SUBTRACTION = "-";
    private static final String MULTIPLICATION = "*";
    private static final String DIVISION = "/";
    private String currentOperation;

    public String addDigit(String value) {
        if (TextUtils.isEmpty(currentOperation)) {
            valueOne = valueOne + value;
            return valueOne;
        } else {
            valueTwo = valueTwo + value;
            return valueTwo;
        }
    }

    /**
     * This method set the current arithmetic operation to the model, the operation could be
     * addition, subtraction, division and multiplication.
     *
     * @param currentOperation current arithmetic operation.
     * @return {@code true} if the operation was set in the model {@code false} in other case.
     */
    public boolean registerOperation(String currentOperation) {
        if (!TextUtils.isEmpty(valueOne) && TextUtils.isEmpty(this.currentOperation)) {
            this.currentOperation = currentOperation;
            return true;
        }
        return false;
    }

    /**
     * This method clean the state of the model to start fresh a new operation.
     */
    public void clear() {
        valueOne = "";
        valueTwo = "";
        currentOperation = null;
    }

    /**
     * This method compute the current arithmetic operation {@link this#currentOperation} using the values {@link this#valueOne} and
     * {@link this#valueTwo}.
     *
     * @return The result of the current arithmetic operation.
     * @throws ArithmeticException   If a exceptional arithmetic condition has occurred. For example, an integer "divide by zero".
     * @throws IllegalStateException If the current operation is unsupported.
     * @throws NumberFormatException
     */
    public Double computeOperation() throws ArithmeticException, IllegalStateException, NumberFormatException {
        if (TextUtils.isEmpty(this.valueOne) || TextUtils.isEmpty(this.valueTwo)) {
            return 0d;
        }
        Double valueOne = Double.valueOf(this.valueOne);
        Double valueTwo = Double.valueOf(this.valueTwo);
        Double result;
        switch (currentOperation) {
            case ADDITION:
                result = valueOne + valueTwo;
                break;
            case SUBTRACTION:
                result = valueOne - valueTwo;
                break;
            case MULTIPLICATION:
                result = valueOne * valueTwo;
                break;
            case DIVISION:
                result = valueOne / valueTwo;
                break;
            default:
                throw new IllegalStateException("unsupported operation");
        }
        clear();
        return result;
    }
}
