package com.alonso.grpc.microservice.employee.service;

public class EmployeeService {

    public int retrieveNumberOfEmployeesFor(String company) {
        System.out.println(company);
        int numberOfEmployees = 0;
        if("AlonsoCompany".equals(company)){
            numberOfEmployees = 202;
        }

        return numberOfEmployees;
    }
}
