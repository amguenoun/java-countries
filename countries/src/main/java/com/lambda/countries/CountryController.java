package com.lambda.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/data")
public class CountryController {
	//localhost:2019/data/names/all - return the names of all the countries alphabetically
	@GetMapping(value = "/names/all", produces = {"application/json"})
	public ResponseEntity<?> getAllCountries(){
		CountriesApplication.list.countryList.sort((e1,e2) -> e1.getName().compareToIgnoreCase(e2.getName()));
		return new ResponseEntity<>(CountriesApplication.list.countryList, HttpStatus.OK);
	}

	//localhost:2019/data/names/start/{letter} - return the countries alphabetically that begin with the given letter
	@GetMapping(value = "names/start/{letter}", produces = {"application/json"})
	public ResponseEntity<?> getAllCountriesByLetter(@PathVariable char letter){
		ArrayList<Country> tempList =  CountriesApplication.list.findCountries(e -> e.getName().toLowerCase().charAt(0) == Character.toLowerCase(letter));
		tempList.sort((e1,e2) -> e1.getName().compareToIgnoreCase(e2.getName()));
		return new ResponseEntity<>(tempList, HttpStatus.OK);
	}

	//localhost:2019/data/names/size/{number} - return the countries alphabetically that have a name equal to or longer than the given length
	//localhost:2019/data/population/size/{people} - return the countries that have a population equal to or greater than the given population
	//localhost:2019/data/population/min - return the country with the smallest population
	//localhost:2019/data/population/max - return the country with the largest population
	//localhost:2019/data/age/age/{age} - return the countries that have a median age equal to or greater than the given age
	//localhost:2019/data/age/min - return the country with the smallest median age
	//localhost:2019/data/age/max - return the country the the greatest median age

	//Stretch
	//localhost:2019/data/population/median - return the country with the median population
	//localhost:2019/data/age/median - return the names of all the countries alphabetically
}
