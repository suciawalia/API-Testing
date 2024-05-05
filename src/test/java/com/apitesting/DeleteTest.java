package com.apitesting;

import static io.restassured.RestAssured.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import static org.hamcrest.Matchers.equalTo;

public class DeleteTest {
    
    @Before
    public void setupBaseURL(){
        baseURI = "https://dummyapi.io/data/v1";
    }
 
    @Test
    @DisplayName ("TC2-01 Request DELETE data id user yang terdaftar pada sistem tanpa menambahkan app-id pada headers")
    public void deleteValidUserIdNoAppId() {

        given()
            .delete("/user/60d0fe4f5311236168a10a03").
        then()
            .statusCode(403)
            .body("error", equalTo("APP_ID_MISSING"));
 
    }

    @Test
    @DisplayName ("TC2-02 Request DELETE data id user yang tidak terdaftar pada sistem tanpa menambahkan app-id pada headers")
    public void deleteInvalidUserIdNoAppId() {

        given()
            .delete("/user/60d0fe4f5311236168a109c1").
        then()
            .statusCode(403)
            .body("error", equalTo("APP_ID_MISSING"));
 
    }

    @Test
    @DisplayName ("TC2-04 Request DELETE data id user yang tidak terdaftar pada sistem dengan menambahkan app-id yang salah pada headers")
    public void deleteInvalidUserIdInvalidAppId() {

        String appId = "662ca6cad9ec7557d41a378";

        given()
            .header("app-id", appId)
            .when()
            .delete("/user/60d0fe4f5311236168a109c1").
        then()
            .statusCode(403)
            .body("error", equalTo("APP_ID_NOT_EXIST"));
 
    }

    @Test
    @DisplayName ("TC2-05 Request DELETE data id user yang tidak terdaftar pada sistem dengan menambahkan app-id yang valid pada headers")
    public void deleteInvalidUserIdValidAppId() {

        String appId = "662ca6cad9ec7557d41a378a";

        given()
            .header("app-id", appId)
            .when()
            .delete("/user/60d0fe4f5311236168a109c1").
        then()
            .statusCode(404)
            .body("error", equalTo("RESOURCE_NOT_FOUND"));
 
    }

    @Test
    @DisplayName ("TC2-07 Request DELETE data id user dengan format yang tidak valid dengan menambahkan app-id yang valid pada headers")
    public void deleteInvalidUserIdFormatValidAppId() {

        String appId = "662ca6cad9ec7557d41a378a";

        given()
            .header("app-id", appId)
            .when()
            .delete("/user/60d0fe4f5311236168a109c").
        then()
            .statusCode(400)
            .body("error", equalTo("PARAMS_NOT_VALID"));
 
    }
    
}
