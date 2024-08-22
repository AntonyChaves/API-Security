package com.TestePratico.XP.DTO;

import jakarta.validation.constraints.NotBlank;

public record AuthenticationDTO(

        @NotBlank
        String login,

        @NotBlank
        String password

) {
}
