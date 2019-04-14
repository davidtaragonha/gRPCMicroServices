package com.alonso.grpc.microservice.company.service;

import com.alonso.grpc.microservice.employee.EmployeeServiceGrpc;
import com.alonso.grpc.microservice.employee.EmployeesForCompanyResponse;
import com.alonso.grpc.microservice.employee.RetrieveEmployeesForCompanyRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class CompanyService {

    private final ManagedChannel channel;

    public CompanyService() {
        channel = ManagedChannelBuilder
                .forAddress("localhost", 8081)
                .usePlaintext()
                .build();
    }

    public CompanyService(ManagedChannel channel) {
        this.channel = channel;
    }

    public int retrieveNumberOfEmployeesFor(String company){
        EmployeesForCompanyResponse response = EmployeeServiceGrpc
                .newBlockingStub(channel)
                .employees(
                    RetrieveEmployeesForCompanyRequest.newBuilder()
                        .setCompany(company)
                        .build()
                );

        return response.getNumberOfEmployees();
    }
}
