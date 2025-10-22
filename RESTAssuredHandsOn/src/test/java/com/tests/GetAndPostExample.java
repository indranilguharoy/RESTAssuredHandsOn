package com.tests;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GetAndPostExample {
	
	@Test
	public void getRequestResponseExample() {
		
		baseURI="https://reqres.in/";
		given()
				.get("/api/unknown")
		.then()
				.statusCode(200)
				.body("data[5].name", equalTo("blue turquoise"))
				.body("data.name", hasItems("cerulean","true red"))
				.log().all();
	}
	
	@Test
	public void postRequestResponseExample() {
		
		JSONObject request=new JSONObject();
		request.put("name","Indranil");
		request.put("job","Learner");
		
		System.out.println(request.toString());
		
		baseURI="https://reqres.in/";
		given()
				.header("x-api-key","reqres-free-v1")
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(request.toJSONString())
		.when()
				.post("/api/users")
		.then()
				.statusCode(201)
				.log().all();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
