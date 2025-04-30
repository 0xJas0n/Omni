package fhv.omni.auth.service;

public class PasswordDoesNotMeetRequirementsException extends Exception {
    public PasswordDoesNotMeetRequirementsException(String message) {
        super(message);
    }
}
