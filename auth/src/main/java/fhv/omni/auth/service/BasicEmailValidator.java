package fhv.omni.auth.service;

import org.springframework.stereotype.Service;

@Service
public class BasicEmailValidator implements IValidateEmail {
    @Override
    public boolean isValidEmail(String email) {
        return true; //TODO: implement logic
    }
}
