package com.jumbo.stores.controller;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import io.restassured.RestAssured;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class StoreLocatorControllerTest {

	int port = 80;

	@Before
	public void setBaseUri() {
		RestAssured.port = port;
		RestAssured.baseURI = "http://JumboStoreLocator-env.eba-pgcmrnzf.eu-central-1.elasticbeanstalk.com";
	}

	@Test
	public void test_ResponseHeaderData_ShouldBeCorrect() {

		given().when().get("/store-locator-service/api/v1/stores/all").then().assertThat().statusCode(200);
	}

	@Test
	public void givenUrl_whenSuccessOnGetsResponseAndJsonHasRequiredKV_thenCorrect() {
		given().when().get("/store-locator-service/api/v1/stores/?longitude=6.245829&latitude=51.874272").then()
				.statusCode(200).assertThat().body("size()", is(5));
	}
}
