package com.alonso.grpc.microservice.cliente;

import com.alonso.grpc.microservice.company.CompanyResponse;
import com.alonso.grpc.microservice.company.CompanyServiceGrpc;
import com.alonso.grpc.microservice.company.RetrieveCompanyRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class Application {

    public static void main(String [] args) {
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        CompanyResponse response = CompanyServiceGrpc
            .newBlockingStub(channel)
            .companies(RetrieveCompanyRequest.newBuilder()
            .setName("AlonsoCompany")
            .build()
        );

        System.out.println(response.getName());
        System.out.println(response.getCountry());
        System.out.println(response.getNumberOfEmployees());
        channel.shutdown();
    }
}
