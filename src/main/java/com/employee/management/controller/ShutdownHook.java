package com.employee.management.controller;

import org.springframework.stereotype.Component;

import jakarta.annotation.PreDestroy;

@Component
public class ShutdownHook {

    @PreDestroy
    public void onShutdown() {
        // Add logic to release resources, such as database connections
        System.out.println("Releasing database connections and other resources...");
        // Example: Closing a DataSource if you manage it manually
        // dataSource.close();
    }
}

