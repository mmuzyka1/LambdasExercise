package org.example;

public abstract class Vehicle implements Mobile {

    private int maxSpeed;

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public Vehicle(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public void move() {
        System.out.println("My max speed is: " + this.maxSpeed);
    }
}
