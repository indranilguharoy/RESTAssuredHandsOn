package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TestExamples {
	
	@Test
	public void test1() {
		Response response=get("https://reqres.in/api/users?page=2");
		System.out.println(response.getStatusCode());
		System.out.println(response.asPrettyString());
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test
	public void test2() {
		baseURI="https://reqres.in/api";
		given()
			.get("/users?page=2")
		.then()
			.statusCode(200)
			.body("data[1].id", equalTo(8));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
