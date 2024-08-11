/**
 * 
 */
package com.restassured.utils;

import java.io.IOException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restassured.pojo.AutheticationClass;

/**
 * 
 */
public class Authorization_class {

	private static Authorization_class instance;

	public Authorization_class getAuth_class_object() {
		return instance == null ? new Authorization_class() : instance;
	}

	@Test
	public void createAuthKey() {
		String createToken_URL = Read_Config_File.getRead_Config_File().getPropety_withKey("getAuth_CreateTokem_URL");
		String username = Read_Config_File.getRead_Config_File().getPropety_withKey("API_Auth_username");
		String password = Read_Config_File.getRead_Config_File().getPropety_withKey("API_Auth_password");

//		HttpURLConnection connection = (HttpURLConnection) createToken_URL.openConnection();
//		connection.setRequestMethod("POST");
//		connection.setRequestProperty("Content-Type", "application/json");

//		JSONObject requestParameter = new JSONObject();

		AutheticationClass autheticationClass = new AutheticationClass(username, password);

//		ObjectMapper objectMapper = new ObjectMapper();

		// Convert Person object to JSON string
		try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
			String jsonString = new ObjectMapper().writeValueAsString(autheticationClass);
			System.out.println(jsonString);

			HttpPost postrequest = new HttpPost(createToken_URL);
			
			
			postrequest.setHeader("Content-Type","application/json");
			postrequest.setEntity(new StringEntity(jsonString));
			

			try(CloseableHttpResponse response =  httpClient.execute(postrequest)){
				System.out.println(response.getStatusLine().getStatusCode());
				System.out.println(EntityUtils.toString(response.getEntity()));
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
