package com.study.controller;

import com.study.dto.EmployeeDTO;
import com.study.model.entity.Employee;
import com.study.service.EmployeeService;
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
@RequestMapping("/employee")
public class EmployeeController {

    private static final Logger logger = LogManager.getLogger(EmployeeController.class);

    @Autowired
    EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<?> createEmployee(@Valid @RequestBody EmployeeDTO dto) {
        try {
            Employee employee = employeeService.createEmployee(dto);

            return new ResponseEntity<>("Funcionário " + employee.getId() + " criado!", HttpStatus.CREATED);
        } catch (RuntimeException e) {
            logger.error(e.getMessage());
            return new ResponseEntity<>("Não foi possível criar o funcionário.\n", HttpStatus.FORBIDDEN);
        }
    }
}
