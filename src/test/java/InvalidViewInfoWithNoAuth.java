import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

public class InvalidViewInfoWithNoAuth {

    String token = "notValid123";
    private static ResponseSpecification responseSpec;
    @BeforeClass
    public static void checkStatusCodeAndRespContentType()
    {
        responseSpec = new ResponseSpecBuilder().
                expectResponseTime(lessThan(3000L)) //-> L = milliseconds
                .build();

    }

    @Test
    public void BodyMatchesError()
    {
        given()
                .header("Authorization", "Bearer " + token)
                .when().
                      get("https://api.spotify.com/v1/me").
                then().spec(responseSpec).
                and()
                .assertThat()
                .body("$", hasKey("error"));
    }

    @Test
    public void statusCodeNotOk()
    {  given()
            .header("Authorization", "Bearer " + token)
            .when().
            get("https://api.spotify.com/v1/me").
            then().spec(responseSpec).
            and()
            .assertThat()
            .statusCode(both(greaterThanOrEqualTo(400)).and(lessThanOrEqualTo(405)));

    }
}
