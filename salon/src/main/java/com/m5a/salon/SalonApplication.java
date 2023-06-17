package com.m5a.salon;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "INTERFAZ SWAGGER PARA LA RESERVA DE SALONES DE EVENTOS",
                version = "1.0.0",
                description = "PROYECTO REALIZADO POR EL M5A",
                termsOfService = "M5A",
                contact = @Contact(
                        name = "Instituto Superior Tecnologico Del Azuay",
                        email = "info@tecazuay.edu.ec"
                )
        )
)
public class SalonApplication {

    public static void main(String[] args) {
        SpringApplication.run(SalonApplication.class, args);
    }

}
