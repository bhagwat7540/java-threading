package org.example.coffeemachine.beverage;

public abstract class BeverageDecorator implements Beverage{
    protected final Beverage beverageInner;
    public BeverageDecorator(Beverage beverageInner) {
        this.beverageInner = beverageInner;
    }
}
