package restAssuredTraining;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PracticeClass {
//
//    //String oauth_consumer_key ="";
//
//    @BeforeClass
//    public void setup(){
//
//        RestAssured.baseURI="https://api.twitter.com";
//        RestAssured.basePath="/1.1/statuses";
//
//    }
//
//    @Test (priority=1)
//    public void postRequest(){
//        given()
//                .auth()
//                .oauth()
//                .queryParam("status", "My First post")
//        .when()
//                .post("/update.json")
//        .then()
//                .statusCode(200)
//                .extract()
//                .response();
//
//
//
//
//    }

    @Test
    public void reverseString(){
        String str="Hey world";
        String reverse= new StringBuilder(str).reverse().toString();
        System.out.println(reverse);


    }

}
