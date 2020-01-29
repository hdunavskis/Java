package com.ait.example.business;

import com.ait.example.domain.Director;
import com.ait.example.domain.Employee;
import com.ait.example.domain.Manager;

public class EmployeeStockPlan {
    private final int DIRECTOR_SHARES = 1000;
    private final int MANAGER_SHARES = 100;
    private final int EMPLOYEE_SHARES = 10;

    public int grantStock(Employee employee){

        if(employee instanceof Director){
            return DIRECTOR_SHARES;
        }
        else if(employee instanceof Manager){
            return MANAGER_SHARES;
        }
        return EMPLOYEE_SHARES;

    }
}
