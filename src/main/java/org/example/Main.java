package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        var truckOne = new Truck(150);
        var truckTwo = new Truck(130);
        var boatOne = new Boat(30);
        var boatTwo = new Boat(50);
        var humanOne = new Human();
        var humanTwo = new Human();
        var superTruck = new Truck(350) {
            @Override
            public void move() {
                System.out.println("I'm a super truck, I can drive with " + getMaxSpeed());
            }
        };

        List<Mobile> mobile = new ArrayList<>(Arrays.asList(truckOne, truckTwo, boatOne, boatTwo, humanOne, humanTwo, superTruck));

        var randomMobile = checkMobile(mobile);
        randomMobile.move();
        print(() -> System.out.println("I cannot run at all :("));
        introduce((String name) -> System.out.println("Hello " + name));
    }

    public static void print(Mobile mobile) {
        mobile.move();
    }

    public static void introduce(Talkable talkable) {
        talkable.sayHello("Marta");
    }

    public static <T> T getRandom(List<T> list) {
        return list.get(new Random().nextInt(list.size()));
    }

    public static <T extends Mobile> T checkMobile(List<T> list) {
        for (T t : list) {
            if (t instanceof Vehicle vehicle) {
                System.out.println("This is a vehicle. Max speed: " + vehicle.getMaxSpeed());
            } else {
                System.out.println("This is not a vehicle.");
            }
        }
        return getRandom(list);
    }
}