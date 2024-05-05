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
    @DisplayName ("TC1-01 Melakukan request create user ketika tidak ada app-id pada header")
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
    @DisplayName("TC1-02 Melakukan request create user ketika memasukkan app-id yang invalid pada header")
    public void createUserWithInvalidAppId() {

        given()
            .header("app-id", "12345678910")
            .contentType("application/json")
            .body("{\"firstName\":\"Heesoo\",\"lastName\":\"Kim\",\"email\":\"heesoo@gmail.com\"}")
            .post("/user/create").
        then()
            .statusCode(403)
            .body("error", equalTo("APP_ID_NOT_EXIST"));
    }

    @Test
    @DisplayName("TC1-26 Melakukan request create user dimana field gender invalid (selain \"male\", \"female\", dan \"other\")")
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
    @DisplayName("TC1-05 Melakukan request create user dengan mengisi hanya required field dimana field firstName diisi 50 karakter (batas atas), field lastName diisi 5 karakter, dan field email diisi dengan format yang valid")
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

    @Test
    @DisplayName("TC1-15 Melakukan request create user dengan mengisi hanya required field dimana format email invalid, yaitu tidak memakai '@'")
    public void createUserWithInvalidEmailFormat() {

        given()
            .header("app-id", "662e68fabb70a7086a25966e")
            .contentType("application/json")
            .body("{\"firstName\":\"Wonyoung\",\"lastName\":\"Jang\",\"email\":\"wonyounggmail.com\"}")
            .post("/user/create").
        then()
            .statusCode(400)
            .body("error", equalTo("BODY_NOT_VALID"));
    }
    
    @Test
    @DisplayName("TC1-28 Melakukan request create user dimana field dateOfBirth diisi tanggal di masa depan")
    public void createUserWithFutureDateOfBirth() {

        given()
            .header("app-id", "662e68fabb70a7086a25966e")
            .contentType("application/json")
            .body("{\"firstName\":\"Soohyun\",\"lastName\":\"Kim\",\"dateOfBirth\":\"1/1/2025\",\"email\":\"kimsoohyun@gmail.com\"}")
            .post("/user/create").
        then()
            .statusCode(400)
            .body("error", equalTo("BODY_NOT_VALID"));
    }

}
