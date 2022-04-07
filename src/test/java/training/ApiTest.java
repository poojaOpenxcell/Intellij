package training;

import dataFile.Product;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;


import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class ApiTest {

    //get all response i.e. header and body
    @Test
    public void getCategories(){
        String browseUrl = "http://localhost:80/api_testing/category/read.php";
        var response = given().when().get(browseUrl).then();
        response.log().all();

    }

    //getting response with query param
    @Test
    public void getProducts(){
        String browseUrl = "http://localhost:80/api_testing/product/read_one.php";
        var response =
                        given().queryParam("id",2).when().get(browseUrl).then();
        response.log().body();

    }

    // post request with payload > creating product
    @Test
    public void postProduct() {
        String browseUrl = "http://localhost:80/api_testing/product/create.php";
        String payload = "{\n" +
                "                    \"name\": \"Poncho\",\n" +
                "                    \"description\": \"Fashionable product for women\",\n" +
                "                    \"price\": 550,\n" +
                "                    \"category_id\": 2,\n" +
                "                    \"category_name\": \"Active Wear - Women\"\n" +
                "                }";
        var response =
                given().body(payload).when().post(browseUrl).then();
        response.log().body();

    }

    //getting all products
    @Test
    public void getAllProducts(){
        String browseUrl = "http://localhost:80/api_testing/product/read.php";
        var response =
                given().when().get(browseUrl).then();
        response.log().body();

    }

    // updating product with payload using put method
    @Test
    public void putProduct(){
        String browseUrl ="http://localhost:80/api_testing/product/update.php";
        String payload = "" +
                "{\n" +
                "            \"id\": \"21\",\n" +
                "            \"name\": \"Poncho\",\n" +
                "            \"description\": \"Fashionable product for women\",\n" +
                "            \"price\": \"750.00\",\n" +
                "            \"category_id\": \"2\",\n" +
                "            \"category_name\": \"Active Wear - Women\"\n" +
                "        }";
        var response =
                given().body(payload).when().put(browseUrl).then();
        response.log().body();
    }

    //deleting product with payload
    @Test
    public void deleteProduct(){
        String browseUrl = "http://localhost:80/api_testing/product/delete.php";
        String payload = "{\n" +
                "            \"id\":\"20\"\n" +
                "        }";
        var response =
                given().body(payload).when().delete(browseUrl).then();
        response.log().body();

    }

    //serialise product form different class plus given payload
    @Test
    public void serialiseProduct(){
        String browseUrl = "http://localhost:80/api_testing/product/create.php";
        Product payload = new Product("French Tie", "Tie for both men and women", 250, 3);

        var response = given().body(payload).when().post(browseUrl).then();
        response.log().body();

    }


    @Test
    public void postLogin(){

        String browseURL= "https://api-stripe-eu.test.jeev.es/v2/web/user/login";

        String payload = "{\n" +
                "    \"email\": \"pooja+24@tryjeeves.com\",\n" +
                "    \"password\": \"Poo11\",\n" +
                "    \"isBlockedTwoFactorAuth\": false,\n" +
                "    \"blockedTwoFactorAuth\": \"\",\n" +
                "    \"ipAddress\": \"3.128.57.106\"\n" +
                "}";


        Map<String,Object> headerMap = new HashMap<String,Object>();
        headerMap.put("Accept", "application/json");
        headerMap.put("Origin", "https://client-stripe-eu.test.jeev.es");
        headerMap.put("Referer", "https://client-stripe-eu.test.jeev.es/");
        headerMap.put("x-client-address", "3.128.57.106");
        headerMap.put("platform-type", "webapp");
        headerMap.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:98.0) Gecko/20100101 Firefox/98.0");
        headerMap.put("Sec-Fetch-Dest", "empty");
        headerMap.put("Sec-Fetch-Mode", "same-site");
        headerMap.put("TE", "trailers");
        headerMap.put("Connection", "keep-alive");

        given().
                headers(headerMap).
                body(payload).

        when().
                get(browseURL).

        then().
                log().headers().statusCode(200);


    }


    @Test
    public void SATCron(){

        given().when().get("https://api-stripe-eu.test.jeev.es/cron/pull-satws-invoices").then().log().body();

    }



}
