import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;

import static org.hamcrest.Matchers.lessThan;

public class BaseTests {
    protected static ResponseSpecification responseSpec;
    @BeforeClass
    public void checkStatusCodeAndRespContentType()
    {
        responseSpec = new ResponseSpecBuilder().
                expectStatusCode(200).
                expectContentType(ContentType.JSON).
                expectResponseTime(lessThan(3000L)) //-> L = milliseconds
                .build();


    }
}
