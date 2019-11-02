package com.example.putDataToDatabase;

import jdk.internal.jline.internal.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.sql.*;
import java.util.logging.Logger;

@ComponentScan
@SpringBootApplication
public class PutDataToDatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(PutDataToDatabaseApplication.class, args);
	}
}
