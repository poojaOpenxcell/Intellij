package swaggerEditor;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.config.LogConfig;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;


public class RestAPI {

    @Test
    public void postPet() {

        Map<String,Object> headerMap = new HashMap<String, Object>();
        headerMap.put("authorization", "89bf946b-1c5c-425c-ab56-6eb75d156f20");
        headerMap.put("Content-Type", "application/json");
        headerMap.put("accept", "application/json");


        RequestSpecification reqSpec = given()

                .baseUri("https://petstore.swagger.io")
                .basePath("/v2/pet")
                .headers(headerMap);

        File jsonPayload = new File("src/main/resources/restjson.js");


        given(reqSpec).
               config(config.logConfig(LogConfig.logConfig().blacklistHeader("Content-Type"))).
                body(jsonPayload).when().post().then().log().all();

    }

    @Test
    public void loginParam(){

        Map<String, Object> creds = new HashMap<String, Object>();
        creds.put("username", "");
        creds.put("password", "");
        
        RequestSpecification reqSpec = given()
                .baseUri("https://petstore.swagger.io")
                .basePath("/v2/user/login")
                .queryParams(creds);

        given(reqSpec).when().get().then().log().ifError().assertThat().statusCode(200).header("Content-Type", equalTo("application/json"));

    }

    @Test
    public void uploadFile(){

        File file = new File("/Users/Pooja/Downloads/openXcell_logo_1.png");

        Response response = given()
                .multiPart("file", file, "multipart/form-data")
                .when()
                .post("https://the-internet.herokuapp.com/upload")
                .thenReturn();

        System.out.println(response);


    }



}
