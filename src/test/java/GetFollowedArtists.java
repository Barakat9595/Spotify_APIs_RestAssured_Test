import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.lessThan;

public class GetFollowedArtists extends BaseTests {





    @Test
    public void checkIfListCotainsFollowedArtist() {
        given()
                .header("Authorization", "Bearer " + token)
                .header("Accept", "application/json")
                .queryParam("type", "artist")
                .when()
                .get("https://api.spotify.com/v1/me/following")
                .then()
                .log().body()
                .assertThat()
                .body("artists.items.name", hasItem("Ramy Gamal"));
    }

    @Test
    public void checkResponseProperties()
    {
        given()
                .header("Authorization", "Bearer " + token)
                .header("Accept", "application/json")
                .queryParam("type", "artist")
                .when()
                        .get("https://api.spotify.com/v1/me/following")
                .then().
                log().body()
                .spec(responseSpec);
    }


}
