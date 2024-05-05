package com.apitesting;

import static io.restassured.RestAssured.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.http.ContentType;

public class UpdateTest {

    String userId = "663068bc22f582dd9b5e428c";
    String appId = "662e60f6bb70a70a3a2595fd";
    
    @Before
    public void setupBaseURL(){
        baseURI = "https://dummyapi.io/data/v1";
        userId = "663068bc22f582dd9b5e428c";
        appId = "662e60f6bb70a70a3a2595fd";
    }
 
    @Test
    @DisplayName("TC3-06 Melakukan update user pada field title diisi \"mr\"")
    public void updateTitleMrWithValidUserIdAndAppId() {
        
        String userId = "663068bc22f582dd9b5e428c";
        String appId = "662e60f6bb70a70a3a2595fd";
        
        given()
            .contentType(ContentType.JSON)
            .header("app-id", appId)
            .body("{\"title\": \"mr\"}")
            .when()
            .put("/user/" + userId)
        .then()
            .statusCode(200)
            .body("id", equalTo(userId))
            .body("title", equalTo("mr"));
    }

    @Test
    @DisplayName("TC3-07 Melakukan update user pada field title diisi \"ms\"")
    public void updateTitleMsWithValidUserIdAndAppId() {
        
        given()
            .contentType(ContentType.JSON)
            .header("app-id", appId)
            .body("{\"title\": \"ms\"}")
            .when()
            .put("/user/" + userId)
        .then()
            .statusCode(200)
            .body("id", equalTo(userId))
            .body("title", equalTo("ms"));
    }

    @Test
    @DisplayName("TC3-08 Melakukan update user pada field title diisi \"mrs\"")
    public void updateTitleMrsWithValidUserIdAndAppId() {
        
        given()
            .contentType(ContentType.JSON)
            .header("app-id", appId)
            .body("{\"title\": \"mrs\"}")
            .when()
            .put("/user/" + userId)
        .then()
            .statusCode(200)
            .body("id", equalTo(userId))
            .body("title", equalTo("mrs"));
    }

    @Test
    @DisplayName("TC3-09 Melakukan update user pada field title diisi \"miss\"")
    public void updateTitleMissWithValidUserIdAndAppId() {
        
        given()
            .contentType(ContentType.JSON)
            .header("app-id", appId)
            .body("{\"title\": \"miss\"}")
            .when()
            .put("/user/" + userId)
        .then()
            .statusCode(200)
            .body("id", equalTo(userId))
            .body("title", equalTo("miss"));
    }

    @Test
    @DisplayName("TC3-10 Melakukan update user pada field title diisi \"dr\"")
    public void updateTitleDrWithValidUserIdAndAppId() {
        
        given()
            .contentType(ContentType.JSON)
            .header("app-id", appId)
            .body("{\"title\": \"dr\"}")
            .when()
            .put("/user/" + userId)
        .then()
            .statusCode(200)
            .body("id", equalTo(userId))
            .body("title", equalTo("dr"));
    }
}