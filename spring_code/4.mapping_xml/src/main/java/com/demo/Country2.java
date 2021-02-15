package com.demo;
import java.util.*;
import java.util.function.BiConsumer;

public class Country2 {
	private String countryName;
	private Map<String, String> states;
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public Map<String, String> getStates() {
		return states;
	}
	public void setStates(Map<String, String> states) {
		this.states = states;
	}
	
	public void printCountryDetails() {
		System.out.println(countryName);
		System.out.println("----------------------------");
		states.forEach((state, cap)-> System.out.println(state+" : "+ cap));
	}
	
}
