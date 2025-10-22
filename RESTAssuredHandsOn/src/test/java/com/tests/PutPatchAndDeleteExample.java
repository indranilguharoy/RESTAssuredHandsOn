package com.tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutPatchAndDeleteExample {
	
	@Test
	public void putRequestResponseExample() {
		
		System.out.println("Put Starts");
		
		JSONObject request=new JSONObject();
		request.put("name","Indranil");
		request.put("job","Student");
		
		System.out.println(request.toString());
		
		baseURI="https://reqres.in/";
		given()
				.header("x-api-key","reqres-free-v1")
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(request.toJSONString())
		.when()
				.put("/api/users/2")
		.then()
				.statusCode(200)
				.log().all();
		
		System.out.println("Put Ends");
	}

	@Test
	public void patchRequestResponseExample() {
		System.out.println("Patch Starts");
		
		JSONObject request=new JSONObject();
		//request.put("name","Indranil");
		request.put("job","Leader");
		
		System.out.println(request.toString());
		
		baseURI="https://reqres.in/";
		given()
				.header("x-api-key","reqres-free-v1")
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(request.toJSONString())
		.when()
				.put("/api/users/2")
		.then()
				.statusCode(200)
				.log().all();
		
		System.out.println("Patch Ends");
		
	}
	
	@Test
	public void deleteRequestResponseExample() {
		System.out.println("Delete Starts");
		
		baseURI="https://reqres.in/";
		given()
				.header("x-api-key","reqres-free-v1")
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
		.when()
				.delete("/api/users/2")
		.then()
				.statusCode(204)
				.log().all();
		
		System.out.println("Delete Ends");
		
	}
}
