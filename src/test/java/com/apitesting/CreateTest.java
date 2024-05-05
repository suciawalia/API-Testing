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

    @Test
    @DisplayName("Request CREATE user dengan gender invalid")
    public void createUserWithInvalidGender() {

        given()
            .header("app-id", "662e68fabb70a7086a25966e")
            .contentType("application/json")
            .body("{\"firstName\":\"Soohyun\",\"lastName\":\"Kim\",\"gender\":\"Laki-Laki\",\"email\":\"soohyun@gmail.com\"}")
            .post("/user/create").
        then()
            .statusCode(400)
            .body("error", equalTo("BODY_NOT_VALID"));
 
    }

    @Test
    @DisplayName("Request CREATE user dengan data required field dan valid format email")
    public void createUserWithRequiredFieldsAndValidEmailFormat() {

        given()
            .header("app-id", "662e68fabb70a7086a25966e")
            .contentType("application/json")
            .body("{\"firstName\":\"Ai Alexander Ashya Amber Kimberly Christy Jocelyns\",\"lastName\":\"Jocie\",\"email\":\"aijocie14@gmail.com\"}")
            .post("/user/create").
        then()
            .statusCode(200)
            .body("firstName", equalTo("Ai Alexander Ashya Amber Kimberly Christy Jocelyns"))
            .body("lastName", equalTo("Jocie"))
            .body("email", equalTo("aijocie14@gmail.com"));
    }
    
}
