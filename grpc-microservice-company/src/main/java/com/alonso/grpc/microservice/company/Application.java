package com.alonso.grpc.microservice.company;

import com.alonso.grpc.microservice.company.controller.CompanyController;
import com.alonso.grpc.microservice.company.service.CompanyService;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class Application {
    public static void main(String [] args) throws InterruptedException, IOException {
       Server server = ServerBuilder.forPort(8080)
               .addService(new CompanyController(new CompanyService()))
               .build();

       server.start();
       server.awaitTermination();
   }
}
