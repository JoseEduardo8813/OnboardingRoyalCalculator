package com.royalcaribbean.jose.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.royalcaribbean.jose.calculator.mvp.models.CalculatorModel;
import com.royalcaribbean.jose.calculator.mvp.presenters.CalculatorPresenter;
import com.royalcaribbean.jose.calculator.mvp.views.CalculatorView;

/**
 * Basic Activity for the calculator, instantiates the {@link CalculatorPresenter}.
 */
public class CalculatorActivity extends AppCompatActivity {

    private CalculatorPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        presenter = new CalculatorPresenter(new CalculatorModel(), new CalculatorView(this));
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.register();
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.unregister();
    }
}
