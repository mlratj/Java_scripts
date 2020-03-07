package pl.lab.students.manager;

import pl.lab.students.exceptions.FleetException;
import pl.lab.students.model.Vehicle;

public interface IFleetManager {
    Vehicle rentVehicle(String loaner) throws FleetException;
    String recoverVehicle(Vehicle vehicle) throws FleetException;
}
