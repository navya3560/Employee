package com.example.Employee.vo;

public class EmployeeTaxInfo {
	private String employeeId;
	private String firstName;
	private String lastName;
	private Double yearlySalary;
	private Double taxAmount;
	private Double cessAmount;

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Double getYearlySalary() {
		return yearlySalary;
	}

	public void setYearlySalary(Double yearlySalary) {
		this.yearlySalary = yearlySalary;
	}

	public Double getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(Double taxAmount) {
		this.taxAmount = taxAmount;
	}

	public Double getCessAmount() {
		return cessAmount;
	}

	public void setCessAmount(Double cessAmount) {
		this.cessAmount = cessAmount;
	}

	@Override
	public String toString() {
		return "EmployeeTaxInfo [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", yearlySalary=" + yearlySalary + ", taxAmount=" + taxAmount + ", cessAmount=" + cessAmount + "]";
	}

}
