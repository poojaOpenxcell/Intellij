package restAssuredTraining;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class CodatApi {

    RequestSpecification reqSpec = RestAssured.given()
            .baseUri("https://api.codat.io")
            .basePath("/companies");


    @Test
    public void getCompanies(){


        given(reqSpec)
                .param("page", "1")
                .param("pageSize", "100")
        .when()
                .get()
        .then()
                .statusCode(401)
                .log()
                .body();



    }
}
