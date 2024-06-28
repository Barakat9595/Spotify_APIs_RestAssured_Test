import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static java.util.function.Predicate.not;

import static org.hamcrest.Matchers.*;


public class CheckIfArtistIsUnfollowed extends BaseTests{


    @Test
    public void checkIfListDoesNotCotainFollowedArtist() {
        given()
                .header("Authorization", "Bearer " + token)
                .header("Accept", "application/json")
                .queryParam("type", "artist")
                .when()
                .get("https://api.spotify.com/v1/me/following")
                .then()
                .assertThat()
                .body("artists.items.name", Matchers.not(Matchers.hasItem("Ramy Gamal")));
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
                .then()
                .spec(responseSpec);
    }

}
