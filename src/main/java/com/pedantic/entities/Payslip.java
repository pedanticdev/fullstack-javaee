/**
 * This file was generated by the Jeddict
 */
package com.pedantic.entities;

import java.math.BigDecimal;
import java.time.LocalTime;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * @author pedantic
 */
@Entity
public class Payslip extends AbstractEntity {

    @Basic
    private BigDecimal netPay;

    @Basic
    private BigDecimal totalLoans;

    @Basic
    private BigDecimal totalAllowances;

    @Basic
    private LocalTime payPeriod;

    @OneToOne(targetEntity = Employee.class)
    private Employee employee;

    public BigDecimal getNetPay() {
        return this.netPay;
    }

    public void setNetPay(BigDecimal netPay) {
        this.netPay = netPay;
    }

    public BigDecimal getTotalLoans() {
        return this.totalLoans;
    }

    public void setTotalLoans(BigDecimal totalLoans) {
        this.totalLoans = totalLoans;
    }

    public BigDecimal getTotalAllowances() {
        return this.totalAllowances;
    }

    public void setTotalAllowances(BigDecimal totalAllowances) {
        this.totalAllowances = totalAllowances;
    }

    public LocalTime getPayPeriod() {
        return this.payPeriod;
    }

    public void setPayPeriod(LocalTime payPeriod) {
        this.payPeriod = payPeriod;
    }

    public Employee getEmployee() {
        return this.employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

}