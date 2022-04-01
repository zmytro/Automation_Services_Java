package service;

import Entities.BaseClass;
import Entities.ResponseUtils;
import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

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

    @Test
    public void TestContentTypeHeaderMIME () throws IOException {
        HttpGet get = new HttpGet(BASEPOINT200);

        response = client.execute(get);
      //  Header contentType = response.getEntity().getContentType();

        ContentType ct = ContentType.getOrDefault(response.getEntity());
        Assert.assertEquals(ct.getMimeType(),"application/json");
        //Assert.assertEquals(contentType.getValue(), "application/json; charset=utf-8");
    }

    @Test
    public void TestXRateLimitHeader () throws IOException {
        HttpGet get = new HttpGet(BASEPOINT200);

        response = client.execute(get);

        String headerValue = ResponseUtils.getHeader(response,"x-ratelimit-limit");

        Assert.assertEquals(headerValue,"60");

    }

    @Test
    public void HeaderPresent () throws IOException {
        HttpGet get = new HttpGet(BASEPOINT200);

        response = client.execute(get);

        assertTrue(ResponseUtils.headerIsPresent(response,"X-GitHub-Media-Typ"));

    }

    @Test
    public void returnCorrectID() throws IOException{
        HttpGet get = new HttpGet(BASE_ENDPOINT+"/users/zmytro");

        response = client.execute(get);

        String jsonBody = EntityUtils.toString(response.getEntity());

        JSONObject jsonObject = new JSONObject(jsonBody);

        //Integer idValue = (Integer) getValueFor(jsonObject, ID);

       // Assert.assertEquals(idValue, Integer.valueOf(80679981));
    }
}
//is header present - HomeWork

//TODO попробовать сделать метод GetHeaders через Stream