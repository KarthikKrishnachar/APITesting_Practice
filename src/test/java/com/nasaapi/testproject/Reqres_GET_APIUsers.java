/**
 * 
 */
package com.nasaapi.testproject;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * 
 */
public class Reqres_GET_APIUsers {
	
	@Test
	@Parameters({"Reqres_Get_User_list"})
	public void validateJsonBody(String Reqres_Get_User_list) {
		Response response = given().get(Reqres_Get_User_list);
		System.out.println(response.getStatusCode());
		String s = response.asPrettyString();
		ObjectMapper objectmapper = new ObjectMapper();
		
//		Testclass testcalss = objectmapper.readValue(s, Testclass.class);
		
		
	}

}
