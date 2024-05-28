package com.study.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LoginDTO {

    @NotNull(message = "O campo login não pode ser nulo!")
    private String login;

    @NotNull(message = "O campo password não pode ser nulo!")
    private String password;
}
