package com.example.Employee.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.Employee.Entity.Employee;
import com.example.Employee.Repository.EmployeeRepository;
import com.example.Employee.Service.EmployeeTaxCalculator;
import com.example.Employee.vo.EmployeeTaxInfo;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
@Validated
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeTaxCalculator employeeTaxCalculator;

    @PostMapping
    public ResponseEntity<?> createEmployee(@Valid @RequestBody Employee employee) {
        Employee savedEmployee = employeeRepository.save(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }
    @PostMapping("/tax-deductions")
    public  List<EmployeeTaxInfo> getTaxDeductionsForCurrentFinancialYear() {

        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeTaxInfo> employeeTaxInfos = employeeTaxCalculator.calculateTaxForEmployees(employees);

        return employeeTaxInfos;
    }
}
