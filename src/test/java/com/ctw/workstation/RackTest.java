package com.ctw.workstation;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@QuarkusTest
class RackTest {
    @Test
    void testGetRacks() {
        given()
                .when()
                .get("/workstation/racks")
                .then()
                .statusCode(200)
                .body(is("[]"));
    }

}