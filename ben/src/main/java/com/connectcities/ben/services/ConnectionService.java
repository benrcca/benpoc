package com.connectcities.ben.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.connectcities.ben.config.CustomConfig;

@Service
public class ConnectionService {

	@Autowired
	private CustomConfig config = new CustomConfig();
	
	public boolean isConnected(String origin, String destination) {
		System.out.println(origin);
		
		List<List<String>> lstConnected = config.getCityConnection();
		List<List<String>> newLstConnected = new ArrayList<List<String>>();
		
		List<String> viaCities = new ArrayList<String>();
		for(List<String> connected : lstConnected) {
			if(connected.get(0).equalsIgnoreCase(origin)) {
				viaCities.add(connected.get(1));
			}
			else if(connected.get(1).equalsIgnoreCase(origin)) {
				viaCities.add(connected.get(0));
			}
			else {
				newLstConnected.add(connected);
			}
		}
		if(viaCities.isEmpty()) {
			return false;
		}
		else{
			return this.hasConnection(destination, viaCities, newLstConnected);
		}
	}
	
	public boolean hasConnection(String destination, List<String> viaCities, List<List<String>> lstConnected) {
		printViaCities(viaCities);
		if(viaCities.contains(destination)) {
			return true;
		}
		else {
			List<String> newViaCities = new ArrayList<String>();
			List<List<String>> newLstConnected = new ArrayList<List<String>>();
			
			for(List<String> connected : lstConnected) {
				if(viaCities.contains(connected.get(0))) {
					newViaCities.add(connected.get(1));
				}
				else if(viaCities.contains(connected.get(1))) {
					newViaCities.add(connected.get(0));
				}
				else {
					newLstConnected.add(connected);
				}
			}
			if(newViaCities.isEmpty()) {
				return false;
			}
			else{
				return this.hasConnection(destination, newViaCities, newLstConnected);
			}
		}
	}
	
	private void printViaCities(List<String> viaCities) {
		StringBuilder cities = new StringBuilder();
		for(String city : viaCities) {
			cities.append(city + ", ");
		}
		System.out.println(cities.toString());
	}
}
