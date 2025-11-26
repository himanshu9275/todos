package com.company.payroll;

import com.company.hr.Employee;

public class Payroll {
    public static double calculateBonus(Employee e){
        double bonus = e.getSalary()*0.10;
        e.setSalary(e.getSalary() + bonus);
        return bonus;
    }
}
