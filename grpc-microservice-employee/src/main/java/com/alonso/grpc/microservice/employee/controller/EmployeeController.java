package com.alonso.grpc.microservice.employee.controller;

import com.alonso.grpc.microservice.employee.EmployeeServiceGrpc;
import com.alonso.grpc.microservice.employee.EmployeesForCompanyResponse;
import com.alonso.grpc.microservice.employee.RetrieveEmployeesForCompanyRequest;
import com.alonso.grpc.microservice.employee.service.EmployeeService;
import io.grpc.stub.StreamObserver;

public class EmployeeController extends EmployeeServiceGrpc.EmployeeServiceImplBase {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void employees(RetrieveEmployeesForCompanyRequest request, StreamObserver<EmployeesForCompanyResponse> responseObserver) {

        responseObserver.onNext(
            EmployeesForCompanyResponse.newBuilder()
                .setNumberOfEmployees(
                    employeeService.retrieveNumberOfEmployeesFor(request.getCompany())
                )
                .build()
        );
        responseObserver.onCompleted();
    }
}
