package com.lambda.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
public class CountryController {
	//localhost:2019/data/names/all - return the names of all the countries alphabetically
	@GetMapping(value = "/names/all", produces = {"application/json"})
	public ResponseEntity<?> getAllCountries(){
		CountriesApplication.list.countryList.sort((e1,e2) -> e1.getName().compareToIgnoreCase(e2.getName()));
		return new ResponseEntity<>(CountriesApplication.list.countryList, HttpStatus.OK);
	}
}
