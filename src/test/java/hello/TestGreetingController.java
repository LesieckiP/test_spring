package hello;

import org.hamcrest.Matchers;
import org.junit.Test;
import io.restassured.response.ValidatableResponse;
import static io.restassured.RestAssured.given;

public class TestGreetingController {

    @Test
    public void restAssuredTest() {
        ValidatableResponse response =
                given().queryParam("type", "json").when()
                        .get("http://localhost:8080/greeting").then();
        System.out.println("Response is - "+response.extract().body().asString());
        response.body(Matchers.containsString("Hello,"));
    }
}