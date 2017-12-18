/**
 * This file was generated by the Jeddict
 */
package com.pedantic.entities;

import java.time.LocalDate;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 * @author pedantic
 */
@Entity
public class PayPeriod extends AbstractEntity {

    @Basic
    @NotNull(message = "Period start date must be set")
    private LocalDate startDate;

    @Basic
    private LocalDate endDate;

    @Basic
    @NotNull(message = "Period type must be set")
    private String periodType;

    public LocalDate getStartDate() {
        return this.startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return this.endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getPeriodType() {
        return this.periodType;
    }

    public void setPeriodType(String periodType) {
        this.periodType = periodType;
    }

}