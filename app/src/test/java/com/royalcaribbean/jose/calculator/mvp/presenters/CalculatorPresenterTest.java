package com.royalcaribbean.jose.calculator.mvp.presenters;


import android.app.Activity;

import com.royalcaribbean.jose.calculator.mvp.models.CalculatorModel;
import com.royalcaribbean.jose.calculator.mvp.views.CalculatorView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CalculatorPresenterTest {

    private CalculatorPresenter presenter;
    @Mock CalculatorModel model;
    @Mock CalculatorView view;
    @Mock Activity activity;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        presenter = new CalculatorPresenter(model, view);
    }

    @Test
    public void invalidOperationTest() {
        when(model.computeOperation()).thenThrow(new ArithmeticException());
        when(activity.getString(anyInt())).thenReturn("invalid operation");
        when(view.getActivity()).thenReturn(activity);
        presenter.onEqualsPressed();
        verify(model).computeOperation();
        verify(view, never()).display(String.valueOf(43d));
        verify(model).clear();
        verify(view).display("invalid operation");
    }

    @Test
    public void validOperationTest() {
        when(model.computeOperation()).thenReturn(43d);
        presenter.onEqualsPressed();
        verify(model).computeOperation();
        verify(view, times(1)).display(String.valueOf(43d));
        verify(model, never()).clear();
    }

    @Test
    public void operatorRegisterTest() {
        when(model.registerOperation("-")).thenReturn(false);
        presenter.onOperatorPressed("-");
        verify(model).registerOperation("-");
        verify(view, times(1)).display("0");
    }

    @Test
    public void operatorUnregisterTest() {
        when(model.registerOperation("*")).thenReturn(true);
        presenter.onOperatorPressed("*");
        verify(model).registerOperation("*");
        verify(view).display("*");
    }

    @Test
    public void digitPressedTest() {
        when(model.addDigit("9")).thenReturn("99");
        presenter.onDigitPressed("9");
        verify(model).addDigit("9");
        verify(view).display("99");
    }

    @Test
    public void clearOperationPressedTest() {
        presenter.onClearOperationPressed();
        verify(model).clear();
        verify(view, times(2)).display("0");
    }
}
