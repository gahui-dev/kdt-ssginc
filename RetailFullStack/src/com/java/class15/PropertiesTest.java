package com.java.class15;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

public class PropertiesTest {

	private static final String DEFAULT_PROPERTIES_PATH 
	= Paths.get(File.separator + "Users", "GAHUI",
			"Documents", "database", "application.properties").toString();

	public static void main(String[] args) {
		System.out.println(DEFAULT_PROPERTIES_PATH);

		try(BufferedReader br = new BufferedReader(new FileReader(DEFAULT_PROPERTIES_PATH)); ){
			Properties properties = new Properties();

			// loading
			properties.load(br);
			String id = properties.getProperty("id");
			System.out.println("id - " + id);
			String pwd = properties.getProperty(id + ".pwd");
			System.out.println("pwd - " + pwd);
			
			// Map<K, V>
			// key = value
			// String dummy = properties.getProperty("#key");

		} catch(FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}