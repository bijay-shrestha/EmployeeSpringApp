package com.boa.employeespringapp.api;

import com.boa.employeespringapp.model.Employee;
import com.boa.employeespringapp.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {

    private final EmployeeService employeeService;

    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<Employee> getHighestPaidEmployee(){
        return ResponseEntity.ok(employeeService.getHighestPaidEmployee());
    }


    @GetMapping("/female")
    public ResponseEntity<List<Employee>> getAllFemaleEmployee(){
        return ResponseEntity.ok(employeeService.getAllFemaleEmployee());
    }

    @PostMapping
    public ResponseEntity<List<Employee>> addEmployee(@RequestBody List<Employee> employees){
        return new ResponseEntity<>(employeeService.addEmployee(employees), HttpStatus.CREATED);
    }
}
