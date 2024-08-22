package com.TestePratico.XP.DTO;

import com.TestePratico.XP.Enum.UserRole;

public record RegisterDTO(

        String login,

        String password,

        UserRole role

) {
}
