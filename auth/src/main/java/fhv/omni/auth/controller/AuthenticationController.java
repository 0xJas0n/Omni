package fhv.omni.auth.controller;

import fhv.omni.auth.controller.model.AuthenticationRequest;
import fhv.omni.auth.controller.model.RegistrationRequest;
import fhv.omni.auth.service.RegistrationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class AuthenticationController {

    private final RegistrationService registrationService;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthenticationController(RegistrationService registrationService, AuthenticationManager authenticationManager) {
        this.registrationService = registrationService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(HttpServletRequest request, HttpServletResponse response,
                                        @Valid @RequestBody AuthenticationRequest authRequest) {
        try {
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                    authRequest.username(),
                    authRequest.password()
            );

            Authentication authentication = authenticationManager.authenticate(authenticationToken);

            SecurityContextHolder.getContext().setAuthentication(authentication);

            HttpSession session = request.getSession(true);
            session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
                    SecurityContextHolder.getContext());
            
            log.info("Login successful for user: {}, session ID: {}", authRequest.username(), session.getId());
            return ResponseEntity.ok()
                    .header("X-Auth-Token", session.getId())
                    .body("Login successful");
        } catch (AuthenticationException e) {
            log.warn("Login failed for user '{}': {}", authRequest.username(), e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed: " + e.getMessage());
        }
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody RegistrationRequest request) {
        if (!request.password().equals(request.passwordConfirm())) {
            return ResponseEntity.badRequest()
                    .body("Passwords do not match"); // Use a standard error response from core once its implemented
        }

        registrationService.register(request.email(), request.username(), request.password());

        return ResponseEntity.ok("Registration Successful"); // Use standard response builder for success messages
    }

    @RequestMapping(value = "/logout", method = {RequestMethod.POST, RequestMethod.GET})
    public ResponseEntity<String> logout(HttpServletRequest request) {
        //TODO: implement
        return ResponseEntity.badRequest().body("Not yet implemented");
    }

    @GetMapping("/authenticated") // Example endpoint for authenticated users
    public String testAuthentication() {
        return "You are authenticated";
    }
}
