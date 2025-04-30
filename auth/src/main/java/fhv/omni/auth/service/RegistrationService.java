package fhv.omni.auth.service;

import fhv.omni.auth.entity.OmniUser;
import fhv.omni.auth.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class RegistrationService {

    private final IValidateEmail emailValidator;
    private final IValidatePassword passwordValidator;
    private final PasswordEncoder passwordEncoder;
    private final CrudRepository<OmniUser, String> omniUserCrudRepository;

    @Autowired
    public RegistrationService(IValidateEmail emailValidator, IValidatePassword passwordValidator, PasswordEncoder passwordEncoder, CrudRepository<OmniUser, String> omniUserCrudRepository) {
        this.emailValidator = emailValidator;
        this.passwordValidator = passwordValidator;
        this.passwordEncoder = passwordEncoder;
        this.omniUserCrudRepository = omniUserCrudRepository;
    }

    public void register(String email, String username, String password) {
        if (email == null || username == null || password == null) {
            throw new IllegalArgumentException("Email, username or password cannot be null");
        }

        if (!emailValidator.isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email format");
        }

        try {
            passwordValidator.isValidPassword(password);
        } catch (PasswordDoesNotMeetRequirementsException e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }

        String hashedPassword = passwordEncoder.encode(password);
        OmniUser omniUser = new OmniUser(
                UUID.randomUUID().toString(),
                email,
                username,
                hashedPassword,
                Set.of(Role.USER) // using USER role as standard for now
        );

        omniUserCrudRepository.save(omniUser);
    }

}
