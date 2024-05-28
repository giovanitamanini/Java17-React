package com.study.dto;

import com.study.model.entity.Role;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EmployeeDTO {

    @NotNull(message = "O campo id_role não pode ser nulo!")
    private Integer id_role;

    @NotNull(message = "O campo name não pode ser nulo!")
    @Size(min = 3, max = 50, message = "O campo name precisa ter entre 3 e 50 caracteres.")
    private String name;

    @NotNull(message = "O campo birth_date não pode ser nulo!")
    private LocalDate birth_date;

    @NotNull(message = "O campo cpf não pode ser nulo!")
    private String cpf;

    @NotNull(message = "O campo contact não pode ser nulo!")
    private String contact;

    @NotNull(message = "O campo login não pode ser nulo!")
    @Size(min = 5, max = 30, message = "O campo login precisa ter entre 5 e 30 caracteres.")
    private String login;

    @NotNull(message = "O campo password não pode ser nulo!")
    @Size(min = 5, max = 30, message = "O campo password precisa ter entre 5 e 30 caracteres.")
    private String password;

    @NotNull(message = "O campo active não pode ser nulo!")
    private int active;
}
