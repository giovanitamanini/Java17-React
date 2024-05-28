package com.study.service;

import com.study.dto.EmployeeDTO;
import com.study.model.entity.Employee;
import com.study.model.entity.Role;
import com.study.model.repository.EmployeeRepository;
import com.study.model.repository.RoleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    RoleRepository roleRepository;

    @Transactional
    public Employee createEmployee(EmployeeDTO dto) {

        Role role = roleRepository.findById(dto.getId_role()).orElseThrow(() -> new RuntimeException("Role inexistente."));

        Employee employee = Employee.builder()
                .id(null)
                .role(role)
                .name(dto.getName())
                .birth_date(dto.getBirth_date())
                .cpf(dto.getCpf())
                .contact(dto.getContact())
                .login(dto.getLogin())
                .password(Base64.getEncoder().encodeToString(dto.getPassword().getBytes()))
                .active(dto.getActive())
                .build();

        return employeeRepository.save(employee);
    }
}
