package com.connectcities.ben.config;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class CustomConfigTest {

	@Test
	public void test() {
		CustomConfig config = new CustomConfig();
		List<List<String>> connected = config.getCityConnection();
		for(List<String> list : connected) {
			System.out.println(list.get(0) + " --> " + list.get(1));
		}
	}

}
