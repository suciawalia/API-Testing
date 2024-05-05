package com.apitesting;

import static io.restassured.RestAssured.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.http.ContentType;

public class UpdateTest {
    
    @Before
    public void setupBaseURL(){
        baseURI = "https://dummyapi.io/data/v1";
    }
 
    @Test
    @DisplayName("TC3-06 Melakukan update user pada field title diisi \"mr\"")
    public void putValidUserIdValidAppId() {
        
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
}
