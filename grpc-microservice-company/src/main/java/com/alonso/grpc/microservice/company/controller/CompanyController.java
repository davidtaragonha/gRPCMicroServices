package com.alonso.grpc.microservice.company.controller;

import com.alonso.grpc.microservice.company.CompanyResponse;
import com.alonso.grpc.microservice.company.CompanyServiceGrpc;
import com.alonso.grpc.microservice.company.RetrieveCompanyRequest;
import com.alonso.grpc.microservice.company.service.CompanyService;
import io.grpc.stub.StreamObserver;

public class CompanyController extends CompanyServiceGrpc.CompanyServiceImplBase {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }


    @Override
    public void companies(RetrieveCompanyRequest request,
                          StreamObserver<CompanyResponse> responseObserver) {

        int numberOfEmployees = companyService.retrieveNumberOfEmployeesFor(request.getName());

        responseObserver.onNext(
            CompanyResponse.newBuilder()
                .setName(request.getName())
                .setCountry("Spain")
                .setNumberOfEmployees(numberOfEmployees)
                .build()
        );

        responseObserver.onCompleted();
    }
}
