import io.restassured.RestAssured;
import io.restassured.response.Response;

public class AuthClass {
    public String accessToken;

    public AuthClass() {
        // Set the value of the access_token environment variable
        this.accessToken = "BQDEgJPamhe6qhsbwQpN3vuZIm1UozGWLAKnppfR5dheHkuKv7-IdsvGveY8TDotalXKUebNrvN0ZZhffrd5kxK87FCeW2m8Vv1qQJ4abdFjdfpxJtUgiVPx0nblh6aWmpoofzRtKzA67RHA3gQeVhiEXTIBaOOh_w3Q0RpLQgPbBx0oDQzjS6DVOpzUMDBzVFSl-hI868q1wq9IAD2cn_Y3bkbijj5mA4uQ3jgfPdHDgtHUx_JW5TvMi4jD4jLUXMNmbE8auhrYFAVkSjH7RvTqicAV0AQQSQLdBwOhFk4";
        System.setProperty("access_token", accessToken);
    }
    // Getter method to retrieve the access token
    public String getAccessToken() {
        return accessToken;
    }



}
