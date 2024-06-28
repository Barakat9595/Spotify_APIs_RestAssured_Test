import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class FollowingArtist extends BaseTests{






    @Test(dataProvider = "dataOfFollowing", dataProviderClass = ProvidersClass.class)
    public void checkStatusCode(String type, String ids)
    {
         given()
                    .header("Authorization", "Bearer " + token)
                    .header("Accept", "application/json")
                    .queryParam("type",type)
                    .queryParam("ids",ids)
                .when()
                    .put("https://api.spotify.com/v1/me/following")
                .then()
                 .log().body()
                    .assertThat().statusCode(equalTo(204));
    }


}
