package pl.lab.students.exceptions;

public class FleetException extends Exception {
    public FleetException() {
        super("Fleet manager unspecified error...");
    }
    public FleetException(String message) {
        super(message);
    }
}
