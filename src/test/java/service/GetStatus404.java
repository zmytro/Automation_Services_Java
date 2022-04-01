package service;

import Entities.BaseClass;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

public class GetStatus404 extends BaseClass {
    CloseableHttpClient client;
    CloseableHttpResponse response;
    @DataProvider
    private Object[][] endpoints(){
        return new Object[][]{
                {"/user"},
                {"/user/followers"},
                {"/notifications"}
        };
    }

    @BeforeMethod
    public void setup(){
         client = HttpClientBuilder.create().build();
    }
    @AfterMethod
    public void tearDown() throws IOException {
        client.close();
        response.close();
    }

    @Test(dataProvider = "endpoints")
    public void Test401 (String endpoint) throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT+endpoint);


        System.out.println(client.execute(get));

        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        System.out.println("Status:" + actualStatus);

        Assert.assertEquals(actualStatus, 401);
    }
    @Test
    public void Test200 () throws IOException {
        HttpGet get = new HttpGet(BASEPOINT200);
        client = HttpClientBuilder.create().build();

        System.out.println(client.execute(get));
        response = client.execute(get);

        int actualStatus = response.getStatusLine().getStatusCode();
        System.out.println("Status:" + actualStatus);

        Assert.assertEquals(actualStatus, 200);
    }
    @Test
    public void Test401 () throws IOException {
        HttpGet get = new HttpGet(BASEPOINT401);
        client = HttpClientBuilder.create().build();

        System.out.println(client.execute(get));
        response = client.execute(get);

        int actualStatus = response.getStatusLine().getStatusCode();
        System.out.println("Status:" + actualStatus);

        Assert.assertEquals(actualStatus, 401);
    }

    @Test
    public void Test404 () throws IOException {
        HttpGet get = new HttpGet(BASEPOINT404);
        client = HttpClientBuilder.create().build();

        System.out.println(client.execute(get));
        response = client.execute(get);

        int actualStatus = response.getStatusLine().getStatusCode();
        System.out.println("Status:" + actualStatus);

        Assert.assertEquals(actualStatus, 404);
    }
}
