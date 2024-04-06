package com.example.Employee.Service;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Employee.Entity.Employee;
import com.example.Employee.vo.EmployeeTaxInfo;

@Service
public class EmployeeTaxCalculator {
	 public   List<EmployeeTaxInfo> calculateTaxForEmployees(List<Employee> employees){
	        List<EmployeeTaxInfo> employeeTaxInfos = new ArrayList<>();

	        for (Employee employee : employees) {
	            Double yearlySalary = calculateYearlySalary(employee);
	            Double taxAmount = calculateTaxAmount(yearlySalary);
	            Double cessAmount = taxAmount * 0.04; // Assuming 4% cess

	            EmployeeTaxInfo taxInfo = new EmployeeTaxInfo();
	            taxInfo.setEmployeeId(employee.getEmployeeId());
	            taxInfo.setFirstName(employee.getFirstName());
	            taxInfo.setLastName(employee.getLastName());
	            taxInfo.setYearlySalary(yearlySalary);
	            taxInfo.setTaxAmount(taxAmount);
	            taxInfo.setCessAmount(cessAmount);

	            employeeTaxInfos.add(taxInfo);
	        }

	        return employeeTaxInfos;
	    }

	    private static Double calculateYearlySalary(Employee employee) {
		
	    	LocalDate dateOfJoining = employee.getDoj().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();;
	        double perMonthSalary =employee.getSalary();
	        // Calculate the date of next March
	        LocalDate nextMarch = dateOfJoining.plusYears(1).withMonth(Month.MARCH.getValue()).withDayOfMonth(1);

	        // Calculate the number of months from joining to next March
	        long monthsWorked = ChronoUnit.MONTHS.between(dateOfJoining, nextMarch);
	        double salary = perMonthSalary * monthsWorked;
	        System.out.println(salary);
	        return salary;
	    	
	    }

	    private static Double calculateTaxAmount(Double yearlySalary) {
	        if (yearlySalary <= 250000) {
	            return 0.0;
	        } else if (yearlySalary <= 500000) {
	            return (yearlySalary - 250000) * 0.05;
	        } else if (yearlySalary <= 1000000) {
	            return 12500 + (yearlySalary - 500000) * 0.1;
	        } else {
	            return 87500 + (yearlySalary - 1000000) * 0.2;
	        }
	    }
	
}

