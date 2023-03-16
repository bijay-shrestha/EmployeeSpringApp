package com.boa.employeespringapp.service.impl;

import com.boa.employeespringapp.model.Employee;
import com.boa.employeespringapp.repository.EmployeeRepository;
import com.boa.employeespringapp.service.EmployeeService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.math.BigDecimal.*;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee getHighestPaidEmployee() {
        List<Employee> employeeList = employeeRepository.findAll();
        for (Employee employee: employeeList){
            employee.setTotal(employee.getSalary().add(BigDecimal.valueOf(employee.getBonus())));
        }

        return employeeList.stream().max(Comparator.comparing(Employee::getTotal)).orElseThrow();
    }

    @Override
    public List<Employee> addEmployee(List<Employee> employees) {
        return employeeRepository.saveAll(employees);
    }

    @Override
    public List<Employee> getAllFemaleEmployee() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().filter(employee -> employee.getGender().equals('F')).collect(Collectors.toList());
    }


}
