package com.alonso.grpc.microservice.employee;

import com.alonso.grpc.microservice.employee.controller.EmployeeController;
import com.alonso.grpc.microservice.employee.service.EmployeeService;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class Application {
    public static void main(String [] args) throws InterruptedException, IOException {
       Server server = ServerBuilder.forPort(8081)
               .addService(new EmployeeController(new EmployeeService()))
               .build();

       server.start();
       server.awaitTermination();
   }
}
