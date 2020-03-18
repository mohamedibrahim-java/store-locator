package com.jumbo.stores.controller;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.assertj.core.util.Arrays;
import org.hamcrest.Matchers;
import org.hamcrest.core.IsEqual;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;

import com.jumbo.stores.dto.StoreDTO;

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
	public void givenUrl_whenSuccessOnGetsResponse_ShouldBeOk() {

		given().when().get("/store-locator-service/api/v1/stores/all").then().assertThat().statusCode(200);
	}

	@Test
	public void givenUrl_whenSuccessOnGetsResponseAndResultSize_thenCorrect() {
		given().queryParam("longitude", "6.245829").queryParam("latitude", "51.874272").when()
				.get("/store-locator-service/api/v1/stores/").then().statusCode(200).assertThat()
				.body("size()", IsEqual.equalTo(5));
	}

	@Test
	public void givenUrl_whenSuccessOnGetsResponseAndResultShouldHaveData_thenCorrect() {

		StoreDTO[] stores = given().queryParam("longitude", "6.245829").queryParam("latitude", "51.874272").when()
				.get("/store-locator-service/api/v1/stores/").then().assertThat().statusCode(HttpStatus.OK.value())
				.extract().as(StoreDTO[].class);
		assertThat(Arrays.asList(stores), hasItem(allOf(Matchers.<StoreDTO>hasProperty("longitude", is(6.296354)),
				Matchers.<StoreDTO>hasProperty("latitude", is(51.969476)))));
	}
}
