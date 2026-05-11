package com.example.MarcketPlaceUniversitario;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MarcketPlaceUniversitarioApplication {

	public static void main(String[] args) {
		loadEnv();
		SpringApplication.run(MarcketPlaceUniversitarioApplication.class, args);
		System.out.println("MarcketPlaceUniversitarioApplication started");
	}
	private static void loadEnv(){
		Dotenv dotenv = Dotenv.load();
		System.setProperty("DB_URL",dotenv.get("DB_URL"));
		System.setProperty("DB_USERNAME",dotenv.get("DB_USERNAME"));
		System.setProperty("DB_PASSWORD",dotenv.get("DB_PASSWORD"));
		System.setProperty("CLOUDINARY_CLOUD_NAME", dotenv.get("CLOUDINARY_CLOUD_NAME"));
		System.setProperty("CLOUDINARY_API_KEY",    dotenv.get("CLOUDINARY_API_KEY"));
		System.setProperty("CLOUDINARY_API_SECRET", dotenv.get("CLOUDINARY_API_SECRET"));
		System.setProperty("MAIL_USERNAME", dotenv.get("MAIL_USERNAME"));
		System.setProperty("MAIL_PASSWORD", dotenv.get("MAIL_PASSWORD"));
	}


}
