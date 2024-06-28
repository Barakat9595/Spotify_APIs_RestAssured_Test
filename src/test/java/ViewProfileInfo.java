import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

public class ViewProfileInfo {

    //creating an instance of the class AuthClass to be able to use the token

    String token = AuthClass.getAccessToken();


    private static ResponseSpecification responseSpec;
    @BeforeClass
    public static void checkStatusCodeAndRespContentType()
    {
        responseSpec = new ResponseSpecBuilder().
                expectContentType(ContentType.JSON).
                expectResponseTime(lessThan(3000L)) //-> L = milliseconds
                .build();

    }


@Test
    public void diplayProfileName()
{

    //String token = System.getenv("access_token");
    System.out.println("Access Token: " + token);

    given()
            .header("Authorization", "Bearer " + token)
            .header("Accept", "application/json")
            .when()
                .get("https://api.spotify.com/v1/me")
            .then()
            .log().all()
                .spec(responseSpec)
            .and()
                .assertThat()
                .body("display_name", equalTo("Mahmoud Abdul-Fattah Barakat"));


}


}
