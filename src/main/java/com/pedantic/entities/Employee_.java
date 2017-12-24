package com.pedantic.entities;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.math.BigDecimal;

@StaticMetamodel(Employee.class)
public class Employee_ {

    public static volatile SingularAttribute<Employee, Long> id;
    public static volatile SingularAttribute<Employee, BigDecimal> basicSalary;
    public static volatile SingularAttribute<Employee, String> firstName;
    public static volatile SingularAttribute<Employee, String> middleName;
    public static volatile SingularAttribute<Employee, String> lastName;
    public static volatile SingularAttribute<Employee, String> ssnNumber;

}
