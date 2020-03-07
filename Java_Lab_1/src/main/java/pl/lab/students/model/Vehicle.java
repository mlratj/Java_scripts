package pl.lab.students.model;

public abstract class Vehicle {
    private final String brand;
    private final String model;
    private final int HorsePower;

    // final powoduje, że nie można później modyfikować wartości atrybutu

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

    public abstract int getPrice(); // abstract powoduje, że funckje dziedziczace musza dac info o cenie
}

