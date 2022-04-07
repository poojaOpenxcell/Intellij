package training;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import org.testng.annotations.BeforeTest;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.given;

public class CodatApi {


    @Test
    public void getCompanies(){
        String browseURL = "https://api.codat.io/companies";

        given()
                .param("page", "1")
                .param("pageSize", "100")
        .when()
                .get(browseURL)
        .then()
                .statusCode(401)
                .log()
                .body();



    }
}
