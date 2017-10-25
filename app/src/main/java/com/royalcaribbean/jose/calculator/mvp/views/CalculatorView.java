package com.royalcaribbean.jose.calculator.mvp.views;


import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;

import com.royalcaribbean.jose.calculator.R;
import com.royalcaribbean.jose.calculator.util.bus.RxBus;
import com.royalcaribbean.jose.calculator.util.bus.observers.ClearOperationBusObsever;
import com.royalcaribbean.jose.calculator.util.bus.observers.ComputeOperationBusObserver;
import com.royalcaribbean.jose.calculator.util.bus.observers.DigitBusObserver;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * This class is in charge to send all the events of the calculator following the user input.
 */
public class CalculatorView extends ActivityView {

    @BindView(R.id.text_calculator_display)
    TextView calculatorDisplay;

    public CalculatorView(Activity activity) {
        super(activity);
        ButterKnife.bind(this, activity);
    }

    /**
     * Send a notification that the digit seven has been tapped.
     *
     * @param button View tapped by the user.
     */
    @OnClick(R.id.button_digit_seven)
    public void digitSevenPressed(Button button) {
        String digit = String.valueOf(button.getText());
        RxBus.post(new DigitBusObserver.DigitButtonPressed(digit));
    }

    /**
     * Send a notification that the digit eight has been tapped.
     *
     * @param button View tapped by the user.
     */
    @OnClick(R.id.button_digit_eight)
    public void digitEightPressed(Button button) {
        String digit = String.valueOf(button.getText());
        RxBus.post(new DigitBusObserver.DigitButtonPressed(digit));
    }

    /**
     * Send a notification that the digit nine has been tapped.
     *
     * @param button View tapped by the user.
     */
    @OnClick(R.id.button_digit_nine)
    public void digitNinePressed(Button button) {
        String digit = String.valueOf(button.getText());
        RxBus.post(new DigitBusObserver.DigitButtonPressed(digit));
    }

    /**
     * Send a notification that the digit four has been tapped.
     *
     * @param button View tapped by the user.
     */
    @OnClick(R.id.button_digit_four)
    public void digitFourPressed(Button button) {
        String digit = String.valueOf(button.getText());
        RxBus.post(new DigitBusObserver.DigitButtonPressed(digit));
    }

    /**
     * Send a notification that the digit five has been tapped.
     *
     * @param button View tapped by the user.
     */
    @OnClick(R.id.button_digit_five)
    public void digitFivePressed(Button button) {
        String digit = String.valueOf(button.getText());
        RxBus.post(new DigitBusObserver.DigitButtonPressed(digit));
    }

    /**
     * Send a notification that the digit six has been tapped.
     *
     * @param button View tapped by the user.
     */
    @OnClick(R.id.button_digit_six)
    public void digitSixPressed(Button button) {
        String digit = String.valueOf(button.getText());
        RxBus.post(new DigitBusObserver.DigitButtonPressed(digit));
    }

    /**
     * Send a notification that the digit one has been tapped.
     *
     * @param button View tapped by the user.
     */
    @OnClick(R.id.button_digit_one)
    public void digitOnePressed(Button button) {
        String digit = String.valueOf(button.getText());
        RxBus.post(new DigitBusObserver.DigitButtonPressed(digit));
    }

    /**
     * Send a notification that the digit two has been tapped.
     *
     * @param button View tapped by the user.
     */
    @OnClick(R.id.button_digit_two)
    public void digitTwoPressed(Button button) {
        String digit = String.valueOf(button.getText());
        RxBus.post(new DigitBusObserver.DigitButtonPressed(digit));
    }

    /**
     * Send a notification that the digit three has been tapped.
     *
     * @param button View tapped by the user.
     */
    @OnClick(R.id.button_digit_three)
    public void digitThreePressed(Button button) {
        String digit = String.valueOf(button.getText());
        RxBus.post(new DigitBusObserver.DigitButtonPressed(digit));
    }

    /**
     * Send a notification that the digit zero has been tapped.
     *
     * @param button View tapped by the user.
     */
    @OnClick(R.id.button_digit_zero)
    public void digitZeroPressed(Button button) {
        String digit = String.valueOf(button.getText());
        RxBus.post(new DigitBusObserver.DigitButtonPressed(digit));
    }

    /**
     * Send a notification that the addition operator has been tapped.
     *
     * @param button View tapped by the user.
     */
    @OnClick(R.id.button_operator_addition)
    public void additionPressed(Button button) {
        RxBus.post(String.valueOf(button.getText()));
    }

    /**
     * Send a notification that the subtraction operator has been tapped.
     *
     * @param button View tapped by the user.
     */
    @OnClick(R.id.button_operator_subtraction)
    public void subtractionPressed(Button button) {
        RxBus.post(String.valueOf(button.getText()));
    }

    /**
     * Send a notification that the multiplication operator has been tapped.
     *
     * @param button View tapped by the user.
     */
    @OnClick(R.id.button_operator_multiplication)
    public void multiplicationPressed(Button button) {
        RxBus.post(String.valueOf(button.getText()));
    }

    /**
     * Send a notification that the division operator has been tapped.
     *
     * @param button View tapped by the user.
     */
    @OnClick(R.id.button_operator_division)
    public void divisionPressed(Button button) {
        RxBus.post(String.valueOf(button.getText()));
    }

    /**
     * Send a notification that the equal button has been tapped.
     */
    @OnClick(R.id.button_equal)
    public void equalPressed() {
        RxBus.post(new ComputeOperationBusObserver.EqualButtonPressed());
    }

    /**
     * Send a notification that the equal button has been tapped.
     */
    @OnClick(R.id.button_clear)
    public void clearPressed() {
        RxBus.post(new ClearOperationBusObsever.ClearOperationButtonPressed());
    }

    /**
     * Display the arithmetic operation result.
     */
    public void display(String digit) {
        calculatorDisplay.setText(digit);
    }
}
