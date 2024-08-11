/**
 *
 */
package com.nasaapi.testproject;

//if you DONT use the static key word you have to add RestAssured Class name "Fully qualified" while calling the methods in RestAssured Lib."

//import io.restassured.RestAssured;

//if you use the static key word you DONT have to add RestAssured Class name "Fully qualified" while calling the methods in RestAssured Lib."
import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 *
 */
public class AsteroidsNeoWs_Test {

	Properties properties = new Properties();
	File file = new File("./src/test/resources/config.properties");

	public void readProperties() throws FileNotFoundException {
		InputStream stream = getClass().getClassLoader().getResourceAsStream("");

		try {
			properties.load(stream);
			System.out.println(properties.getProperty("AsteroidsNeoWs_api_URL"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	@Parameters({ "AsteroidsNeoWs_api_URL" })
	public void getAPI_Test(String api_URL) {
		try {
			readProperties();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		int status_code = given().when().get(api_URL).statusCode();
		System.out.println(status_code);
		given().when().get(api_URL).then().assertThat().statusCode(201);

	}

}
