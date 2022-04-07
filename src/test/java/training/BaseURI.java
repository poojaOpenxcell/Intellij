package training;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class BaseURI {

    @BeforeClass
    public void setUp(){
        RestAssured.baseURI="http://localhost:80";
        RestAssured.basePath="/api_testing/product";
    }

    @Test
    public void getProduct(){
     Response res = (Response) given()
                 .param("id", "23")
         .when()
                 .get("/read_one.php");

        System.out.println("Your Response is: " + res.body().prettyPrint());
//         .then()
//                 .log()
//                 .body()
//                .statusCode(200);

    }

    @Test
    public void verifyJsonResponse(){
        given()
        .when()
                .get("/read.php")
        .then()
                .statusCode(200)
                .and()
                .body("records[1].name", equalTo("Sweatband"))
                .contentType(ContentType.JSON);
    }


}
