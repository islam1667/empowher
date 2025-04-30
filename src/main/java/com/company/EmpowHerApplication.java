package com.company;

//import com.company.api.googleCloudStorage.GenerateV4PutObjectSignedUrl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class EmpowHerApplication {

	public static void main(String[] args) throws Exception{

		SpringApplication.run(EmpowHerApplication.class, args);
//		GenerateV4PutObjectSignedUrl.generateV4PutObjectSignedUrl("psyched-circuit-451220-v3",
//				"empowher-bucket",
//				"helloWorld.txt");

	}

}
