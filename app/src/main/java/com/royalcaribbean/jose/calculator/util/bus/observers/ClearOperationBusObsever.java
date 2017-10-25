package com.royalcaribbean.jose.calculator.util.bus.observers;


public abstract class ClearOperationBusObsever extends BusObserver<ClearOperationBusObsever.ClearOperationButtonPressed> {

    public ClearOperationBusObsever() {
        super(ClearOperationButtonPressed.class);
    }

    @Override
    public void onEvent(ClearOperationButtonPressed value) {
    }

    public static class ClearOperationButtonPressed {
    }
}