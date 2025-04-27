package fhv.omni.auth.service;

import org.springframework.stereotype.Service;

@Service
public class BasicPasswordValidator implements IValidatePassword {
    @Override
    public void isValidPassword(String password) throws PasswordDoesNotMeetRequirementsException {
        //TODO: implement Logic
    }
}
