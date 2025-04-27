package fhv.omni.auth.service;

public interface IValidatePassword {
    void isValidPassword(String password) throws PasswordDoesNotMeetRequirementsException;
}
