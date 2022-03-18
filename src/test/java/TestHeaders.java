import Entities.BaseClass;
import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestHeaders extends BaseClass {
    CloseableHttpClient client;
    CloseableHttpResponse response;

    @BeforeMethod
    public void setup(){
        client = HttpClientBuilder.create().build();
    }
    @AfterMethod
    public void tearDown() throws IOException {
        client.close();
        response.close();
    }

    @Test
    public void TestContentTypeHeader () throws IOException {
        HttpGet get = new HttpGet(BASEPOINT200);

        response = client.execute(get);
        Header contentType = response.getEntity().getContentType();
        Assert.assertEquals(contentType.getValue(), "application/json; charset=utf-8");
    }
}
//is header present - HomeWork