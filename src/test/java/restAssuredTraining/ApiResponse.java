package restAssuredTraining;

import dataFile.Product;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ApiResponse {

    //check the status code form get method
    @Test
    public void getProduct(){
        String browseUrl = "http://localhost:80/api_testing/product/read.php";
        given().when().get(browseUrl).then().assertThat().statusCode(200);

    }

    //accessing response from body
    @Test
    public void getResponse(){
        String browseUrl = "http://localhost:80/api_testing/product/read.php";
        given().when().get(browseUrl).then().log().body();

    }

    //verifying the response value by adding assert
    @Test
    public void assertResponse(){
        String browseUrl = "http://localhost:80/api_testing/product/read_one.php";
        given().
                queryParam("id",23).
        when().
                get(browseUrl).
        then().
                assertThat().
                statusCode(200).
                body("id", notNullValue()).
                body("name", equalToIgnoringCase("Sweatband")).
                body("price",equalTo("6.00"));

    }

    //verifying nested response from records
    @Test
    public void nestedResponse(){
        String browseUrl = "http://localhost:80/api_testing/product/read.php";
        given().
        when().
                get(browseUrl).
        then().
                log().
                    body().
                assertThat().
                    statusCode(200).
                    body("records.size()", greaterThan(0)).
                    body("records.id", everyItem(notNullValue())).
                    body("records.id[0]", equalTo("30"));

    }

    //verifying response header
    @Test
    public void responseHeader(){
        String browseUrl = "http://localhost:80/api_testing/product/read.php";
        given().when().get(browseUrl).then().log().headers().assertThat().statusCode(200).header("Content-Type", equalTo("application/json; charset=UTF-8"));

    }

    //deserialize response body
    @Test
    public void deserializeResponse(){
        String browseUrl = "http://localhost:80/api_testing/product/read_one.php";
        Product expectedResult = new Product(23, "Sweatband", "Sweatband for fitness freak", 6.00,3, "Active Wear - Unisex");
        var actualResult =
                            given().
                                    queryParam("id","23").
                            when().
                                    get(browseUrl).
                                        as(Product.class);

        assertThat(actualResult,samePropertyValuesAs(expectedResult));

    }


}
