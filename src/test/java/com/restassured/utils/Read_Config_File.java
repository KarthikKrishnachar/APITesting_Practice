/**
 * 
 */
package com.restassured.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 
 */
public class Read_Config_File {

	private Properties properties;
	private static Read_Config_File instace;
//	private String configfilepath = "./src/test/resources/config.properties";
//	private FileInputStream fileinputstream;
	private InputStream inputstream;

	public static Read_Config_File getRead_Config_File() {
		return instace == null ? new Read_Config_File() : instace;
	}

	public Read_Config_File() {
		try {
			inputstream = getClass().getClassLoader().getResourceAsStream("config.properties");
			properties = new Properties();
			properties.load(inputstream);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * this methid will return value of the key,
	 * 
	 * @param keyName
	 * @return value
	 * @throws NoSuchKeyExist
	 */
	public String getPropety_withKey(String keyName) {

		if (properties.containsKey(keyName)) {
			return properties.getProperty(keyName);
		} else
			return "No Such Key Exist";
	}

}
