import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class GettingUserTopTrack extends BaseTests {
    AuthClass authClass = new AuthClass();
    String token = authClass.getAccessToken();


    @Test(dataProvider = "providingItem", dataProviderClass = ProvidersClass.class)
    public void checkTopTrackName(String type) {
        given()
                .pathParams("type", type)
                .header("Authorization", "Bearer " + token)
                .header("Accept", "application/json")
                .log().all()
                .when()
                .get("https://api.spotify.com/v1/me/top/{type}")
                .then()
                .spec(responseSpec)
                .log().all()// Use the response specification
                .assertThat()
                .body("items[0].name", equalTo("Adrenaline"));
    }
}
