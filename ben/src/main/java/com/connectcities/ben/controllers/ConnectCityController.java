package com.connectcities.ben.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.connectcities.ben.services.ConnectionService;


@RestController
public class ConnectCityController {
	
	@Autowired
	private ConnectionService service;

	@RequestMapping(value = "/connected", method = RequestMethod.GET)
	public ResponseEntity<Object> connected(
			@RequestParam(value="origin", required=true) String origin,
			@RequestParam(value="destination", required=true) String destination) {
//		System.out.println("Works");
		return new ResponseEntity<>(service.isConnected(origin, destination) + ": " + origin + "-->" + destination, HttpStatus.OK);
	}
}
