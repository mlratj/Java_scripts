package pl.lab.students.model;

public class Car extends Vehicle { // extends pokazuje z czego dziedziczymy
    private static final int Price = 10;

    @Override
    public int getPrice() {
        return Price;
    }

    public Car(String brand, String model, int HorsePower) {
        super(brand, model, HorsePower);
    }
}
