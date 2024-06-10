package com.employee.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

        // Add shutdown hook to ensure cleanup
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                context.close();
                System.out.println("Application context closed. Resources cleaned up.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }));
    }
}


