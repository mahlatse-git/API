package inspiredtesting;

import io.restassured.RestAssured;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
public class RestAssuredAPIs {
    @Test
    public void createPost(){
        RestAssured.baseURI = "http://jsonplaceholder.typicode.com";

        JSONObject jsonRequest = new JSONObject();
        jsonRequest.put("PostId","1");
        jsonRequest.put("Name","Mahlatse");
        jsonRequest.put("Email","mahlatsemoses@gmail.com");
        jsonRequest.put("Body","02 August 2023");

        given().log().method().
                when().
                body(jsonRequest.toJSONString()).
                post("/posts").
                then().statusCode(201).
                log().all();

    }
}
