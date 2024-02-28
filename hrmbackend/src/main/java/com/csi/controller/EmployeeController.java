package com.csi.controller;

import com.csi.model.Employee;
import com.csi.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.validation.Valid;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired

    private EmployeeServiceImpl employeeServiceImpl;

    @PostMapping("/save")

    public ResponseEntity<Employee> save(@Valid @RequestBody Employee employee) {

        return new ResponseEntity<>(employeeServiceImpl.save(employee), HttpStatus.CREATED);

    }

    @GetMapping("/findall")

    public ResponseEntity<List<Employee>> findAll() {

        return ResponseEntity.ok(employeeServiceImpl.findAll());

    }

    @GetMapping("/sortbyname/{empName}")

    public ResponseEntity<List<Employee>> sortByName() {

        return ResponseEntity.ok(employeeServiceImpl.findAll().stream().sorted(Comparator.comparing(Employee::getEmpName)).toList());

    }


}
