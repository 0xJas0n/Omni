package fhv.omni.auth.controller.model;

import jakarta.validation.constraints.NotNull;

public record RegistrationRequest(
        @NotNull String email,
        @NotNull String username,
        @NotNull String password,
        @NotNull String passwordConfirm) {
}
