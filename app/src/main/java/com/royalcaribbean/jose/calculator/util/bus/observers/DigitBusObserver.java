package com.royalcaribbean.jose.calculator.util.bus.observers;

public abstract class DigitBusObserver extends BusObserver<DigitBusObserver.DigitButtonPressed> {
    public DigitBusObserver() {
        super(DigitButtonPressed.class);
    }

    public static class DigitButtonPressed {
        private String digit;

        public DigitButtonPressed (String digit){
            this.digit = digit;
        }

        public String getDigit(){
            return digit;
        }
    }
}