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
		CountriesApplication.list.countryList.sort((c1,c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
		return new ResponseEntity<>(CountriesApplication.list.countryList, HttpStatus.OK);
	}

	//localhost:2019/data/names/start/{letter} - return the countries alphabetically that begin with the given letter
	@GetMapping(value = "names/start/{letter}", produces = {"application/json"})
	public ResponseEntity<?> getAllCountriesByLetter(@PathVariable String letter){
		ArrayList<Country> tempList =  CountriesApplication.list.findCountries(c -> letter.equalsIgnoreCase(c.getName().substring(0,1)));
		tempList.sort((c1,c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
		return new ResponseEntity<>(tempList, HttpStatus.OK);
	}

	//localhost:2019/data/names/size/{number} - return the countries alphabetically that have a name equal to or longer than the given length
	@GetMapping(value = "names/size/{number}", produces = {"application/json"})
	public ResponseEntity<?> getCountryByNameSize(@PathVariable int number){
		ArrayList<Country> tempList = CountriesApplication.list.findCountries(c -> c.getName().length() >= number );
		tempList.sort((c1,c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
		return new ResponseEntity<>(tempList, HttpStatus.OK);
	}

	//localhost:2019/data/population/size/{people} - return the countries that have a population equal to or greater than the given population
	@GetMapping(value = "population/size/{people}", produces = {"application/json"})
	public ResponseEntity<?> getCountriesByPopulationSize(@PathVariable int people){
		return new ResponseEntity<>(CountriesApplication.list.findCountries(c -> c.getPopulation() >= people ), HttpStatus.OK);
	}

	//localhost:2019/data/population/min - return the country with the smallest population
	@GetMapping(value = "population/min", produces = {"application/json"})
	public ResponseEntity<?> getCountryBySmallestPopulation(){
		CountriesApplication.list.countryList.sort((c1,c2) -> c1.getPopulation() - c2.getPopulation() );
		return new ResponseEntity<>(CountriesApplication.list.countryList.get(0), HttpStatus.OK);
	}

	//localhost:2019/data/population/max - return the country with the largest population
	@GetMapping(value = "population/max", produces = {"application/json"})
	public ResponseEntity<?> getCountryByLargestPopulation(){
		CountriesApplication.list.countryList.sort((c1,c2) -> c2.getPopulation() - c1.getPopulation() );
		return new ResponseEntity<>(CountriesApplication.list.countryList.get(0), HttpStatus.OK);
	}

	//localhost:2019/data/age/age/{age} - return the countries that have a median age equal to or greater than the given age
	@GetMapping(value = "age/{age}", produces = {"application/json"})
	public ResponseEntity<?> getCountriesByMedianAge(@PathVariable int age){
		return new ResponseEntity<>(CountriesApplication.list.findCountries(c -> c.getMedianAge() >= age ), HttpStatus.OK);
	}

	//localhost:2019/data/age/min - return the country with the smallest median age
	@GetMapping(value = "age/min", produces = {"application/json"})
	public ResponseEntity<?> getCountryBySmallestMedianAge(){
		CountriesApplication.list.countryList.sort((c1,c2) -> c1.getMedianAge() - c2.getMedianAge() );
		return new ResponseEntity<>(CountriesApplication.list.countryList.get(0), HttpStatus.OK);
	}

	//localhost:2019/data/age/max - return the country the the greatest median age
	@GetMapping(value = "age/max", produces = {"application/json"})
	public ResponseEntity<?> getCountryByLargestMedianAge(){
		CountriesApplication.list.countryList.sort((c1,c2) -> c2.getMedianAge() - c1.getMedianAge() );
		return new ResponseEntity<>(CountriesApplication.list.countryList.get(0), HttpStatus.OK);
	}

	//Stretch
	//localhost:2019/data/population/median - return the country with the median population
	//localhost:2019/data/age/median - return the names of all the countries alphabetically
}
