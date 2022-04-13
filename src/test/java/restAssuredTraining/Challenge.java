package restAssuredTraining;

import dataFile.Product;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class Challenge {


    //Create a product "SweatBand" in Category_id 3 for $5
    @Test
    public void postProduct(){
        String browseUrl = "http://localhost:80/api_testing/product/create.php";
        Product payload = new Product("Sweatband", "Sweatband for fitness freak", 5, 3);
        var response=
                given().body(payload).when().post(browseUrl).then();
        response.log().body();
    }

    //update price to 6
    @Test
    public void putProduct(){
        String browseUrl = "http://localhost:80/api_testing/product/update.php";
        Product payload = new Product(23, "Sweatband", "Sweatband for fitness freak", 6, 3, "Active Wear - Unisex" );
        var response =
                given().body(payload).when().put(browseUrl).then();
        response.log().body();
    }

    //read the info
    @Test
    public void getProduct(){
        String browseUrl = "http://localhost:80/api_testing/product/read_one.php";
        var response =
                given().queryParam("id", "23").when().get(browseUrl).then();
        response.log().body();
    }

    //delete product
    @Test
    public void deleteProduct(){
        String browseUrl = "http://localhost:80/api_testing/product/delete.php";
        var response =
                given().queryParam("id",20).when().delete(browseUrl).then();
        response.log().body();
    }

    //get multivitamin product, id :18, verify> status code, content type header, body eachfield
    @Test
    public void getMultiVitamin(){
        String browseUrl = "http://localhost:80/api_testing/product/read_one.php";

        given().
                queryParam("id","18").
        when().
                get(browseUrl).
        then().
                log().
                    body().
                assertThat().
                    statusCode(200).
                    header("Content-Type", equalTo("application/json")).
                    body("id", equalTo("18")).
                    body("name", equalTo("Multi-Vitamin (90 capsules)")).
                    body("description", equalTo("A daily dose of our Multi-Vitamins fulfills a day’s nutritional needs for over 12 vitamins and minerals.")).
                    body("price", equalTo( "10.00")).
                    body("category_id", equalTo( "4")).
                    body("category_name", equalTo( "Supplements"));


    }


}
