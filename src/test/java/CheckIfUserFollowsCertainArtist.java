import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class CheckIfUserFollowsCertainArtist extends BaseTests {



    @Test(dataProvider = "followingListData", dataProviderClass = ProvidersClass.class)
    public void checkIfUserFollowsCertainArtistValidScenario(String type, String ids)
    {
        given()
                .header("Authorization", "Bearer " + token)
                .header("Accept", "application/json")
                .queryParam("type",type)
                .queryParam("ids",ids)
                .when()
                .get("https://api.spotify.com/v1/me/following/contains")
                .then()
                .log().body()
                .assertThat()
                .body("[0]", equalTo(true));
    }


    @Test(dataProvider = "providingQuesrParamTypeAndIds", dataProviderClass = ProvidersClass.class)
    public void checkResponseStatusCode(String type, String ids)
    {
        given()
                .header("Authorization", "Bearer " + token)
                .header("Accept", "application/json")
                .queryParam("type",type)
                .queryParam("ids",ids)
                .when()
                .get("https://api.spotify.com/v1/me/following/contains")
                .then().spec(responseSpec);
    }


}
