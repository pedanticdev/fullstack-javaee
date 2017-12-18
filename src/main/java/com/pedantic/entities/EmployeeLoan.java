/**
 * This file was generated by the Jeddict
 */
package com.pedantic.entities;

import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

/**
 * @author pedantic
 */
@Entity
public class EmployeeLoan extends AbstractEntity {

    @Basic
    @NotNull(message = "Loan amount must be set")
    private BigDecimal loanAmount;

    @Basic
    private boolean isCancelled;

    @OneToOne(targetEntity = Loan.class)
    private Loan loan;

    @ManyToOne(targetEntity = Employee.class)
    private Employee employee;

    public BigDecimal getLoanAmount() {
        return this.loanAmount;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    public boolean isIsCancelled() {
        return this.isCancelled;
    }

    public void setIsCancelled(boolean isCancelled) {
        this.isCancelled = isCancelled;
    }

    public Loan getLoan() {
        return this.loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public Employee getEmployee() {
        return this.employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

}