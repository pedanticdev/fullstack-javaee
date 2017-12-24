/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pedantic.services;

import com.pedantic.entities.*;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * @author pedantic
 */
@Stateless
public class QueryService {

    @Inject
    EntityManager entityManager;


    public List<Employee> getAllEmployees() {
        return entityManager.createNamedQuery(Employee.FIND_ALL_EMPLOYEES_QUERY, Employee.class).getResultList();

    }

    public Employee findBySSNumber(String ssNumber) {
        List<Employee> ssNumber1 = entityManager.createNamedQuery(Employee.FIND_BY_SSNUMBER_QUERY, Employee.class)
                .setParameter("ssNumber", ssNumber).getResultList();
        if (!ssNumber1.isEmpty()) {
            return ssNumber1.get(0);
        }
        return null;
    }

    public List<Department> getAllDepartments() {
        TypedQuery<Department> deptQuery = entityManager.createNamedQuery(Department.FIND_ALL_DEPARTMENTS_QUERY,
                Department.class);

        return deptQuery.getResultList();
    }

    public Department getDepartmentByName(String name) {
        List<Department> resultList = entityManager.createNamedQuery(Department.FIND_DEPT_BY_NAME_QUERY,
                Department.class).setParameter("name", name).getResultList();
        if (!resultList.isEmpty()) {
            return resultList.get(0);
        }
        return null;
    }

    public List<Allowance> getAllAllowances() {
        return entityManager.createNamedQuery(Allowance.GET_ALL_ALLOWANCES_QUERY, Allowance.class)
                .getResultList();
    }

    public List<Allowance> getAllowanceByTaxNature(boolean taxable) {
        return entityManager.createNamedQuery(Allowance.FIND_TAXABLE_ALLOWANCES, Allowance.class)
                .setParameter("taxable", taxable).getResultList();
    }

    //Off camera
    //TODO go over all off camera code in detail
    public List<Bank> getAllBanks() {

        return entityManager.createNativeQuery("SELECT * from Bank", Bank.class).getResultList();
    }

    public int countTotalEmployees() {
        Number num = (Number) entityManager.createNativeQuery("SELECT count(id) FROM Employee").getSingleResult();
        return num.intValue();
    }

    public List<Loan> getAllLoans() {
        return entityManager.createNamedQuery(Loan.GET_ALL_LOANS_QUERY, Loan.class)
                .getResultList();
    }

    //Examples of using Entities as query parameters
    public List<EmployeeAllowance> getEmployeeAllowances(Employee employee) {
        return entityManager.createNamedQuery(EmployeeAllowance.GET_EMPLOYEE_ALLOWANCES, EmployeeAllowance.class)
                .setParameter("employee", employee).getResultList();
    }

    public List<EmployeeLoan> getEmployeeLoans(Employee employee) {

        return entityManager.createNamedQuery(EmployeeLoan.GET_ALL_EMPLOYEE_LOANS_QUERY, EmployeeLoan.class)
                .setParameter("employee", employee).getResultList();
    }

    //Criteria query basic example. Equivalent JPQL is 'select ssR from SocialSecurityRates ssR'
    public SocialSecurityRates getSSRates() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<SocialSecurityRates> query = criteriaBuilder.createQuery(SocialSecurityRates.class);
        Root<SocialSecurityRates> from = query.from(SocialSecurityRates.class);
        query.select(from);
        List<SocialSecurityRates> resultList = entityManager.createQuery(query).getResultList();
        if (!resultList.isEmpty()) {
            return resultList.get(0);
        }
        return null;
    }

    public Tax getTaxRate() {
        List<Tax> resultList = entityManager.createNamedQuery(Tax.GET_TAXES, Tax.class).getResultList();
        if (!resultList.isEmpty()) {
            return resultList.get(0);
        }
        return null;
    }

    public Allowance findAllowanceById(Long id) {
        return entityManager.find(Allowance.class, id);
    }

    public Bank findBankById(Long id) {
        return entityManager.find(Bank.class, id);
    }

    public Department findDepartmentById(Long id) {
        return entityManager.find(Department.class, id);
    }

    public Employee findEmployeeById(Long id) {
        return entityManager.find(Employee.class, id);
    }

    public EmployeeAllowance findEmployeeAllowanceById(Long id) {
        return entityManager.find(EmployeeAllowance.class, id);
    }

    public EmployeeLoan findEmployeeLoanById(Long id) {
        return entityManager.find(EmployeeLoan.class, id);
    }

    public Loan findLoanById(Long id) {
        return entityManager.find(Loan.class, id);
    }

    public PayPeriod findPayPeriodById(Long id) {
        return entityManager.find(PayPeriod.class, id);
    }

    public SocialSecurityRates getSSRById(Long id) {
        return entityManager.find(SocialSecurityRates.class, id);
    }

    public Tax getTaxById(Long id) {
        return entityManager.find(Tax.class, id);
    }

    public List<Employee> findEmployeesByNameLike(String name) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> query = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> root = query.from(Employee.class);

        Predicate predicate = criteriaBuilder.conjunction();
        predicate = criteriaBuilder.or(criteriaBuilder.like(root.get(Employee_.firstName), name),
                criteriaBuilder.like(root.get(Employee_.middleName), name),
                criteriaBuilder.like(root.get(Employee_.lastName), name));

        query.select(root);
        query.where(predicate);
        return entityManager.createQuery(query).getResultList();
    }

    public List<Employee> getEmployeesByNameLike(String name) {
        return entityManager.createQuery("select e from Employee e where e.firstName like :firstName or e.middleName like :middleName or e.lastName like :lastName", Employee.class)
                .setParameter("firstName", "%" + name  + "%")
                .setParameter("middleName", "%" + name  + "%")
                .setParameter("lastName", "%" + name  + "%")
                .getResultList();
    }


}
