package com.boa.employeespringapp.service;

import com.boa.employeespringapp.model.Employee;

import java.net.URI;
import java.util.List;

public interface EmployeeService {
    Employee getHighestPaidEmployee();

    List<Employee> addEmployee(List<Employee> employee);

    List<Employee> getAllFemaleEmployee();
}
