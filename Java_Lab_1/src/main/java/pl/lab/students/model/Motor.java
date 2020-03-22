package pl.lab.students.model;

public class Motor extends Vehicle {
    private static final int Price = 8;

    @Override
    public int getPrice() {
        return Price;
    }

    public Motor(String brand, String model, int HorsePower) {
        super(brand, model, HorsePower);
    }
}
