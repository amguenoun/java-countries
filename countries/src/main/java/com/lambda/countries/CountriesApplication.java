package com.lambda.countries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CountriesApplication {
	static CountryList list;

	public static void main(String[] args) {
		list = new CountryList();
		SpringApplication.run(CountriesApplication.class, args);
	}

}
