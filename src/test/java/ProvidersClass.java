import org.testng.annotations.DataProvider;

public class ProvidersClass {
    @DataProvider(name = "dataOfFollowing")
    public static Object[][] getData() {
        return new Object[][]{
                {"artist","5miyPYjh5EcpOSqloDJPID"}
        };
    }


    @DataProvider(name = "followingListData")
    public static Object[][] data() {
        return new Object[][]{
                {"artist","5abSRg0xN1NV3gLbuvX24M"}
        };
    }

    @DataProvider(name = "typeAndIds")
    public static Object[][] typeAndIds() {
        return new Object[][]{
                {"artist","5miyPYjh5EcpOSqloDJPID"}
        };
    }

    @DataProvider
    public static Object[][] providingItem() {
        return new Object[][]{
                {"tracks"}
        };
    }

    @DataProvider
    public static Object[][] providingQuesrParamTypeAndIds() {
        return new Object[][]{
                {"artist","5miyPYjh5EcpOSqloDJPID"}
        };
    }

}
