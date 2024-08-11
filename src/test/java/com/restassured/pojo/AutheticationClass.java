/**
 * 
 */
package com.restassured.pojo;

/**
 * 
 */
public class AutheticationClass {

	String username;

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	String password;

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public AutheticationClass(String username, String password) {
		this.username = username;
		this.password = password;
	}

//	public String toString() {
//	return String.format("{\"username\":\"%s\", \"password\":\"%s\"}", username, password);
//	}

}
