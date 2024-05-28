package com.study.controller;

import com.study.dto.LoginDTO;
import com.study.model.entity.Employee;
import com.study.model.repository.EmployeeRepository;
import com.study.service.AuthService;
import jakarta.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private static final Logger logger = LogManager.getLogger(AuthController.class);

    @Autowired
    AuthService authService;

    @Autowired
    EmployeeRepository employeeRepository;

    @PostMapping
    public ResponseEntity<?> authenticate(@Valid @RequestBody LoginDTO dto) {
        try {
            Employee employee = authService.login(dto);

            return new ResponseEntity<>("Bem vindo, " + employee.getName(), HttpStatus.OK);
        } catch (RuntimeException e) {
            logger.error(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }
}
