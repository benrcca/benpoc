package com.connectcities.ben.services;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.connectcities.ben.config.CustomConfig;

public class ConnectionServiceTest {

	@Test
	public void testIsConnected() {
		ConnectionService service = new ConnectionService();
		
		String origin = "Philadelphia";
		String destination = "Boston";
		printResult(origin, destination, service);
		
		origin = "New York";
		destination = "Newark";
		printResult(origin, destination, service);
		
		origin = "Newark";
		destination = "Albany";
		printResult(origin, destination, service);
		
		origin = "Newark";
		destination = "Trenton";
		printResult(origin, destination, service);
		
		origin = "Albany";
		destination = "Trenton";
		printResult(origin, destination, service);
	}
	
	public void printResult(String origin, String destination, ConnectionService service) {
		boolean connected = service.isConnected(origin, destination);
		if(connected) {
			System.out.println(origin + " ->- " + destination);
		}
		else {
			System.out.println(origin + " -X- " + destination);
		}
	}
	
	@Test
	public void testHasConnection() {
		CustomConfig config = new CustomConfig();
		List<List<String>> lstConnected = config.getCityConnection();
		
		String origin = "Philadelphia";
		String destination = "Boston";
		List<String> viaCities = new ArrayList<String>();
		viaCities.add(origin);
		
		ConnectionService service = new ConnectionService();
		boolean connected = service.hasConnection(destination, viaCities, lstConnected);
		System.out.println(connected + ": " + origin + " --> " + destination);
	}

}
