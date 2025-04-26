package fhv.omni.auth.controller;

import fhv.omni.auth.controller.model.AuthenticationRequest;
import fhv.omni.auth.controller.model.RegistrationRequest;
import fhv.omni.auth.service.RegistrationService;
import jakarta.validation.Valid;
import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    private final RegistrationService registrationService;

    public AuthenticationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping("/login")
    public void login(@Valid AuthenticationRequest request) {

    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid RegistrationRequest request) {
        if (!request.password().equals(request.passwordConfirm())) {
            return ResponseEntity.badRequest()
                    .body("Passwords do not match"); // Use a standard error response from core once its implemented
        }

        registrationService.register(request.email(), request.username(), request.password());

        return ResponseEntity.ok()
                .body("Registration Successful"); // same as above
    }
    
}
