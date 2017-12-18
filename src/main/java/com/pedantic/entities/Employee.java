/**
 * This file was generated by the Jeddict
 */
package com.pedantic.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

/**
 * @author pedantic
 */
@Entity
public class Employee extends AbstractEntity {

    @Basic
    @NotNull(message = "First name cannot be blank")
    private String firstName;

    @Basic
    private String middleName;

    @Basic
    @NotNull(message = "Last name cannot be blank")
    private String lastName;

    @Basic
    @NotNull(message = "Date of birth is required")
    private LocalDate dob;

    @Basic
    @NotNull(message = "Basic salary cannot be blank")
    private BigDecimal basicSalary;

    @Basic
    @NotNull(message = "SSF number must be set")
    private String ssNumber;

    @Embedded
    private Address address;

    @OneToOne(targetEntity = EmployeeBank.class, mappedBy = "employee")
    private EmployeeBank employeeBank;

    @OneToOne(targetEntity = Payslip.class, mappedBy = "employee")
    private Payslip payslip;

    @ManyToOne(targetEntity = Department.class)
    private Department department;

    @OneToMany(targetEntity = EmployeeAllowance.class, mappedBy = "employee")
    private List<EmployeeAllowance> employeeAllowances;

    @OneToMany(targetEntity = EmployeeLoan.class, mappedBy = "employee")
    private List<EmployeeLoan> employeeLoans;

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return this.middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDob() {
        return this.dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public BigDecimal getBasicSalary() {
        return this.basicSalary;
    }

    public void setBasicSalary(BigDecimal basicSalary) {
        this.basicSalary = basicSalary;
    }

    public String getSsNumber() {
        return this.ssNumber;
    }

    public void setSsNumber(String ssNumber) {
        this.ssNumber = ssNumber;
    }

    public Address getAddress() {

        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public EmployeeBank getEmployeeBank() {
        return this.employeeBank;
    }

    public void setEmployeeBank(EmployeeBank employeeBank) {
        this.employeeBank = employeeBank;
    }

    public Payslip getPayslip() {
        return this.payslip;
    }

    public void setPayslip(Payslip payslip) {
        this.payslip = payslip;
    }

    public Department getDepartment() {
        return this.department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<EmployeeAllowance> getEmployeeAllowances() {
        return this.employeeAllowances;
    }

    public void setEmployeeAllowances(List<EmployeeAllowance> employeeAllowances) {
        this.employeeAllowances = employeeAllowances;
    }

    public List<EmployeeLoan> getEmployeeLoans() {
        return this.employeeLoans;
    }

    public void setEmployeeLoans(List<EmployeeLoan> employeeLoans) {
        this.employeeLoans = employeeLoans;
    }

    public String getFullName() {
        if (middleName != null && !middleName.isEmpty()) {
            return lastName + " " + middleName + " " + firstName;
        }
        return lastName + " " + firstName;
    }

    public int getAge() {
        return dob.until(LocalDate.now()).getYears();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.ssNumber);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Employee other = (Employee) obj;
        return Objects.equals(this.ssNumber, other.ssNumber);
    }
    

}
