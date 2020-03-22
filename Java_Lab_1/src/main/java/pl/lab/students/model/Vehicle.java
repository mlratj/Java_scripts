package pl.lab.students.model;

public abstract class Vehicle {
    private final String brand;
    private final String model;
    private final int HorsePower;

    // final means that it is not possible to modify an attribute later on

    public Vehicle(String brand, String model, int HorsePower) {
        this.brand = brand;
        this.model = model;
        this.HorsePower = HorsePower;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getHorsePower() {
        return HorsePower;
    }

    public abstract int getPrice(); // abstract forces any function that inherits it must give a price
}

