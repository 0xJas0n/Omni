package fhv.omni.auth.controller.model;

import jakarta.validation.constraints.NotNull;

public record AuthenticationRequest(
        @NotNull String username,
        @NotNull String password) {
}
