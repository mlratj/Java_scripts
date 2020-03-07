package pl.lab.students;

import pl.lab.students.exceptions.FleetException;
import pl.lab.students.manager.FleetManager;
import pl.lab.students.manager.IFleetManager;
import pl.lab.students.model.Vehicle;

public class App {
    public static void main(String[] args) {
        try {
            IFleetManager fleetManager = new FleetManager();
            Vehicle rentedVehicle = fleetManager.rentVehicle("Testowy Test");
            System.out.println(
                    String.format(
                            "Wypożyczony pojazd - marka %s, model %s",
                            rentedVehicle.getBrand(),
                            rentedVehicle.getModel()
                    )
            );
            Vehicle secondRentedVehicle = fleetManager.rentVehicle("Drugi Testowy Test");
            System.out.println(
                    String.format(
                            "Kolejny wypożyczony pojazd - marka %s, model %s",
                            secondRentedVehicle.getBrand(),
                            secondRentedVehicle.getModel()
                    )
            );
            System.out.println(
                    String.format(
                            "Pojazd zwrócony przez %s",
                            fleetManager.recoverVehicle(rentedVehicle)
                    )
            );
            System.out.println(
                    String.format(
                            "Pojazd zwrócony przez %s",
                            fleetManager.recoverVehicle(secondRentedVehicle)
                    )
            );
        } catch (FleetException ex) {
            System.err.println("Przykro nam, wystąpił błąd obsługi wypożyczenia lub zwrotu pojazdu...");
        } catch (Exception ex) {
            System.err.println("Przykro nam, wystąpił błąd aplikacji...");
        }
    }
    }
