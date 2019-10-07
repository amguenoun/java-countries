package com.lambda.countries;

import java.util.concurrent.atomic.AtomicLong;

public class Country {
	private static final AtomicLong counter = new AtomicLong();
	private long id;
	private String name;
	private int population;
	private int landMassSize;
	private int medianAge;

	public Country(String name, int population, int landMassSize, int medianAge) {
		this.id = counter.getAndIncrement();
		this.name = name;
		this.population = population;
		this.landMassSize = landMassSize;
		this.medianAge = medianAge;
	}

	public Country(Country toClone){
		this.id = toClone.getId();
		this.name = toClone.getName();
		this.population = toClone.getPopulation();
		this.landMassSize = toClone.getLandMassSize();
		this.medianAge = toClone.getMedianAge();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public int getLandMassSize() {
		return landMassSize;
	}

	public void setLandMassSize(int landMassSize) {
		this.landMassSize = landMassSize;
	}

	public int getMedianAge() {
		return medianAge;
	}

	public void setMedianAge(int medianAge) {
		this.medianAge = medianAge;
	}

	@Override
	public String toString() {
		return "Country{" + "id=" + id + ", name='" + name + '\'' + ", population=" + population + ", landMassSize=" + landMassSize + ", medianAge=" + medianAge + '}';
	}
}
