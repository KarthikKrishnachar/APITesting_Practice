/**
 * 
 */
package com.nasaapi.testproject;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

/**
 * 
 */
public class Horizons_lookup_API {

	String api_URL = "https://ssd.jpl.nasa.gov/api/horizons_lookup.api";

	@Test
	@Parameters({ "AsteroidsNeoWs_" })
	public void getHorizons_lookup_message(String api_URL) {
		// TODO Auto-generated method stub

		int status_code = RestAssured.given().when().get(api_URL).statusCode();
		System.out.println(status_code);

	}

}
