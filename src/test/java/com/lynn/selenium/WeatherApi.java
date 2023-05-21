package com.lynn.selenium;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

import io.restassured.RestAssured;
import java.net.URI;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class WeatherApi {

  @BeforeAll
 static void setUp(){
    RestAssured.baseURI= "http://restapi.demoqa.com/utilities";
  }


@Test
  void status_returned_is_200_when_getweatherbycity_request_is_sent(){
  given().contentType("application/json")
      .queryParam("city", "Hyderabad")
      .when().get(URI.create("/weather/city"))
        .then()
        .statusCode(200)
        .body("city",equalTo("Hyderabad"));
  }



}
