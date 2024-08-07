import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class UnfollowArtist extends BaseTests {



    private static ResponseSpecification responseSpec;
    @BeforeClass
    public static void checkSRespContentType()
    {

            responseSpec = new ResponseSpecBuilder().
                    expectContentType(ContentType.JSON).
                    expectResponseTime(lessThan(3000L)) //-> L = milliseconds
                    .build();
    }



    @Test(dataProvider = "providingQuesrParamTypeAndIds", dataProviderClass = ProvidersClass.class)
    public void checkStatusCode(String type, String ids)
    {
        given()
                .header("Authorization", "Bearer " + token)
                .header("Accept", "application/json")
                .queryParam("type",type)
                .queryParam("ids",ids)
                .when()
                .delete("https://api.spotify.com/v1/me/following")
                .then()
                .assertThat().statusCode(equalTo(200)); //-> bug
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
