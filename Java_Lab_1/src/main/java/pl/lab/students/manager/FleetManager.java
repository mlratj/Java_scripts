package pl.lab.students.manager;

import pl.lab.students.exceptions.FleetException;
import pl.lab.students.model.Car;
import pl.lab.students.model.Motor;
import pl.lab.students.model.Vehicle;
import java.util.ArrayList;
import java.util.HashMap;

public class FleetManager implements IFleetManager {
    private ArrayList<Vehicle> fleet = new ArrayList<>();
    private HashMap<Vehicle, String> fleetInUse = new HashMap<>();
    private ArrayList<Vehicle> fleetInPlace = new ArrayList<>();
    // <here goes all the elements>

    @Override
    public Vehicle rentVehicle(String loaner) throws FleetException {
        // jeżeli klasa wyrzuca wyjątek to trzeba o tym poinformwać tu i w interface!!
        if (this.fleetInPlace.size() <= 0) {
            throw new FleetException("No available vehicles to rent");
        }
        Vehicle vehicle = this.fleetInPlace.remove(0);
        this.fleetInUse.put(
                vehicle,
                loaner
        );
        return vehicle;
    }

    @Override
    public String recoverVehicle(Vehicle vehicle) throws FleetException {
        if (this.fleetInUse.size() <= 0) {
            throw new FleetException("No rented vehicles found...");
        }
        if (vehicle == null) {
            throw new FleetException("Please provide vehicle to recover...");
        }
        if (this.fleetInUse.get(vehicle) == null) {
            throw new FleetException("Provided vehicle is not rented...");
        }
        String loaner = this.fleetInUse.remove(vehicle);
        this.fleetInPlace.add(vehicle);
        return loaner;
    }

    private void initFleet() {
        this.fleet.add(new Car("Audi", "First", 99));
        this.fleet.add(new Car("VW", "Second", 108));
        this.fleet.add(new Motor("Kavasaki", "First", 117));
        this.fleetInPlace.addAll(this.fleet);
    }
    public FleetManager() {
        this.initFleet();
    }
}
