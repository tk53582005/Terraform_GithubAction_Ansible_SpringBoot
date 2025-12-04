package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class App {
    
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
    
    @GetMapping("/")
    public String home() {
        return """
            <html>
            <head>
                <title>CI/CD Success</title>
                <style>
                    body { font-family: Arial, sans-serif; max-width: 800px; margin: 50px auto; padding: 20px; }
                    h1 { color: #2c3e50; }
                    .success { color: #27ae60; }
                    ul { line-height: 1.8; }
                </style>
            </head>
            <body>
                <h1 class="success">CI/CD Pipeline Success!</h1>
                <p>Spring Boot application deployed automatically via:</p>
                <ul>
                    <li>GitHub Actions</li>
                    <li>Terraform (Infrastructure as Code)</li>
                    <li>Ansible (Configuration Management)</li>
                </ul>
                <hr>
                <p><strong>Security Features:</strong></p>
                <ul>
                    <li>OIDC Authentication (No long-term credentials)</li>
                    <li>Manual Approval Required</li>
                    <li>Terraform fmt Enforcement</li>
                    <li>PR Auto Comment</li>
                </ul>
            </body>
            </html>
            """;
    }
    
    @GetMapping("/health")
    public String health() {
        return "OK";
    }
}
