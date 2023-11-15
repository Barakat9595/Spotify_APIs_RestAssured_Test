import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class FollowingArtist {

    AuthClass authClass = new AuthClass();
    String token = authClass.getAccessToken();

    private static ResponseSpecification responseSpec;
    @BeforeClass
    public static void checkSRespContentType()
    {
        responseSpec = new ResponseSpecBuilder().
                expectContentType(ContentType.JSON).
                expectResponseTime(lessThan(3000L)) //-> L = milliseconds
                .build();

    }
    @DataProvider
    public static Object[][] providingQuesrParamTypeAndIds() {
        return new Object[][]{
                {"artist","5miyPYjh5EcpOSqloDJPID"}
        };
    }

    @Test(dataProvider = "providingQuesrParamTypeAndIds")
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
