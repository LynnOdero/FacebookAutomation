package com.lynn.selenium;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import java.net.URI;
import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class BooksAPI {



  @BeforeAll
  static void setUp() {
    RestAssured.baseURI = "https://demoqa.com/Account/v1";
  }

  // Url = https://demoqa.com/Account/v1/User
  // {
  //    "userName": "droogola",
  //    "password":"123@Srudhhds"
  //}

  @Test
  void create_user_returns_201_created_and_username() throws Exception {
    JSONObject requestParams = new JSONObject();
    String username = RandomStringUtils.randomAlphabetic(10);

    requestParams.put("userName", username);
    requestParams.put("password", "123@Leona5");

    given().body(requestParams.toString())
        .header(new Header("Content-Type", "application/json"))
        .when()
        .post(URI.create("/User"))
        .then()
        .statusCode(201)
        .body("username", equalTo(username));
  }

  @Test
  void creating_an_existing_user_returns_status_406_and_useralreadyexists() throws Exception {
    JSONObject requestParam = new JSONObject();
//construct jsonrequest
    requestParam.put("userName", "droogola4");
    requestParam.put("password", "123@Srudhhds");

    given().body(requestParam.toString())
        .header(new Header("Content-Type", "application/json"))
        .when().post(URI.create("/User"))
        .then().statusCode(406)
        .body("message", equalTo("User exists!"));
  }
}
