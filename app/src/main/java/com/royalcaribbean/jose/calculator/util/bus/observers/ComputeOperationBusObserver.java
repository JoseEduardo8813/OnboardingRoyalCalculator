package com.royalcaribbean.jose.calculator.util.bus.observers;


public abstract class ComputeOperationBusObserver extends BusObserver<ComputeOperationBusObserver.EqualButtonPressed> {

    public ComputeOperationBusObserver() {
        super(EqualButtonPressed.class);
    }

    @Override
    public void onEvent(EqualButtonPressed value) {
    }

    public static class EqualButtonPressed {
    }
}
