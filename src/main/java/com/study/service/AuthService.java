package com.study.service;

import com.study.dto.LoginDTO;
import com.study.model.entity.Employee;
import com.study.model.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class AuthService {

    @Autowired
    EmployeeRepository employeeRepository;

    public Employee login(LoginDTO dto) {

        Employee employee = employeeRepository.findByLogin(dto.getLogin())
                .orElseThrow(() -> new RuntimeException("Login inválido."));

        if (!employee.getPassword().equals(Base64.getEncoder().encodeToString(dto.getPassword().getBytes()))) {
            throw new RuntimeException("Senha inválida.");
        }

        return employee;
    }
}
