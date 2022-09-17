package com.assement.testvariant.utility;
import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.path.json.JsonPath;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
public class baseclass {

	static ValidatableResponse response;
//Find  file form local
	
	
	
	public static String generateStringFromResource(String path) throws IOException {

	    return new String(Files.readAllBytes(Paths.get(path)));

	}
	//load json file convert into string

	public static String loadjson(String path) throws IOException {
		
		   String jsonBody = generateStringFromResource(path);
		   // String content = null;	
				return jsonBody;
	}
	//get player country

	public static String palyer_country(String response, int id) {
		   // String content = null;	

		   JsonPath jsonpath= new JsonPath(response);
		String country = jsonpath.getString("player["+id+"].country");
		return country;	
	}
	//get player role

	public static String palyer_role(String response, int id) {
		  JsonPath jsonpath= new JsonPath(response);
		  String role = jsonpath.getString("player["+id+"].role");
		return role;	
	}
	
}
