package pl.lab.students;

import pl.lab.students.exceptions.FleetException;
import pl.lab.students.manager.FleetManager;
import pl.lab.students.manager.IFleetManager;
import pl.lab.students.model.Vehicle;

public class App {
    public static void main(String[] args) {
        try {
            IFleetManager fleetManager = new FleetManager();
            Vehicle rentedVehicle = fleetManager.rentVehicle("First Tester");
            System.out.println(
                    String.format(
                            "Rented vehicle - brand %s, model %s",
                            rentedVehicle.getBrand(),
                            rentedVehicle.getModel()
                    )
            );
            Vehicle secondRentedVehicle = fleetManager.rentVehicle("Second Tester");
            System.out.println(
                    String.format(
                            "Next rented vehicle - brand %s, model %s",
                            secondRentedVehicle.getBrand(),
                            secondRentedVehicle.getModel()
                    )
            );
            System.out.println(
                    String.format(
                            "Vehicle given back by %s",
                            fleetManager.recoverVehicle(rentedVehicle)
                    )
            );
            System.out.println(
                    String.format(
                            "Vehicle given back by %s",
                            fleetManager.recoverVehicle(secondRentedVehicle)
                    )
            );
        } catch (FleetException ex) {
            System.err.println("I am sorry, but an error occurred, while renting a vehicle...");
        } catch (Exception ex) {
            System.err.println("App crushed, sorry!");
        }
    }
    }
