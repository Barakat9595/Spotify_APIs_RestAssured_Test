import io.restassured.RestAssured;
import io.restassured.response.Response;

public class AuthClass {
    public String accessToken;

    public AuthClass() {
        //  environment variable
        this.accessToken = "BQBEmQzhYkl2VSGv5kfakMjlvaGR4T3tGsl9Pb7qLfpUUBVmvb4EuhbM9GTYyyAgceRKuNNIpvlcDR0vBieZiqUDOCdeb8rSSAfZcwb9rGUFTu6x6iykODdhphqrrEs9_vRpIC_gWVZcJ7MiUskF8wyqYoyO0kctdyrQ9yYWyhn9Z0FA9ekKeDi8wUALXyHepZ06y83ti1PPkPg8tt6p3ZRyCLttPW4TULC5BhzaIXQ4PTLCNX3ImgfItwY719SgXqfS8HeF3qUUVMlhXIrs8V4ltWHARjApZCXznR9ELsg";

        System.setProperty("access_token", accessToken);
    }
    // Getter method to retrieve the access token
    public String getAccessToken() {
        return accessToken;
    }



}
