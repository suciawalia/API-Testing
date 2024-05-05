package com.apitesting;

import static io.restassured.RestAssured.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import static org.hamcrest.Matchers.equalTo;

public class GetTest {
    
    @Before
    public void setupBaseURL(){
        baseURI = "https://dummyapi.io/data/v1";
    }
 
    @Test
    @DisplayName ("TC2-01 Request GET data id user yang terdaftar pada sistem tanpa menambahkan app-id pada headers")
    public void validUserIdNoAppId() {

        given()
            .get("/user/60d0fe4f5311236168a109fa").
        then()
            .statusCode(403)
            .body("error", equalTo("APP_ID_MISSING"));
 
    }

    @Test
    @DisplayName ("TC2-03 Request GET data id user yang terdaftar pada sistem dengan menambahkan app-id yang salah pada headers")
    public void validUserIdInvalidAppId() {

        String appId = "662ca6cad9ec7557d41a378";

        given()
            .header("app-id", appId)
            .when()
            .get("/user/60d0fe4f5311236168a109fa").
        then()
            .statusCode(403)
            .body("error", equalTo("APP_ID_NOT_EXIST"));
 
    }

    @Test
    @DisplayName ("TC2-05 Request GET data id user yang tidak terdaftar pada sistem dengan menambahkan app-id yang valid pada headers")
    public void invalidUserIdValidAppId() {

        String appId = "662ca6cad9ec7557d41a378a";

        given()
            .header("app-id", appId)
            .when()
            .get("/user/60d0fe4f5311236168a109c1").
        then()
            .statusCode(404)
            .body("error", equalTo("RESOURCE_NOT_FOUND"));
 
    }
    
    @Test
    @DisplayName ("TC2-06 Request GET data id user yang terdaftar pada sistem dengan menambahkan app-id yang valid pada headers")
    public void validUserIdValidAppId() {

        String appId = "662ca6cad9ec7557d41a378a";

        given()
            .header("app-id", appId)
            .when()
            .get("/user/60d0fe4f5311236168a109fa").
        then()
            .statusCode(200)
            .body("id", equalTo("60d0fe4f5311236168a109fa"))
            .body("title", equalTo("ms"))
            .body("firstName", equalTo("Ann"))
            .body("lastName", equalTo("Mason"))
            .body("picture", equalTo("https://randomuser.me/api/portraits/med/women/18.jpg"))
            .body("gender", equalTo("female"))
            .body("email", equalTo("ann.mason@example.com"))
            .body("dateOfBirth", equalTo("1959-09-26T07:05:56.725Z"))
            .body("phone", equalTo("(385)-245-2517"))
            .body("location.street", equalTo("2698, Paddock Way"))
            .body("location.city", equalTo("Orange"))
            .body("location.state", equalTo("Wyoming"))
            .body("location.country", equalTo("United States"))
            .body("location.timezone", equalTo("+3:00"))
            .body("registerDate", equalTo("2021-06-21T21:02:15.705Z"))
            .body("updatedDate", equalTo("2021-06-21T21:02:15.705Z"));

    }

    @Test
    @DisplayName ("TC2-07 Request GET data id user dengan format yang tidak valid dengan menambahkan app-id yang valid pada headers")
    public void invalidUserIdFormatValidAppId() {

        String appId = "662ca6cad9ec7557d41a378a";

        given()
            .header("app-id", appId)
            .when()
            .get("/user/60d0fe4f5311236168a109c").
        then()
            .statusCode(400)
            .body("error", equalTo("PARAMS_NOT_VALID"));
 
    }
    
}
