package com.royalcaribbean.jose.calculator.mvp.presenters;


import android.app.Activity;

import com.royalcaribbean.jose.calculator.R;
import com.royalcaribbean.jose.calculator.mvp.models.CalculatorModel;
import com.royalcaribbean.jose.calculator.mvp.views.CalculatorView;
import com.royalcaribbean.jose.calculator.util.bus.RxBus;
import com.royalcaribbean.jose.calculator.util.bus.observers.ClearOperationBusObsever;
import com.royalcaribbean.jose.calculator.util.bus.observers.ComputeOperationBusObserver;
import com.royalcaribbean.jose.calculator.util.bus.observers.DigitBusObserver;
import com.royalcaribbean.jose.calculator.util.bus.observers.StringBusObserver;

/**
 * This class coordinates the {@link CalculatorModel} and {@link CalculatorView}.
 */
public class CalculatorPresenter {

    private CalculatorModel model;
    private CalculatorView view;

    /**
     * This constructor initialize the fields {@link this#model} and {@link this#view}.
     *
     * @param model Model of the calculator, this object contains the logic to do simple arithmetic operations.
     * @param view  This is the calculator view, this object in charge to post all the events fired by the user and show all the results
     *              that comes from the model.
     */
    public CalculatorPresenter(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;
        this.view.display("0");
    }

    /**
     * This method register the events that comes from {@link CalculatorView}
     */
    public void register() {
        Activity activity = view.getActivity();

        if (activity == null) {
            return;
        }
        RxBus.subscribe(activity, new DigitBusObserver() {
            @Override
            public void onEvent(DigitButtonPressed value) {
                onDigitPressed(value.getDigit());
            }
        });

        RxBus.subscribe(activity, new StringBusObserver() {
            @Override
            public void onEvent(String value) {
                onOperatorPressed(value);
            }
        });

        RxBus.subscribe(activity, new ComputeOperationBusObserver() {
            @Override
            public void onEvent(EqualButtonPressed value) {
                onEqualsPressed();
            }
        });

        RxBus.subscribe(activity, new ClearOperationBusObsever() {
            @Override
            public void onEvent(ClearOperationButtonPressed value) {
                onClearOperationPressed();
            }
        });
    }


    /**
     * This method unregister the events that comes from {@link CalculatorView}
     */
    public void unregister() {
        Activity activity = view.getActivity();

        if (activity == null) {
            return;
        }
        RxBus.clear(activity);
    }

    /**
     * This method execute the arithmetic operation and display the result in the {@link CalculatorView}. If the arithmetic operation
     * was invalid this method handle the error.
     */
    public void onEqualsPressed() {
        try {
            Double result = model.computeOperation();
            view.display(String.valueOf(result));
        } catch (ArithmeticException error) {
            handleError();
        } catch (IllegalStateException error) {
            handleError();
        } catch (NumberFormatException error) {
            handleError();
        }
    }

    /**
     * Register the arithmetic operation.
     *
     * @pram arithmeticOperation could addition (+), subtraction(-), division(/) and multiplication(*)
     */
    public void onOperatorPressed(String arithmeticOperation) {
        if (model.registerOperation(arithmeticOperation)) {
            view.display(arithmeticOperation);
        }
    }

    /**
     * Handle the digit taped by the user.
     *
     * @param digit could be any decimal number 0..9
     */
    public void onDigitPressed(String digit) {
        view.display(model.addDigit(digit));
    }

    /**
     * This method clean the the model to start fresh a new operation.
     */
    public void onClearOperationPressed() {
        model.clear();
        view.display("0");
    }

    /**
     * Handle the error for an arithmetic operation.
     */
    private void handleError() {
        model.clear();
        view.display(view.getActivity().getString(R.string.error_invalid_operation));
    }
}
