
package kz.aitu.oop.practice.practice2;


class TrainCar {
    private int capacity;


    public TrainCar(int capacity) {
        this.capacity = capacity;
    }


    public int getCapacity() {
        return capacity;
    }
}


class PassengerCar extends TrainCar {
    private int numPassengers;


    public PassengerCar(int capacity, int numPassengers) {
        super(capacity);
        this.numPassengers = numPassengers;
    }

    public int getNumPassengers() {
        return numPassengers;
    }
}


class CargoCar extends TrainCar {
    private double cargoWeight;

    public CargoCar(int capacity, double cargoWeight) {
        super(capacity);
        this.cargoWeight = cargoWeight;
    }


    public double getCargoWeight() {
        return cargoWeight;
    }
}

class Locomotive {
    private int power;


    public Locomotive(int power) {
        this.power = power;
    }

    public int getPower() {
        return power;
    }
}


class Train {
    private Locomotive locomotive;
    private TrainCar[] cars;

    public Train(Locomotive locomotive, TrainCar[] cars) {
        this.locomotive = locomotive;
        this.cars = cars;
    }

    public int calculateTotalCarryingCapacity() {
        int totalCapacity = locomotive.getPower();

        for (TrainCar car : cars) {
            totalCapacity += car.getCapacity();
        }

        return totalCapacity;
    }


    public int calculateTotalPassengers() {
        int totalPassengers = 0;

        for (TrainCar car : cars) {
            if (car instanceof PassengerCar) {
                totalPassengers += ((PassengerCar) car).getNumPassengers();
            }
        }

        return totalPassengers;
    }
}

public class Main {
    public static void main(String[] args) {

        Locomotive locomotive = new Locomotive(500);
        TrainCar[] cars = {
                new PassengerCar(50, 30),
                new CargoCar(100, 500.0)
        };


        Train myTrain = new Train(locomotive, cars);

        System.out.println("Total Carrying Capacity: " + myTrain.calculateTotalCarryingCapacity());
        System.out.println("Total Passengers: " + myTrain.calculateTotalPassengers());
    }
}
