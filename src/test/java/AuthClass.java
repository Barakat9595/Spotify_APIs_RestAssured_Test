import io.restassured.RestAssured;
import io.restassured.response.Response;

public class AuthClass {
    public static String accessToken;

    public AuthClass(String accessToken) {
        //  environment variable
        this.accessToken =  accessToken;

    }
    // Getter method to retrieve the access token
    public static String getAccessToken() {
        return accessToken;
    }



}
