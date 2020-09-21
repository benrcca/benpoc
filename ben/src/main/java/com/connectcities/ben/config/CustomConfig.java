package com.connectcities.ben.config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;


@Configuration
public class CustomConfig {

	private List<List<String>> cityConnection;
	
	public List<List<String>> getCityConnection() {
		if(cityConnection == null) {
			loadCityConnectionFile();
		}
		return cityConnection;
	}

	public void setCityConnection(List<List<String>> cityConnection) {
		this.cityConnection = cityConnection;
	}
	
	public void loadCityConnectionFile() {
		ClassPathResource resource = new ClassPathResource("city.txt");
		
		try{
			InputStream is = resource.getInputStream();
	          BufferedReader br = new BufferedReader(new InputStreamReader(is));
	          cityConnection = new ArrayList<List<String>>();
	          
	          String line;
	          while ((line = br.readLine()) != null) {
//	        	  System.out.println(line);
	        	  String[] strAr = line.split(",");
	        	  List<String> connected = new ArrayList<String>();
	        	  for(Object o : strAr) {
	        		  connected.add(o.toString().trim());
	        	  }
	        	  cityConnection.add(connected);
	          }
	          br.close();
	    }
		 catch(IOException e){
	    	e.printStackTrace();
	    }
	}
}
