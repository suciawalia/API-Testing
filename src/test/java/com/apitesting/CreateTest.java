package com.apitesting;

import static io.restassured.RestAssured.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import static org.hamcrest.Matchers.equalTo;

public class CreateTest {
    
    @Before
    public void setupBaseURL(){
        baseURI = "https://dummyapi.io/data/v1";
    }

    @Test
    @DisplayName ("Request CREATE user tanpa app-id pada headers")
    public void createUserWithoutAppId() {

        given()
            .contentType("application/json")
            .body("{\"firstName\":\"Heesoo\",\"lastName\":\"Kim\",\"email\":\"heesoo@gmail.com\"}")
            .post("/user/create").
        then()
            .statusCode(403)
            .body("error", equalTo("APP_ID_MISSING"));
 
    }
    
}
